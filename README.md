# Real-Time Railway Management System

A Java-based railway booking system that allows users to view available trains, check seat availability, book seats, and cancel bookings through a simple console-based interface.

## 📌 Project Overview

The **Real-Time Railway Management System** is a beginner-friendly Java project designed to demonstrate Object-Oriented Programming (OOP) concepts through a practical railway booking scenario.

The system manages multiple trains and allows users to select a train, view its seat status, book seats, and cancel existing bookings.

## ✨ Features

* View available trains
* Select a train
* Display train information
* Display total, booked, and available seats
* Book seats
* Cancel booked seats
* Check seat availability
* Validate seat booking
* Prevent booking when there are not enough seats
* Prevent cancelling more seats than currently booked
* Console-based user interaction
* Multiple train management using `ArrayList`

## 🚆 Available Trains

The current system includes:

| Train           | Route            | Total Seats |
| --------------- | ---------------- | ----------: |
| Colombo Express | Colombo - Galle  |         100 |
| Kandy Intercity | Kandy - Colombo  |          80 |
| Yarl Express    | Colombo - Jaffna |         100 |

## 🛠️ Technologies Used

* **Java**
* **Java Collections Framework**
* **ArrayList**
* **Scanner**
* **Exception Handling**
* **Object-Oriented Programming**

## 🧠 OOP Concepts Demonstrated

### 1. Interface

The `SeatService` interface defines the operations related to seat management.

```java
interface SeatService {
    boolean checkAvailability(int seatsRequired);
    void bookSeats(int seats) throws Exception;
    void cancelBooking(int seats) throws Exception;
    void displaySeatStatus();
}
```

### 2. Abstraction

`TrainBase` is an abstract class that provides common train and seat-management functionality.

```java
abstract class TrainBase implements SeatService
```

It also contains the abstract method:

```java
public abstract void displayTrainInfo();
```

### 3. Inheritance

`ExpressTrain` extends `TrainBase`.

```java
class ExpressTrain extends TrainBase
```

This allows `ExpressTrain` to reuse the common functionality provided by `TrainBase`.

### 4. Encapsulation

Train information and seat data are stored using private fields.

```java
private String trainName;
private int totalSeats;
private int bookedSeats;
```

Access is controlled through getter methods and a protected setter.

### 5. Polymorphism

The program uses a `TrainBase` reference to store an `ExpressTrain` object.

```java
TrainBase train1 =
    new ExpressTrain("Colombo Express", 100, "Colombo - Galle");
```

This demonstrates runtime polymorphism.

### 6. Collections

The railway system manages multiple trains using an `ArrayList`.

```java
private ArrayList<TrainBase> trainList = new ArrayList<>();
```

### 7. Exception Handling

The system uses exceptions to handle invalid booking and cancellation operations.

For example:

* Booking more seats than available
* Cancelling more seats than have been booked

```java
throw new Exception("Not enough seats available!");
```

## 📂 Project Structure

```text
Real-Time-Railway-Management-System/
│
├── RealTimeRailwaySystem.java
├── README.md
└── .gitignore
```

The main Java file contains:

```text
SeatService
     ↓
TrainBase
     ↓
ExpressTrain

RailwaySystem
     ↓
RealTimeRailwaySystem
```

## ▶️ How to Run

### Requirements

* Java JDK installed
* Java-supported IDE or terminal

You can check your Java installation with:

```bash
java --version
```

### Run Using Terminal

Navigate to the project directory:

```bash
cd path/to/project
```

Compile the program:

```bash
javac RealTimeRailwaySystem.java
```

Run the program:

```bash
java RealTimeRailwaySystem
```

## 💻 Example Usage

```text
--- Railway Booking System ---

Available Trains:
1. Train Name: Colombo Express
   Route: Colombo - Galle
2. Train Name: Kandy Intercity
   Route: Kandy - Colombo
3. Train Name: Yarl Express
   Route: Colombo- Jaffna

Select train number (0 to exit): 1

Train: Colombo Express
Total Seats: 100
Booked Seats: 0
Available Seats: 100

Enter 1 to Book | 2 to Cancel | 0 to Back: 1

Enter number of seats: 5

5 seat(s) successfully booked.

Train: Colombo Express
Total Seats: 100
Booked Seats: 5
Available Seats: 95
```

## 🎯 Project Objectives

This project was developed to:

* Practice Java programming
* Understand Object-Oriented Programming
* Implement interfaces and abstract classes
* Understand inheritance and polymorphism
* Practice encapsulation
* Work with Java `ArrayList`
* Practice exception handling
* Build a practical console-based application

## 🚀 Future Improvements

Possible future improvements include:

* Add a graphical user interface (GUI)
* Add passenger information
* Add ticket IDs
* Add ticket pricing
* Add different train types
* Add train schedules
* Add database integration
* Add user authentication
* Add persistent booking data
* Add a more advanced reservation system

## 📚 Project Level

**Beginner / Intermediate Java Project**

## 👨‍💻 Author

**A.K MADUMAL**

BICT Undergraduate | Aspiring Network Engineer

## 📄 License

This project is currently not licensed for redistribution.
