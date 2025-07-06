package com.nikiraykov.hotelbooking.controller;

import com.nikiraykov.hotelbooking.dto.BookingDTO;
import com.nikiraykov.hotelbooking.model.Booking;
import com.nikiraykov.hotelbooking.model.Room;
import com.nikiraykov.hotelbooking.repository.BookingRepository;
import com.nikiraykov.hotelbooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @PostMapping
    public Booking createBooking(@RequestBody BookingDTO bookingDTO) {
        Room room = roomRepository.findById(bookingDTO.getRoomId())
                .orElseThrow(() -> new RuntimeException("Room not found with ID: " + bookingDTO.getRoomId()));

        Booking booking = new Booking();
        booking.setGuestName(bookingDTO.getGuestName());
        booking.setCheckInDate(bookingDTO.getCheckInDate());
        booking.setCheckOutDate(bookingDTO.getCheckOutDate());
        booking.setRoom(room);

        return bookingRepository.save(booking);
    }

    @DeleteMapping({"/{id}"})
    public Map<String, String> deleteBooking(@PathVariable Long id) {
        if (!bookingRepository.existsById(id)) {
            throw new RuntimeException("Booking not found with ID: " + id);
        }

        bookingRepository.deleteById(id);
        return Map.of("message", "Booking deleted with id: " + id);
    }
}
