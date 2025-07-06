package com.nikiraykov.hotelbooking.controller;

import com.nikiraykov.hotelbooking.model.Room;
import com.nikiraykov.hotelbooking.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;


    //Get All rooms
    @GetMapping
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    //POST A NEW ROOM
    @PostMapping
    public Room createRoom(@RequestBody Room room) {
        return roomRepository.save(room);
    }

    //Put /api/rooms/{id} - update a room
    @PutMapping("/{id}")
    public Room updateRoom(@PathVariable Long id, @RequestBody Room updatedRoom){
        return roomRepository.findById(id).map(room -> {
            room.setRoomNumber(updatedRoom.getRoomNumber());
            room.setAvailable(updatedRoom.isAvailable());
            room.setType(updatedRoom.getType());
            return roomRepository.save(room);
        }).orElseThrow(() -> new RuntimeException("Room not found with this ID: " + id));
    }

    //Delete /api/rooms/{id} - delete a room
    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable Long id) {
        if (!roomRepository.existsById(id)) {
            throw new RuntimeException("Room not found with this ID: " + id);
        }

        roomRepository.deleteById(id);
        return "Room deleted with id: " + id;
    }
}
