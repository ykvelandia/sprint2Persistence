package com.classMongo.bookings.dto.users;

import com.classMongo.bookings.model.Users;

public class UsersMapper {

    public static UsersResponseDto userToUserResponseDto (Users users){
        return new UsersResponseDto(
                users.getId(),
                users.getUsername(),
                users.getEmail(),
                users.getCellphone(),
                users.getBirthDate()
        );
    }
    public static Users userDtoToUser(UsersDto userDto){
        return new Users(
                userDto.getUsername(),
                userDto.getEmail(),
                userDto.getCellphone(),
                userDto.getBirthDate()

        );
    }
}
