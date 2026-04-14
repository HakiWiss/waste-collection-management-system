# ♻️ GreenCollect - Waste Collection Management System

## 📖 Description
GreenCollect is a Java console application designed to manage recyclable waste collection operations.

The system supports two roles:
- **Admin**: manages staff and monitors collections
- **Staff**: records and manages waste collections

It helps organize and track recyclable materials such as wood, glass, metal, paper, and plastic.

---

## 🚀 Features

### 🔐 Authentication
- Login system for Admin and Staff
- Role-based access control

### 👨‍💼 Admin Features
- View all staff members
- Add new staff
- Update staff information
- Delete staff accounts
- View all collections:
  - Scheduled collections
  - Non-scheduled collections

### 👷 Staff Features
- Add new waste collections
- View personal collection statistics
- Update existing collections
- Schedule collections

### ♻️ Waste Management
- Track different waste types:
  - Wood
  - Glass
  - Metal
  - Paper
  - Plastic
- Store quantities for each collection
- Associate collections with locations

---

## 🛠️ Technologies Used

- Java (Core Java)
- OOP (Object-Oriented Programming)
- Collections Framework (ArrayList, HashMap)
- Console-based interface

---

## 🧱 System Design

### Main Classes
- `MainClass` → Entry point & interface handling
- `Admin` → Admin operations
- `Staff` → Staff operations
- `Collection` → Waste collection data
- `Schedule` → Collection scheduling

---

## ⚙️ How It Works

1. Start the application
2. Choose:
   - Login
   - Sign up (Admin only for staff creation)
3. Access features based on role:
   - Admin → management dashboard
   - Staff → collection operations

---
