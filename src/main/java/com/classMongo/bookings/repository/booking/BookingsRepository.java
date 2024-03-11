package com.classMongo.bookings.repository.booking;

import com.classMongo.bookings.model.booking.Bookings;

import java.util.List;

public interface BookingsRepository {
    List<Bookings> getAllBookings();
    Bookings findBookingsById(String id);
    Bookings createBookings(Bookings bookings);
    Boolean updateBookings(String id,Bookings bookings);
    Boolean deleteBooking(String id);

}
