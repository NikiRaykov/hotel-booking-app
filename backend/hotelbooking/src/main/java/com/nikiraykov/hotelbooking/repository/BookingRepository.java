package com.nikiraykov.hotelbooking.repository;

import com.nikiraykov.hotelbooking.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
