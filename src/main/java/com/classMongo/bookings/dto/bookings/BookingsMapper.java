package com.classMongo.bookings.dto.bookings;

import com.classMongo.bookings.model.booking.Bookings;

public class BookingsMapper {

    public static BookingsResponseDto bookingsResponseDto (Bookings bookings){
        return new BookingsResponseDto(
                bookings.getId(),
                bookings.getUserId(),
                bookings.getRoomId()

        );
    }
    public static Bookings bookingsDtoToUser(BookingsDto bookingsDto){
        return new Bookings(
                bookingsDto.getUserId(),
                bookingsDto.getRoomId()

        );
    }
}
