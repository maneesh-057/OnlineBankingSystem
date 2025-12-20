# Online Banking System (Java GUI + SQLite)

## Project Description
This is a Java GUI-based Online Banking System developed using Java Swing and SQLite.
The project follows MVC architecture and demonstrates core Java concepts,
database connectivity, multithreading, and event-driven programming.

## Technologies Used
- Java 11+
- Java Swing (GUI)
- SQLite
- JDBC
- VS Code

## Features
- User Registration
- User Login
- Deposit Money
- Withdraw Money
- Balance Inquiry
- Transaction Logging
- Background Balance Monitoring (Multithreading)

## Project Structure
- db        : Database connection and initialization
- model     : Entity classes (User, Transaction)
- dao       : Database operations (DAO pattern)
- controller: Business logic (Servlet-like controllers)
- ui        : Java Swing GUI
- thread    : Multithreading implementation
- exception : Custom exceptions

## How to Run
1. Ensure Java 11+ is installed
2. Place sqlite-jdbc.jar in project root
3. Add sqlite-jdbc.jar to classpath (VS Code settings.json)
4. Run Main.java

## Database
- SQLite database is auto-created as bank.db
- Tables: users, transactions

## OOP Concepts Used
- Inheritance (BaseFrame)
- Polymorphism (BankOperations interface)
- Interfaces
- Exception Handling

## Multithreading
A background thread monitors account balance periodically using synchronization.

## Conclusion
This project demonstrates clean architecture, robust error handling,
and full integration of GUI, database, and business logic.
