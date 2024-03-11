package com.classMongo.bookings.exception;

import static com.classMongo.bookings.utils.Constants.TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE;

public class TokenExpiredException extends ServerErrorException {

    public TokenExpiredException() {
        super(TOKEN_EXPIRED_MALFORMED_ERROR_MESSAGE);
    }

}

