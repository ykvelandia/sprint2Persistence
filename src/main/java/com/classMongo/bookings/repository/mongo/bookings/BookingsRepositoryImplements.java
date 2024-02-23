package com.classMongo.bookings.repository.mongo.bookings;

import com.classMongo.bookings.model.Bookings;
import com.classMongo.bookings.repository.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class BookingsRepositoryImplements implements BookingsRepository{
    @Autowired
    private BookingsMongoRepository bookingsMongoRepository;

    @Override
    public List<Bookings> getAllBookings() {
        return bookingsMongoRepository.findAll();
    }

    @Override
    public Bookings findBookingsById(String id) {
        return bookingsMongoRepository.findById(id).get();
    }

    @Override
    public Bookings createBookings(Bookings bookings) {
        return bookingsMongoRepository.save(bookings);
    }

    @Override
    public Boolean updateBookings(String id, Bookings bookings) {
        Bookings bookingsFound = findBookingsById(id);
        if (bookingsFound != null){
            bookingsFound.updateBookings(bookings);
            bookingsMongoRepository.save(bookings);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public Boolean deleteBooking(String id) {
        Bookings bookingsFound = findBookingsById(id);
        if (bookingsFound != null){
            bookingsMongoRepository.delete(bookingsFound);
            return true;
        }else{
            return false;
        }

    }
}
