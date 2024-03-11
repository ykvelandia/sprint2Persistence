package com.classMongo.bookings.dto.users;

import com.classMongo.bookings.model.user.Users;

public class UsersMapper {
    public static UsersResponseDto userToUserResponseDto(Users user){
        return new UsersResponseDto(
                user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public static Users userDtoToUser (UsersDto userDto){
        return new Users(
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getBirthDate(),
                userDto.getEmail(),
                userDto.getPassword()
        );
    }

    public static Users userResponseDtoToUser(UsersResponseDto userResponseDto){
        return new Users(
                userResponseDto.getFirstName(),
                userResponseDto.getLastName(),
                userResponseDto.getBirthDate(),
                userResponseDto.getEmail(),
                userResponseDto.getPassword()
        );
    }
    public static UsersDto userToUserDto (Users user){
        return new UsersDto(
                user.getFirstName(),
                user.getLastName(),
                user.getBirthDate(),
                user.getEmail(),
                user.getPassword()
        );
    }
}