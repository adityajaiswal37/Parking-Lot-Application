package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingMain {
    public static void main(String[] args) throws InterruptedException {
        String name = "Hitech City Parking Lot";
        Address address = new Address.Builder()
                .street("Cyber Tower Rd")
                .building("Trident Tower")
                .city("Hyderabad")
                .state("Telangana")
                .country("India")
                .postalCode("500085")
                .build();
        
        Map<ParkingSlotType, Map<String, ParkingSlot>> allParkingSlots = new HashMap<>();
        Map<String, ParkingSlot> twoWheelerSlots = new HashMap<>();
        twoWheelerSlots.put("A1", new ParkingSlot("A1", ParkingSlotType.TwoWheeler));
        twoWheelerSlots.put("A2", new ParkingSlot("A2", ParkingSlotType.TwoWheeler));
        twoWheelerSlots.put("A3", new ParkingSlot("A3", ParkingSlotType.TwoWheeler));
        allParkingSlots.put(ParkingSlotType.TwoWheeler, twoWheelerSlots);

        Map<String, ParkingSlot> threeWheelerSlots = new HashMap<>();
        twoWheelerSlots.put("B1", new ParkingSlot("B1", ParkingSlotType.ThreeWheeler));
        twoWheelerSlots.put("B2", new ParkingSlot("B2", ParkingSlotType.ThreeWheeler));
        twoWheelerSlots.put("B3", new ParkingSlot("B3", ParkingSlotType.ThreeWheeler));
        allParkingSlots.put(ParkingSlotType.ThreeWheeler,threeWheelerSlots);

        Map<String, ParkingSlot> fourWheelerSlots = new HashMap<>();
        twoWheelerSlots.put("C1", new ParkingSlot("C1", ParkingSlotType.FourWheeler));
        twoWheelerSlots.put("C2", new ParkingSlot("C2", ParkingSlotType.FourWheeler));
        twoWheelerSlots.put("C3", new ParkingSlot("C3", ParkingSlotType.FourWheeler));
        allParkingSlots.put(ParkingSlotType.FourWheeler, fourWheelerSlots);

        Map<String, ParkingSlot> largeVehicleSlots = new HashMap<>();
        twoWheelerSlots.put("D1", new ParkingSlot("D1", ParkingSlotType.LargeVehicle));
        twoWheelerSlots.put("D2", new ParkingSlot("D2", ParkingSlotType.LargeVehicle));
        twoWheelerSlots.put("D3", new ParkingSlot("D3", ParkingSlotType.LargeVehicle));
        allParkingSlots.put(ParkingSlotType.LargeVehicle,largeVehicleSlots);

        Map<String, ParkingSlot> specialVehicleSlots = new HashMap<>();
        twoWheelerSlots.put("E1", new ParkingSlot("E1", ParkingSlotType.SpecialVehicle));
        twoWheelerSlots.put("E2", new ParkingSlot("E2", ParkingSlotType.SpecialVehicle));
        twoWheelerSlots.put("E3", new ParkingSlot("E3", ParkingSlotType.SpecialVehicle));
        allParkingSlots.put(ParkingSlotType.SpecialVehicle, specialVehicleSlots);

        ParkingFloor parkingFloor = new ParkingFloor("1", allParkingSlots);
        List<ParkingFloor> parkingFloors = new ArrayList<>();
        parkingFloors.add(parkingFloor);
        ParkingLot parkingLot = ParkingLot.getInstance(name, address, parkingFloors);
        System.out.println("Ticket Details " + parkingLot);

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber("MP-19-CA-2664");
        vehicle.setVehicleCategory(VehicleCategory.TwoWheeler);

        Ticket ticket = parkingLot.checkIn(vehicle);
        System.out.println("Ticket Details " + ticket);
        System.out.println("Ticket No: " + ticket.getTicketNumber());
        System.out.println("Ticket Vehicle Type " + ticket.getVehicle().getVehicleCategory());
        System.out.println("Ticket Parking Type " + ticket.getParkingSlot().parkingSlotType);
        System.out.println("Start Time" + ticket.getStartTime());

        Thread.sleep(10000);

        Invoice invoice = parkingLot.checkOut(ticket);
        System.out.println("Invoice Details" + invoice);


    }
}
