package com.classMongo.bookings.controller.booking;

import com.classMongo.bookings.dto.bookings.BookingsDto;
import com.classMongo.bookings.dto.bookings.BookingsResponseDto;
import com.classMongo.bookings.service.bookings.BookingsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/v1/bookings")
public class BookingsController {

    private BookingsService bookingsService;

    @GetMapping
    public ResponseEntity<List<BookingsResponseDto>> getAllBookings() {
        try {
            return ResponseEntity.ok(bookingsService.getAllBookings());
        } catch (Exception e) {
            return new ResponseEntity("Error in getAllBookings controller: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{idBooking}")
    public ResponseEntity<BookingsResponseDto> findBookingsById(@PathVariable String id) {
        try {
            return new ResponseEntity<>(bookingsService.findBookingsById(id), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity("The booking " + id + " doesn't in the data base", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BookingsResponseDto> createBookings(@RequestBody BookingsDto bookingsDto) {
        return new ResponseEntity<>(bookingsService.createBookings(bookingsDto), HttpStatus.CREATED);
    }

    @PutMapping("/{idBooking}")
    public ResponseEntity<Boolean> updateBookings(@PathVariable String id, @RequestBody BookingsDto bookingsDto) {
        try {
            Boolean isUpdated = bookingsService.updateBookings(id, bookingsDto);
            if (isUpdated) {
                return new ResponseEntity("The bookings updated ok", HttpStatus.OK);
            } else {
                return new ResponseEntity(HttpStatus.NOT_FOUND);
            }

        } catch (NoSuchElementException e) {
            return new ResponseEntity("The bookings " + id + " doesn't in the data base", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBookings(@PathVariable String id) {
        return new ResponseEntity<>(bookingsService.deleteBookings(id), HttpStatus.OK);
    }

    @GetMapping("/bookings/{id}")
    public ResponseEntity<Void> findBookingById(@PathVariable String id) {
        BookingsResponseDto bookingDto = bookingsService.findBookingsById(id);
        if (bookingDto != null) {
            return ResponseEntity.ok().build(); // La reserva se encontró, se devuelve un 200 OK
        } else {
            return ResponseEntity.notFound().build(); // La reserva no se encontró, se devuelve un 404 Not Found
        }
    }
}
