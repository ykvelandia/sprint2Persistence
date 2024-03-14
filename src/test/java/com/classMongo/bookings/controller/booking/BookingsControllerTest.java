package com.classMongo.bookings.controller.booking;

import com.classMongo.bookings.dto.bookings.BookingsDto;
import com.classMongo.bookings.service.bookings.BookingsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

class BookingsControllerTest {

    @Mock
    private BookingsService bookingsService;

    @InjectMocks
    private BookingsController bookingsController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testFindBookingById_NotFound() {
        //Organizar test
        String nonExistingBookingId = "100";
        when(bookingsService.findBookingsById(eq(nonExistingBookingId))).thenReturn(null); // Simulamos que no se encuentra la reserva

        //actuar del test
        ResponseEntity<Void> responseEntity = bookingsController.findBookingById(nonExistingBookingId);

        //afirmar el test
        assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());
    }


}