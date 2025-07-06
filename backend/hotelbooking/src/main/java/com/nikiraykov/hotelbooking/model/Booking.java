package com.nikiraykov.hotelbooking.model;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String guestName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    public Booking(){}


    public Booking(Long id, String guestName, LocalDate checkInDate, Room room, LocalDate checkOutDate) {
        this.id = id;
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.room = room;
        this.checkOutDate = checkOutDate;
    }

    @ManyToOne
    @JoinColumn(name = "room-id") // Foreign key
    private Room room;
}
