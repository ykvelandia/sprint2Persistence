package com.classMongo.bookings.service.users;

import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersResponseDto;

import java.util.List;

public interface UsersService {
    List<UsersResponseDto>getAllUsers();
    UsersResponseDto findUsersById(String id);
    UsersResponseDto createUsers(UsersDto usersDto);
    Boolean updateUsers(String id,UsersDto usersDto);
    Boolean deleteUsers(String id);
}
