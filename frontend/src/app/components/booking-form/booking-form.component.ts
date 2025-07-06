import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BookingService, Booking } from '../../services/booking.service';
import { RoomService, Room } from '../../services/room.service';

@Component({
  selector: 'app-booking-form',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent {
  booking: Partial<Booking> = {
    guestName: '',
    checkInDate: '',
    checkOutDate: '',
    roomId: 0
  };

  rooms: Room[] = [];

  constructor(
    private bookingService: BookingService,
    private roomService: RoomService
  ) {
    this.loadRooms();
  }

  loadRooms(): void {
    this.roomService.getRooms().subscribe({
      next: (data) => this.rooms = data,
      error: (err) => console.error(err)
    });
  }

  onSubmit(): void {
    this.bookingService.createBooking(this.booking).subscribe({
      next: () => {
        alert('Booking created!');
        this.booking = {
          guestName: '',
          checkInDate: '',
          checkOutDate: '',
          roomId: 0
        };
      },
      error: (err) => {
        console.error(err);
        alert('Something went wrong.');
      }
    });
  }
}
