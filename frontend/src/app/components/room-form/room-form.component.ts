import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RoomService, Room } from '../../services/room.service';
imports: [CommonModule, FormsModule];

@Component({
  selector: 'app-room-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './room-form.component.html',
  styleUrls: ['./room-form.component.css']
})
export class RoomFormComponent {
  room = {
    roomNumber: '',
    type: '',
    available: false
  };

  constructor(private roomService: RoomService) {}

 onSubmit(): void {
  this.roomService.createRoom(this.room).subscribe({
    next: () => {
      alert('Room created!');
      this.room = { roomNumber: '', type: '', available: false };
    },
    error: (err) => {
      console.error(err);
      alert('Something went wrong.');
    }
  });
}
}
