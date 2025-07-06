import { Routes } from '@angular/router';
import { RoomListComponent } from './components/room-list/room-list.component';
import { RoomFormComponent } from './components/room-form/room-form.component';
import { BookingFormComponent } from './components/booking-form/booking-form.component';
import { BookingListComponent } from './components/booking-list/booking-list.component';

export const routes: Routes = [
  { path: '', component: RoomListComponent },
  { path: 'rooms', component: RoomListComponent},
  { path: 'add-room', component: RoomFormComponent },
  { path: 'add-booking', component: BookingFormComponent },
  { path: 'bookings', component: BookingListComponent }
];