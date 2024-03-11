package com.classMongo.bookings.security;

import io.jsonwebtoken.*;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.classMongo.bookings.utils.Constants.*;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

    private final String secret;

    public JwtRequestFilter(@Value("${jwt.secret}") String secret) {
        this.secret = secret;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        if (request.getRequestURI().equals("/v1/auth") || request.getRequestURI().equals("/health")){
            filterChain.doFilter(request, response);
        } else if (request.getRequestURI().equals("/v2/api-docs") ||
                request.getRequestURI().equals("/configuration/ui") ||
                request.getRequestURI().matches("/swagger-resources.*") ||
                request.getRequestURI().equals("/configuration/security") ||
                request.getRequestURI().equals("/swagger-ui.html") ||
                request.getRequestURI().equals("/webjars") ||
                request.getRequestURI().matches("/swagger-ui/.*")){
            filterChain.doFilter(request, response);
        } else if (HttpMethod.OPTIONS.name().equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request, response);
        } else {
            try {
                if (authHeader == null || !authHeader.startsWith("Bearer ")){
                    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), MISSING_TOKEN_ERROR_MESSAGE);
                    return;
                }

                String token = authHeader.substring(7);
                Jws<Claims> claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
                Claims claimsBody = claims.getBody();
                String subject = claimsBody.getSubject();
                List<String> roles = claims.getBody().get(CLAIMS_ROLES_KEY, ArrayList.class);

                if (roles == null){
                    response.sendError(HttpStatus.UNAUTHORIZED.value(), MISSING_TOKEN_ERROR_MESSAGE);
                    return;
                }

                TokenAuthentication authentication = new TokenAuthentication(token, subject, roles);
                SecurityContextHolder.getContext().setAuthentication(authentication);

                request.setAttribute("claims", claimsBody);
                request.setAttribute("jwtUserId", subject);
                request.setAttribute("jwtUserRoles", roles);
                response.setStatus(HttpServletResponse.SC_OK);
            } catch (MalformedJwtException e){
                response.sendError(HttpStatus.BAD_REQUEST.value(), MISSING_TOKEN_ERROR_MESSAGE);
            } catch (ExpiredJwtException | SignatureException e){
                response.sendError(HttpStatus.UNAUTHORIZED.value(), TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE);
            }

            filterChain.doFilter(request, response);
        }
    }
}