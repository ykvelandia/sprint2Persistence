package com.classMongo.bookings.dto.bookings;

import java.util.Date;

public class BookingsDto {
    private String userId;
    private String roomId;


    public BookingsDto(String userId, String roomId, Date startTime, Date endTime) {
        this.userId = userId;
        this.roomId = roomId;

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
