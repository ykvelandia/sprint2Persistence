package com.classMongo.bookings.service.bookings;

import com.classMongo.bookings.dto.bookings.BookingsDto;
import com.classMongo.bookings.dto.bookings.BookingsResponseDto;
import com.classMongo.bookings.dto.users.UsersDto;
import com.classMongo.bookings.dto.users.UsersResponseDto;

import java.util.List;

public interface BookingsService {
    List<BookingsResponseDto> getAllBookings();
    BookingsResponseDto findBookingsById(String id);
    BookingsResponseDto createBookings(BookingsDto bookingsDto);
    Boolean updateBookings(String id,BookingsDto bookingsDto);
    Boolean deleteBookings(String id);
}
