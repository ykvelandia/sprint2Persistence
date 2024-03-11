package com.classMongo.bookings.security.jwt;

import com.classMongo.bookings.dto.users.TokenDto;
import com.classMongo.bookings.model.user.Users;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.Calendar;
import java.util.Date;

import static com.classMongo.bookings.utils.Constants.CLAIMS_ROLES_KEY;


@Component
public class OperationJwtImpl implements OperationJwt{

    @Value("${jwt.secret}")
    String secret;

    private String generateToken(Users user, Date expirationDate){
        return Jwts.builder()
                .setSubject(user.getId()).claim(CLAIMS_ROLES_KEY, user.getRoles())
                .setIssuedAt(new Date())
                .setExpiration(expirationDate)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public TokenDto generateTokenDto(Users user){
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add(Calendar.MINUTE, 30);
        String token = generateToken(user, expirationDate.getTime());
        return new TokenDto(token, expirationDate.getTime());
    }

}
