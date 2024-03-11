package com.classMongo.bookings.exception;

public class InvalidCredentialsException extends ServerErrorException {

    public InvalidCredentialsException() {
        super("invalid username or password");
    }
}
