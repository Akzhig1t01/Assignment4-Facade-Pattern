# Assignment 4: Facade Design Pattern — Online Order Processing

**Student:** Akzhigit Agabekov  
**Group:** SE-2523  

---

## 📌 Project Overview
This project demonstrates the **Facade Structural Design Pattern** implemented in Java.

The `OrderFacade` simplifies a complex e-commerce order processing subsystem consisting of four independent services:
1. `InventoryService`: Manages stock reservation and releases.
2. `PaymentProcessor`: Handles payment authorizations and refunds.
3. `ShippingService`: Schedules logistics delivery and generates tracking IDs.
4. `NotificationService`: Dispatches confirmation and failure emails.

The Facade encapsulates workflow execution and handles transactional rollbacks (e.g., releasing reserved stock if payment fails) without exposing internal subsystem complexities to the client (`Main`).

---

## 🛠 Project Structure
```text
src/
├── facade/
│   └── OrderFacade.java
├── subsystem/
│   ├── InventoryService.java
│   ├── NotificationService.java
│   ├── PaymentProcessor.java
│   └── ShippingService.java
└── Main.java
