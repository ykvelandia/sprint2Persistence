package com.classMongo.bookings.repository.user.mongodb;

import com.classMongo.bookings.model.user.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UsersMongoRepository extends  MongoRepository<Users, String> {
        Optional<Users> findByEmail(String email);
}
