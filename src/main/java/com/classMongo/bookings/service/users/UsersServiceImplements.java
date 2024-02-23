package com.classMongo.bookings.service.users;

import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersMapper;
import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UsersServiceImplements implements UsersService{

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<UsersResponseDto> getAllUsers() {
        List<UsersResponseDto> usersResponseDtos = new ArrayList<>();
        usersRepository.getAllUsers().forEach(users -> usersResponseDtos.add(UsersMapper.userToUserResponseDto(users)));
        return usersResponseDtos;
    }

    @Override
    public UsersResponseDto findUsersById(String id) {
            return UsersMapper.userToUserResponseDto(usersRepository.findUsersById(id));
    }

    @Override
    public UsersResponseDto createUsers(UsersDto usersDto) {
        return UsersMapper.userToUserResponseDto(usersRepository.createUsers(UsersMapper.userDtoToUser(usersDto)));
    }

    @Override
    public Boolean updateUsers(String id, UsersDto usersDto) {
        return usersRepository.updateUsers(id, UsersMapper.userDtoToUser(usersDto));
    }

    @Override
    public Boolean deleteUsers(String id) {
        return usersRepository.deleteUsers(id);
    }

}
