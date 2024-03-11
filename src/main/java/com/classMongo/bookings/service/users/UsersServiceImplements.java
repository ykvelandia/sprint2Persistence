package com.classMongo.bookings.service.users;

import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersMapper;
import com.classMongo.bookings.dto.users.UsersResponseDto;
import com.classMongo.bookings.model.user.RoleEnum;
import com.classMongo.bookings.model.user.Users;
import com.classMongo.bookings.repository.user.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class UsersServiceImplements implements UsersService{

    @Autowired
    private UsersRepository usersRepository;
    @Override
    public List<UsersResponseDto> getAllUsers() {
        List<UsersResponseDto>usersResponseDtoList = new ArrayList<>();
        usersRepository.getAllUsers().forEach(users -> usersResponseDtoList.add(UsersMapper.userToUserResponseDto(users)));
        return usersResponseDtoList;
    }

    @Override
    public UsersResponseDto findUserById(String id) {
        return UsersMapper.userToUserResponseDto(usersRepository.findUserById(id));
    }

    @Override
    public Users findByEmail(String email) {
        Users userFound = usersRepository.findByEmail(email).get();
        if (userFound != null){
            return userFound;
        }
        return null;
    }

    @Override
    public UsersResponseDto createUser(UsersDto userDto) {
        return UsersMapper.userToUserResponseDto(usersRepository.createUser(UsersMapper.userDtoToUser(userDto)));
    }

    @Override
    public UsersResponseDto createUserAdmin(UsersDto userDto) {
        Users userAdmin = UsersMapper.userDtoToUser(userDto);
        userAdmin.addRole(RoleEnum.ADMIN);
        return UsersMapper.userToUserResponseDto(usersRepository.createUser(userAdmin));
    }

    @Override
    public UsersResponseDto saveUser(UsersDto userDto) {
        return UsersMapper.userToUserResponseDto(usersRepository.saveUser(UsersMapper.userDtoToUser(userDto)));
    }

    @Override
    public Boolean updateUser(String id, UsersDto userDto) {
        return usersRepository.updateUser(id, UsersMapper.userDtoToUser(userDto));
    }

    @Override
    public Boolean deleteUser(String id) {
        return usersRepository.deleteUserById(id);
    }
}
