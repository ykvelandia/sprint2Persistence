package com.classMongo.bookings.service.bookings;

import com.classMongo.bookings.dto.bookings.BookingsDto;
import com.classMongo.bookings.dto.bookings.BookingsMapper;
import com.classMongo.bookings.dto.bookings.BookingsResponseDto;
import com.classMongo.bookings.repository.booking.BookingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookingsServiceImplements implements BookingsService{

    @Autowired
    private BookingsRepository bookingsRepository;

    @Override
    public List<BookingsResponseDto> getAllBookings() {
        List<BookingsResponseDto> bookingsResponseDtos = new ArrayList<>();
        bookingsRepository.getAllBookings().forEach(bookings -> bookingsResponseDtos.add(BookingsMapper.bookingsResponseDto(bookings)));
        return bookingsResponseDtos;
    }

    @Override
    public BookingsResponseDto findBookingsById(String id) {
        return BookingsMapper.bookingsResponseDto(bookingsRepository.findBookingsById(id));
    }

    @Override
    public BookingsResponseDto createBookings(BookingsDto bookingsDto) {
        return BookingsMapper.bookingsResponseDto(bookingsRepository.createBookings(BookingsMapper.bookingsDtoToUser(bookingsDto)));
    }

    @Override
    public Boolean updateBookings(String id, BookingsDto bookingsDto) {
        return bookingsRepository.updateBookings(id,BookingsMapper.bookingsDtoToUser(bookingsDto));
    }

    @Override
    public Boolean deleteBookings(String id) {
        return bookingsRepository.deleteBooking(id);
    }
}
