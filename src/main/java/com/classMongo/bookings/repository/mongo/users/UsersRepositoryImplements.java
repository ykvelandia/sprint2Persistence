package com.classMongo.bookings.repository.mongo.users;

import com.classMongo.bookings.model.Users;
import com.classMongo.bookings.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UsersRepositoryImplements  implements UsersRepository {
    @Autowired
    private UsersMongoRepository usersMongoRepository;

    @Override
    public List<Users> getAllUsers() {
        return usersMongoRepository.findAll();
    }

    @Override
    public Users findUsersById(String id) {
        return usersMongoRepository.findById(id).get();
    }

    @Override
    public Users createUsers(Users users) {
        return usersMongoRepository.save(users);
    }

    @Override
    public Boolean updateUsers(String id, Users users) {
        Users usersFound = findUsersById(id);
        if (usersFound != null){
            usersFound.updateUsers(users);
            usersMongoRepository.save(usersFound);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Boolean deleteUsers(String id) {
        Users userFound = findUsersById(id);
        if (userFound != null) {
            usersMongoRepository.delete(userFound);
            return true;
        }else{
            return false;
        }
    }
}
