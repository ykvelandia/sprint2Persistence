package com.classMongo.bookings.repository.mongo.bookings;

import com.classMongo.bookings.model.Bookings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingsMongoRepository extends MongoRepository <Bookings,String> {
}
