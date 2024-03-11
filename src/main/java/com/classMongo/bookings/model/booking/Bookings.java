package com.classMongo.bookings.model.booking;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.io.Serial;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bookings")
public class Bookings {
    @Serial
    private final static long serialVersionUID = 1L;
    @Id
    private String id;
    private String userId;
    private String roomId;
    private Date startTime;
    private Date endTime;

      public Bookings(String userId, String roomId) {
        this.userId = userId;
        this.roomId = roomId;
        this.startTime = null;
        this.endTime = null;
    }
    public void updateBookings(Bookings bookings) {
        setUserId(bookings.getUserId());
        setRoomId(bookings.getRoomId());

    }
}
