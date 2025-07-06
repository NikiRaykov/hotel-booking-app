# 🏨 Hotel Booking App

This is a full-stack **Hotel Booking application** built with:

- **Frontend**: Angular (standalone components, routing, services)
- **Backend**: Spring Boot (REST API with JPA + H2/MySQL)
- **Database**: MySQL or H2 (configurable)

---

## 📁 Project Structure

HotelBooking/
├── backend/ ← Spring Boot app (Java)
├── frontend/ ← Angular app (TypeScript)
└── README.md


---

## 🚀 Getting Started

### Backend Setup

1. Open `backend/` in IntelliJ.
2. Configure DB (H2 or MySQL) in `application.properties`.
3. Run the app (Main class: `HotelBookingApplication`).
4. Backend runs at: `http://localhost:8080/api`

### Frontend Setup

1. Open `frontend/` in VS Code.
2. Install dependencies:

```bash
npm install

Run the Angular app:
ng serve

App runs at: http://localhost:4200

Features
View all rooms
Add a new room
Book a room
View all bookings
Delete bookings

