# Smart Clinic Management System - Database Schema Design

## 1. Overview

The Smart Clinic Management System uses a MySQL relational database to manage doctors, patients, appointments, prescriptions, and user authentication.

The main roles in the application are:

* Admin
* Doctor
* Patient

The database uses primary keys to uniquely identify records and foreign keys to maintain relationships between related tables.

## 2. Database

```
CREATE DATABASE smart_clinic;
USE smart_clinic;
```

## 3. Tables

### 3.1 Doctor

Stores information about doctors registered in the clinic.

| Column     | Data Type    | Constraints                 | Description               |
| ---------- | ------------ | --------------------------- | ------------------------- |
| doctor_id  | BIGINT       | PRIMARY KEY, AUTO_INCREMENT | Unique doctor ID          |
| name       | VARCHAR(100) | NOT NULL                    | Doctor name               |
| speciality | VARCHAR(100) | NOT NULL                    | Medical speciality        |
| email      | VARCHAR(150) | UNIQUE, NOT NULL            | Doctor email              |
| phone      | VARCHAR(20)  |                             | Doctor phone number       |
| password   | VARCHAR(255) | NOT NULL                    | Encrypted doctor password |

```
CREATE TABLE Doctor (
    doctor_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    speciality VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(20),
    password VARCHAR(255) NOT NULL
);
```

### 3.2 Patient

Stores information about patients using the clinic system.

| Column     | Data Type    | Constraints                 | Description                |
| ---------- | ------------ | --------------------------- | -------------------------- |
| patient_id | BIGINT       | PRIMARY KEY, AUTO_INCREMENT | Unique patient ID          |
| name       | VARCHAR(100) | NOT NULL                    | Patient name               |
| email      | VARCHAR(150) | UNIQUE, NOT NULL            | Patient email              |
| phone      | VARCHAR(20)  |                             | Patient phone number       |
| password   | VARCHAR(255) | NOT NULL                    | Encrypted patient password |

```
CREATE TABLE Patient (
    patient_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    phone VARCHAR(20),
    password VARCHAR(255) NOT NULL
);
```

### 3.3 Appointment

Stores appointments booked between patients and doctors.

| Column           | Data Type   | Constraints                 | Description                        |
| ---------------- | ----------- | --------------------------- | ---------------------------------- |
| appointment_id   | BIGINT      | PRIMARY KEY, AUTO_INCREMENT | Unique appointment ID              |
| doctor_id        | BIGINT      | FOREIGN KEY                 | Doctor for the appointment         |
| patient_id       | BIGINT      | FOREIGN KEY                 | Patient who booked the appointment |
| appointment_date | DATE        | NOT NULL                    | Appointment date                   |
| appointment_time | TIME        | NOT NULL                    | Appointment time                   |
| status           | VARCHAR(30) | NOT NULL                    | Appointment status                 |

```
CREATE TABLE Appointment (
    appointment_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    doctor_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    appointment_date DATE NOT NULL,
    appointment_time TIME NOT NULL,
    status VARCHAR(30) NOT NULL,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id)
);
```

### 3.4 Prescription

Stores prescriptions created by doctors for patients.

| Column          | Data Type    | Constraints                 | Description                     |
| --------------- | ------------ | --------------------------- | ------------------------------- |
| prescription_id | BIGINT       | PRIMARY KEY, AUTO_INCREMENT | Unique prescription ID          |
| doctor_id       | BIGINT       | FOREIGN KEY                 | Doctor who created prescription |
| patient_id      | BIGINT       | FOREIGN KEY                 | Patient receiving prescription  |
| appointment_id  | BIGINT       | FOREIGN KEY                 | Related appointment             |
| medicine        | VARCHAR(255) | NOT NULL                    | Medicine information            |
| dosage          | VARCHAR(100) |                             | Dosage information              |
| instructions    | TEXT         |                             | Treatment instructions          |

```
CREATE TABLE Prescription (
    prescription_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    doctor_id BIGINT NOT NULL,
    patient_id BIGINT NOT NULL,
    appointment_id BIGINT,
    medicine VARCHAR(255) NOT NULL,
    dosage VARCHAR(100),
    instructions TEXT,
    FOREIGN KEY (doctor_id) REFERENCES Doctor(doctor_id),
    FOREIGN KEY (patient_id) REFERENCES Patient(patient_id),
    FOREIGN KEY (appointment_id) REFERENCES Appointment(appointment_id)
);
```

### 3.5 Admin

Stores administrator login information.

| Column   | Data Type    | Constraints                 | Description                      |
| -------- | ------------ | --------------------------- | -------------------------------- |
| admin_id | BIGINT       | PRIMARY KEY, AUTO_INCREMENT | Unique admin ID                  |
| name     | VARCHAR(100) | NOT NULL                    | Administrator name               |
| email    | VARCHAR(150) | UNIQUE, NOT NULL            | Administrator email              |
| password | VARCHAR(255) | NOT NULL                    | Encrypted administrator password |

```
CREATE TABLE Admin (
    admin_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL
);
```

## 4. Relationships

* One Doctor can have many Appointments.
* One Patient can have many Appointments.
* Each Appointment belongs to one Doctor and one Patient.
* One Doctor can create many Prescriptions.
* One Patient can receive many Prescriptions.
* A Prescription can be associated with an Appointment.
* Admin manages the clinic system and its users.

## 5. Entity Relationship Summary

```
Doctor
  |
  | 1 ---- *
  |
Appointment
  |
  | * ---- 1
  |
Patient

Doctor
  |
  | 1 ---- *
  |
Prescription
  |
  | * ---- 1
  |
Patient

Appointment
  |
  | 1 ---- *
  |
Prescription

Admin
  |
  | manages
  |
Doctors, Patients and Appointments
```

## 6. Design Considerations

* Primary keys uniquely identify records.
* Foreign keys maintain referential integrity between related tables.
* Email fields are unique to avoid duplicate user accounts.
* Appointment date and time are stored separately to support appointment scheduling and reporting.
* The schema supports searching doctors by name and speciality.
* The schema supports patient appointment history and doctor appointment management.
* Prescription records are associated with doctors, patients, and appointments.
* Passwords should be stored using secure password hashing rather than plain text in a production system.
