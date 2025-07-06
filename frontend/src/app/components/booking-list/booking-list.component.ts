import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { BookingService, Booking } from '../../services/booking.service';
import { RoomService, Room } from '../../services/room.service';

@Component({
  selector: 'app-booking-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './booking-list.component.html',
  styleUrls: ['./booking-list.component.css']
})
export class BookingListComponent implements OnInit {
  bookings: Booking[] = [];
  rooms: Room[] = [];

  constructor(
    private bookingService: BookingService,
    private roomService: RoomService
  ) {}

  ngOnInit(): void {
    this.loadBookings();
    this.loadRooms();
  }

  loadBookings(): void {
    this.bookingService.getBookings().subscribe({
      next: (data) => (this.bookings = data),
      error: (err) => console.error(err),
    });
  }

  loadRooms(): void {
    this.roomService.getRooms().subscribe({
      next: (data) => (this.rooms = data),
      error: (err) => console.error(err),
    });
  }

  getRoomNumber(roomId: number): string {
    const room = this.rooms.find(r => r.id === roomId);
    return room ? room.roomNumber : 'Unknown';
  }

  deleteBooking(id: number): void {
    if (confirm('Are you sure you want to delete this booking?')) {
      this.bookingService.deleteBooking(id).subscribe({
        next: () => {
          this.loadBookings(); // reload the list
        },
        error: (err) => {
          console.error(err);
          alert('Could not delete booking');
        }
      });
    }
  }
}
