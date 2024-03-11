package com.classMongo.bookings.repository.booking.mongodb;

import com.classMongo.bookings.model.booking.Bookings;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingsMongoRepository extends MongoRepository <Bookings,String> {
}
