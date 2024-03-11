package com.classMongo.bookings.controller.auth;

import com.classMongo.bookings.dto.users.LoginDto;
import com.classMongo.bookings.dto.users.TokenDto;
import com.classMongo.bookings.exception.InvalidCredentialsException;
import com.classMongo.bookings.exception.UserNotFoundException;
import com.classMongo.bookings.model.user.Users;
import com.classMongo.bookings.security.encrypt.PasswordEncryptionService;
import com.classMongo.bookings.security.jwt.OperationJwt;
import com.classMongo.bookings.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {

    private final UsersService userService;
    private final PasswordEncryptionService passwordEncryptionService;
    private final OperationJwt operationJwt;

    @Autowired
    public AuthController(UsersService userService, PasswordEncryptionService passwordEncryptionService, OperationJwt operationJwt) {
        this.userService = userService;
        this.passwordEncryptionService = passwordEncryptionService;
        this.operationJwt = operationJwt;
    }

    @PostMapping
    public ResponseEntity<TokenDto> login(@RequestBody LoginDto loginDto){
        Users userFound = userService.findByEmail(loginDto.getEmail());
        if (userFound == null){
            throw new UserNotFoundException(loginDto.getEmail());
        }

        //UserResponseDto user = optionalUser.get();

        if (passwordEncryptionService.isPasswordMatch(loginDto.getPassword(), userFound.getPassword())){
            return new ResponseEntity<>(operationJwt.generateTokenDto(userFound), HttpStatus.OK);
        }else {
            throw new InvalidCredentialsException();
        }

    }

}
