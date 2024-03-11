package com.classMongo.bookings.service.users;

import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.model.user.Users;

import java.util.List;

public interface UsersService {
    List<UsersResponseDto> getAllUsers();
    UsersResponseDto findUserById(String id);
    Users findByEmail(String email);
    UsersResponseDto createUser(UsersDto userDto);
    UsersResponseDto createUserAdmin(UsersDto userDto);
    UsersResponseDto saveUser(UsersDto userDto);
    Boolean updateUser(String id, UsersDto userDto);
    Boolean deleteUser(String id);
}
