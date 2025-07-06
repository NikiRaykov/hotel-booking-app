import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RoomService, Room } from '../../services/room.service';

@Component({
  selector: 'app-room-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './room-list.component.html',
  styleUrls: ['./room-list.component.css']
})
export class RoomListComponent implements OnInit {
  rooms: Room[] = [];
  loading: boolean = true;
  error: string | null = null;

  constructor(private roomService: RoomService) {}

  ngOnInit(): void {
    this.roomService.getRooms().subscribe({
      next: (data) => {
        this.rooms = data;
        this.loading = false;
      },
      error: (err) => {
        console.error(err);
        this.error = 'Failed to load rooms.';
        this.loading = false;
      }
    });
  }
}
