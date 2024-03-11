package com.classMongo.bookings.repository.user;

import com.classMongo.bookings.model.user.Users;

import java.util.List;
import java.util.Optional;

public interface UsersRepository {
    List<Users> getAllUsers();
    Users findUserById(String idUser);
    Optional<Users> findByEmail(String email);
    Users createUser(Users user);
    Users saveUser(Users user);
    Boolean updateUser(String idUser, Users user);
    Boolean deleteUserById(String idUser);
}
