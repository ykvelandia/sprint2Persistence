package com.classMongo.bookings.security.encrypt;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class BCryptPasswordEncryptionService implements PasswordEncryptionService{

    private final BCryptPasswordEncoder passwordEncoder;

    public BCryptPasswordEncryptionService(){
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public String encrypt(String password) {
        return passwordEncoder.encode(password);
    }

    @Override
    public boolean isPasswordMatch(String password, String encryptedPassword) {
        return passwordEncoder.matches(password, encryptedPassword);
    }
}
