package com.classMongo.bookings.dto.bookings;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingsDto {
    private String userId;
    private String roomId;


}
