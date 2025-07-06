package com.nikiraykov.hotelbooking.repository;

import com.nikiraykov.hotelbooking.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
