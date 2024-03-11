package com.classMongo.bookings.dto.bookings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingsResponseDto {
    private String id;
    private String userId;
    private String roomId;

}
