# Event Management Dashboard

A full-stack event management system built during a 6-hour hackathon.

This application allows organizers to create and manage events, and users to browse and register for events with real-time registration tracking.

---

## 🚀 Features

### 👤 User Authentication
- User registration
- Login system
- Role-based users (ORGANIZER / USER)

### 🎯 Event Management
- Organizers can create events
- Users can browse all available events
- Event capacity management
- Duplicate registration prevention

### 📊 Real-Time Updates
- Live registration count API
- Capacity validation before registration

---

## 🏗 Architecture

Layered backend architecture:

Controller → Service → Repository → Database

Separation of concerns ensures maintainability and scalability.

---

## 🛠 Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- H2 Database
- REST APIs
- Transaction Management (@Transactional)
- Global Exception Handling

### Frontend
- HTML
- CSS
- JavaScript (Fetch API)
- Role-based dashboard view

---

## 📦 Project Structure

'''
EventManagementSystem
├── src/main/java # Backend source code
├── src/main/resources # Config & static frontend files
└── pom.xml # Maven configuration
'''

---

## 🔐 Authentication Approach

Basic email-password authentication system implemented.
Role field determines organizer and user capabilities.

For production scalability, JWT-based authentication can be integrated.

---

## ⚙️ Core Engineering Concepts Demonstrated

- DTO-based request handling
- Transactional consistency
- Unique database constraints
- Capacity validation logic
- RESTful API design
- Clean layered architecture

---

## 📈 Future Improvements

- JWT-based stateless authentication
- WebSocket-based real-time updates
- Email notification system
- Admin dashboard analytics

---

## 👨‍💻 Author

Rajeev Ranjan  
Backend-focused Software Engineer
