package com.classMongo.bookings.service.bookings;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.classMongo.bookings.dto.bookings.BookingsResponseDto;
import com.classMongo.bookings.model.booking.Bookings;
import com.classMongo.bookings.repository.booking.BookingsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;

class BookingsServiceImplementsTest {

    @Mock
    private BookingsRepository bookingsRepository;

    @InjectMocks
    private BookingsServiceImplements bookingsService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllBookings() {

        //Organizar test
        List<Bookings> mockBookingsList = new ArrayList<>();
        mockBookingsList.add(new Bookings("1", "Booking 1"));
        mockBookingsList.add(new Bookings("2", "Booking 2"));

        when(bookingsRepository.getAllBookings()).thenReturn(mockBookingsList);

        //actuar del test
        List<BookingsResponseDto> result = bookingsService.getAllBookings();

        //afirmar el test
        assertNotNull(result);
        assertEquals(2, result.size());
        // Verifica que el método del repositorio haya sido llamado
        verify(bookingsRepository, times(1)).getAllBookings();

    }
}