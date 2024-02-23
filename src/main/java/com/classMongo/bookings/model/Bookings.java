package com.classMongo.bookings.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;

@Document(collection = "bookings")
public class Bookings {
    @Id
    private String id;
    private String userId;
    private String roomId;
    private Date startTime;
    private Date endTime;

    public Bookings() {
    }

    public Bookings(String userId, String roomId) {
        this.userId = userId;
        this.roomId = roomId;
        this.startTime = null;
        this.endTime = null;
    }

    public String getId() {
        return id;
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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void updateBookings(Bookings bookings) {
        setUserId(bookings.getUserId());
        setRoomId(bookings.getRoomId());

    }
}
