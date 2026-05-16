# QuickSlot – Healthcare Appointment Booking App

QuickSlot is an Android-based healthcare appointment booking application developed using Kotlin and XML in Android Studio. The application provides a clean and user-friendly interface where users can browse doctors, view doctor details, book appointments, manage appointments, and receive booking confirmations efficiently.

The project was developed as part of Android Application Development practical implementation and demonstrates Android concepts such as RecyclerView, SharedPreferences, Intents, Form Handling, Dialog Boxes, Notifications, Animations, and Material UI Design.

---
# Application Workflow

The workflow of the QuickSlot application follows a step-by-step healthcare appointment booking process. The application guides the user from authentication to appointment confirmation and management.

Splash → Login → Home → Doctor List → Doctor Details → Booking → Confirmation → My Appointments

---

## Step 1: Splash Screen

- The application launches with a branded splash screen.
- Application logo and branding are displayed.
- Smooth transition animation redirects the user to the Login Screen.

---

## Step 2: Login Authentication

- User enters email and password credentials.
- Input validation is performed.
- If credentials are valid:
  - User is redirected to the Home Screen.
- If credentials are invalid:
  - Toast message is displayed.

---

## Step 3: Home Screen Navigation

The Home Screen acts as the central dashboard of the application.

Users can:
- View available doctors
- Book new appointments
- Access previously booked appointments

---

## Step 4: Doctor Listing

- Doctors are displayed using RecyclerView with card layouts.
- Each card contains:
  - Doctor Name
  - Specialization
  - Experience
  - Profile Image
- Users can click on a doctor card to view detailed information.

---

## Step 5: Doctor Details

- Detailed doctor information is displayed.
- Information includes:
  - Doctor Name
  - Specialization
  - Experience
  - Doctor Profile Image
- Users can proceed to appointment booking from this screen.

---

## Step 6: Appointment Booking

Users enter:
- Patient Name
- Symptoms
- Appointment Date
- Appointment Time

Features used:
- DatePickerDialog
- TimePickerDialog
- Form Validation

If all fields are valid:
- Appointment data is stored using SharedPreferences.
- User proceeds to Confirmation Screen.

---

## Step 7: Appointment Confirmation

The confirmation screen displays:
- Appointment ID
- Patient Name
- Doctor Name
- Date and Time
- Symptoms
- Appointment Status

Additional actions:
- Booking success toast message
- Local notification generation

---

## Step 8: My Appointments Management

Users can:
- View all booked appointments
- Manage appointment records
- Cancel appointments

Appointments are displayed using modern card layouts.

---

## Step 9: Appointment Cancellation

- When user clicks cancel:
  - Confirmation AlertDialog is displayed.
- If confirmed:
  - Appointment is removed from SharedPreferences.
  - Cancellation toast message is displayed.

---

## Step 10: Empty State Handling

If no appointments exist:
- A “No Appointments Available” screen is displayed.
- User is guided to book a new appointment.
---
# Features

- Splash Screen with Branding
- Login Authentication with Validation
- RecyclerView-based Doctor Listing
- Doctor Detail Screen
- Dynamic Doctor Images
- Appointment Booking System
- Date Picker and Time Picker
- Patient Details and Symptoms Form
- Appointment Confirmation Screen
- My Appointments Management
- Appointment Cancellation Dialog Box
- Toast Messages and Notifications
- Local Notification after Booking
- SharedPreferences Data Storage
- Smooth Screen Transition Animations
- Modern Card-Based User Interface

---

# Technologies Used

- Kotlin
- XML
- Android Studio
- RecyclerView
- CardView
- SharedPreferences
- Material Design Components
- DatePickerDialog
- TimePickerDialog
- AlertDialog
- NotificationManager
- Intents and Activity Navigation

---
# Project Modules

## 1. Splash Screen

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/76d2eaaf-3bb9-4ca6-9300-08e27bcc3802" width="220"/> | Displays the application logo and branding before navigating to the login screen using smooth transition animations. |

---

## 2. Login Module

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/72eeb07a-32a7-4fbd-839c-9d933c8a0870" width="220"/> | Provides user authentication with input validation and displays toast messages for successful or invalid login attempts. |

---

## 3. Home Screen

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/7c26abd3-5d97-4ff9-9bab-9c43f2168e33" width="220"/> | Acts as the central navigation hub where users can book appointments or manage existing appointments. |

---

## 4. Doctor Listing Module

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/c97babf1-b19c-474a-b0af-22a71926cc1d" width="220"/> | Displays doctors using RecyclerView with modern card-based layouts including doctor name, specialization, experience, and booking options. |

---

## 5. Doctor Details Module

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/36027e1f-c49a-4fca-be2c-07ec16de5473" width="220"/> | Displays detailed information about the selected doctor including doctor name, specialization, years of experience, contact information, and profile image. Users can directly proceed to appointment booking from this screen. |

---

## 6. Booking Module

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/5f8257aa-705d-4b8f-9490-0eeb7a160682" width="220"/> | Allows users to enter patient details, symptoms, appointment date, and appointment time using editable forms, DatePickerDialog, and TimePickerDialog. The module validates all fields before confirming the booking. |

---

## 7. Confirmation Module

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/3c8a43b5-d2da-438a-85f7-efef2c543c2b" width="220"/> | Displays appointment confirmation details including appointment ID, patient name, doctor information, appointment date and time, symptoms, and booking status. |

---

## 8. My Appointments Module

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/f91dede6-2ed8-4a06-9cd0-85b7d0b29401" width="220"/> | Displays all booked appointments using card layouts and allows users to manage or cancel appointments dynamically. |

---

## 9. Appointment Cancellation Dialog

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/bac477fa-672a-4f31-90d9-c3800b5e78bc" width="220"/> | Displays a confirmation dialog box before deleting an appointment to prevent accidental cancellation. |

---

## 10. Appointment Cancellation Toast Message

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/2d46a98e-7e1d-4525-91b4-a1c102b0eabf" width="220"/> | Displays a toast message after successful appointment cancellation providing immediate feedback to the user. |

---

## 11. Notification Feature

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/3e46484e-2b1a-4694-93ce-6bf6ce6ee2fe" width="220"/> | Displays a local notification after successful appointment booking to inform the user that the appointment has been confirmed successfully. |

---

## 12. No Appointments Screen

| Screenshot | Description |
|---|---|
| <img src="https://github.com/user-attachments/assets/4042d902-1f60-42a0-9deb-b85cfe703442" width="220"/> | Displays an empty state screen when no appointments are booked. The screen informs the user that no appointments are available and provides navigation options to book a new appointment. |

---

# Data Storage

The application uses SharedPreferences for local data storage.

## Stored Data

- Appointment ID
- Patient Name
- Doctor Name
- Appointment Date
- Appointment Time
- Symptoms
- Appointment Status

## Why SharedPreferences?

- Lightweight
- Easy to implement
- Suitable for offline applications
- Does not require internet connection

---

# Android Concepts Implemented

- Activities and Activity Lifecycle
- Explicit Intents
- RecyclerView and Adapter
- CardView UI
- Form Validation
- SharedPreferences
- AlertDialog
- Toast Messages
- NotificationManager
- PendingIntent
- ScrollView
- Animations and Transitions
- Material Toolbar
---

# ER Diagram
<img width="642" height="354" alt="image" src="https://github.com/user-attachments/assets/462132dc-26a9-4fc3-92c9-037f412c39e7" />

## Entities

- User
- Doctor
- Patient
- Appointment

## Relationships

- A User can book multiple Appointments
- A Doctor can have multiple Appointments
- Each Appointment is linked to one User and one Doctor

---

# Future Scope

- Firebase Cloud Integration
- Real-Time Appointment Synchronization
- Online Doctor Consultation
- Payment Gateway Integration
- Push Notification Reminders
- Doctor Availability Tracking
- User Registration and Authentication

---

# Learning Outcomes

This project helped in understanding:

- Android UI Design
- Activity Navigation
- RecyclerView Implementation
- Form Handling and Validation
- SharedPreferences Data Management
- Dialog Box Implementation
- Notification Handling
- Animation and Transition Effects
- Practical Android Application Development Workflow

---

# Conclusion

QuickSlot successfully demonstrates the implementation of a healthcare appointment booking application using Android Studio. The application provides an efficient workflow for doctor selection, appointment booking, appointment management, and booking confirmation using modern Android development concepts and UI design practices.
