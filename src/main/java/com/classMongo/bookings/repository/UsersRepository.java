package com.classMongo.bookings.repository;

import com.classMongo.bookings.model.Users;

import java.util.List;

public interface UsersRepository {
    List<Users> getAllUsers();
    Users findUsersById(String id);
    Users createUsers(Users users);
    Boolean updateUsers(String id, Users users);
    Boolean deleteUsers(String id);

}
