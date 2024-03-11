package com.classMongo.bookings.security.jwt;

import com.classMongo.bookings.dto.users.TokenDto;
import com.classMongo.bookings.model.user.Users;

public interface OperationJwt {
    TokenDto generateTokenDto(Users user);
}
