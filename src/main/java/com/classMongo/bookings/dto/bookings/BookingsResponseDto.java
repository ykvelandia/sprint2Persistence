package com.classMongo.bookings.dto.bookings;

public class BookingsResponseDto {
    private String id;
    private String userId;
    private String roomId;

    public String getId() {
        return id;
    }

    public BookingsResponseDto(String id, String userId, String roomId) {
        this.id = id;
        this.userId = userId;
        this.roomId = roomId;
    }

    public void setId(String id) {
        this.id = id;
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
