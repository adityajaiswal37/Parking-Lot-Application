# My Parking Lot Application

## 🚗 Overview
My Parking Lot Application is a Java-based system that manages parking slots, tracks vehicle entries and exits, and calculates parking fees. The system ensures efficient parking management by assigning slots dynamically and processing invoices.

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
   git clone https://github.com/your-username/MyParkingLotApp.git
   cd MyParkingLotApp
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
+--------------------+
|   ParkingLot      |
|--------------------|
| name              |
| address           |
| parkingFloors     | (List<ParkingFloor>)
|--------------------|
| +addFloor()       |
| +removeFloor()    |
| +getAvailableSlots() |
+--------------------+
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

## 💡 Future Enhancements
- ✅ Real-time parking availability updates
- ✅ Mobile app integration
- ✅ QR code-based ticket scanning
- ✅ Admin dashboard with analytics

---

### 🤝 Contributing
We welcome contributions! Feel free to open an issue or submit a pull request. 😃

## 📞 Contact
For any queries, contact **Aditya Jaiswal** at `aditya@example.com`. 🚀

