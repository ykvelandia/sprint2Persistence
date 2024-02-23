package com.classMongo.bookings.repository.mongo.users;

import com.classMongo.bookings.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsersMongoRepository extends MongoRepository <Users,String>  {
}
