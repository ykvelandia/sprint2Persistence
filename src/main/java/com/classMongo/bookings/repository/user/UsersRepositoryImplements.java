package com.classMongo.bookings.repository.user;

import com.classMongo.bookings.model.user.RoleEnum;
import com.classMongo.bookings.model.user.Users;
import com.classMongo.bookings.repository.user.mongodb.UsersMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepositoryImplements  implements UsersRepository {
    @Autowired
    private UsersMongoRepository userMongoRepository;


    @Override
    public List<Users> getAllUsers() {
        return userMongoRepository.findAll();
    }

    @Override
    public Users findUserById(String id) {
        return userMongoRepository.findById(id).orElse(null);
    }

    @Override
    public Optional<Users> findByEmail(String email) {
        Optional<Users> userFound = userMongoRepository.findByEmail(email);
        if (userFound.isPresent()){
            return userFound;
        }else {
            return Optional.empty();
        }
    }

    @Override
    public Users createUser(Users user) {
        return userMongoRepository.save(user);
    }

    @Override
    public Users saveUser(Users user) {
        user.setUserRegistration(LocalDate.now());
        user.addRole(RoleEnum.USER);
        return userMongoRepository.save(user);
    }

    @Override
    public Boolean updateUser(String id, Users user) {
        Users searchUser = findUserById(id);
        if(searchUser != null){
            searchUser.setFirstName(user.getFirstName());
            searchUser.setLastName(user.getLastName());
            searchUser.setBirthDate(user.getBirthDate());
            searchUser.setEmail(user.getEmail());
            searchUser.setPassword(user.getPassword());
            searchUser.setUserRegistration(searchUser.getUserRegistration());

            userMongoRepository.save(searchUser);
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteUserById(String id) {
        Users existingId = findUserById(id);
        if(existingId != null){
            userMongoRepository.delete(existingId);
            return true;
        }
        return false;
    }

}
