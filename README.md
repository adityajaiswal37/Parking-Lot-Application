# My Parking Lot Application

## 🚗 Overview
My Parking Lot Application is a Java-based system that manages parking slots, tracks vehicle entries and exits, and calculates parking fees. The system ensures efficient parking management by assigning slots dynamically and processing invoices.

This application is fundamentally strong, easy to understand, and designed to be extendable and refactorable. The modular approach ensures that new features can be added seamlessly while maintaining code readability and maintainability.

## 📂 HLD Diagram
<div>
  <img src="https://github.com/adityajaiswal37/ProjectImages/blob/main/HLD.webp">
</div>

## 📂 LLD Diagram
<div>
  <img src="https://github.com/adityajaiswal37/ProjectImages/blob/main/LLD%20.webp">
</div>

## 📂 Project Structure
```
📦 MyParkingLotApp
 ┣ 📂 src/main/java/com/parkinglot
 ┃ ┣ 📜 Address.java
 ┃ ┣ 📜 Invoice.java
 ┃ ┣ 📜 Main.java
 ┃ ┣ 📜 ParkingFeeCalculator.java
 ┃ ┣ 📜 ParkingFloor.java
 ┃ ┣ 📜 ParkingLot.java
 ┃ ┣ 📜 ParkingMain.java
 ┃ ┣ 📜 ParkingSlot.java
 ┃ ┣ 📜 ParkingSlotType.java
 ┃ ┣ 📜 Price.java
 ┃ ┣ 📜 Ticket.java
 ┃ ┣ 📜 Vehicle.java
 ┃ ┣ 📜 VehicleCategory.java
 ┗ 📜 README.md
```

## 🛠️ Features
✅ Parking lot management (Floors & Slots)  
✅ Vehicle entry and exit tracking  
✅ Ticket generation and fee calculation  
✅ Invoice processing  
✅ Dynamic pricing for different vehicle categories  

## 🚀 Installation & Setup

### Prerequisites
- Java 17+
- Maven 3.6+
- MySQL (Optional if database integration is required)

### Steps to Run
1. **Clone the Repository**
   ```sh
   git clone https://github.com/adityajaiswal37/Parking-Lot-Application.git
   cd Parking-Lot-Application
   ```

2. **Build the Project**
   ```sh
   mvn clean install
   ```

3. **Run the Application**
   ```sh
   java -jar target/MyParkingLotApp.jar
   ```

## 🏗️ Class Diagram

```plaintext
+-------------------+
|   ParkingLot      |
|-------------------|
| name              |
| address           |
| parkingFloors     | 
|-------------------|
| +getInstance()    |
| +addFloors()      |
| +removeFloor()    |
| +checkIn()        |
| +checkOut()       |
| +scanAndPay()     |
| +getParkingSlot() |
| +createTicket()   |
| +getTicketPrice() |
+-------------------+
```

_(For a complete class diagram, refer to the `docs/` folder.)_

## 🗄️ Database Tables

### 🚗 Vehicles Table
```
+------------+------------+---------+-------------+
| vehicle_id | plate_no   | type    | category    |
+------------+------------+---------+-------------+
| 1          | AB123CD    | Car     | Compact     |
| 2          | XY987ZT    | Bike    | Two-Wheeler |
+------------+------------+---------+-------------+
```

### 🎟️ Tickets Table
```
+----------+------------+------------+------------+----------+
| ticket_id | vehicle_id | entry_time | exit_time  | fee_paid |
+----------+------------+------------+------------+----------+
| 101      | 1          | 10:00 AM   | 12:30 PM   | $5.00    |
| 102      | 2          | 09:45 AM   | NULL       | NULL     |
+----------+------------+------------+------------+----------+
```

### 🏢 Parking Slots Table
```
+-------------+------------+-----------+---------+
| slot_id     | floor_no   | type      | status  |
+-------------+------------+-----------+---------+
| 1           | 1          | Compact   | Occupied|
| 2           | 1          | Large     | Free    |
+-------------+------------+-----------+---------+
```

## 📜 License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.



### 🤝 Contributing
We welcome contributions! Feel free to open an issue or submit a pull request. 😃

## 📞 Contact
For any queries, contact **Aditya Jaiswal** at `adijaiswal0011@gmail.com`. 🚀

