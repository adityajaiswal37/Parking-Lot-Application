package org.example;

import java.sql.Time;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ParkingLot {
    private String name;
    private Address address;
    private List<ParkingFloor> parkingFloors;
    private static ParkingLot parkingLot = null;

    private ParkingLot(String name, Address address, List<ParkingFloor> parkingFloors){
        this.name = name;
        this.address = address;
        this.parkingFloors = parkingFloors;
    }

    public static ParkingLot getInstance(String name, Address address, List<ParkingFloor> parkingFloors){
        if(parkingLot == null){
            parkingLot = new ParkingLot(name, address, parkingFloors);
        }

        return  parkingLot;
    }

    public void addFloors(String name, Map<ParkingSlotType, Map<String,ParkingSlot>> parkSlots){
        ParkingFloor parkingFloor = new ParkingFloor(name,parkSlots);
        parkingFloors.add(parkingFloor);
    }

    public void removeFloors(ParkingFloor parkingFloor){
        parkingFloors.remove(parkingFloor);
    }

    public Ticket checkIn(Vehicle vehicle){
        ParkingSlot parkingSlot = getParkingSlotForVehicleAndPark(vehicle);
        if(parkingSlot == null) return null;

        Ticket parkingTicket = createTicketForSlot(parkingSlot, vehicle);

        //Save it to Database

        return parkingTicket;
    }

    public Invoice checkOut(Ticket ticket) {
        // Step 1: Calculate Ticket Price
        Price ticketPrice = getTicketPrice(ticket);

        // Step 2: Process Payment
        Invoice invoice = scanAndPay(ticketPrice);

        // Step 3: Remove Vehicle from Parking Slot if Payment is Successful
        if (invoice != null) {
            ticket.getParkingSlot().removeVehicle();
        }

        // Step 4: Save Invoice to Database (Assuming a method saveInvoice exists)
//        saveInvoice(invoice);

        // Step 5: Return the Generated Invoice
        return invoice;
    }

    private Invoice scanAndPay(Price ticketPrice) {
        if (ticketPrice == null) return null;

        double gst = ticketPrice.getGst() * 0.18;
        double serviceTax = ticketPrice.getServiceTax() * 0.18;
        double totalAmount = ticketPrice.getTotalPrice();

        return new Invoice.Builder()
                .basePrice(ticketPrice)
                .gst(gst)
                .serviceTax(serviceTax)
                .totalAmountPaid(totalAmount)
                .build();
    }



    private ParkingSlot getParkingSlotForVehicleAndPark(Vehicle vehicle){
        ParkingSlot parkingSlot = null;
        for(ParkingFloor floor : parkingFloors){
            parkingSlot = floor.getRelevantSlotForVehicleAndPark(vehicle);
            if(parkingSlot != null) break;
        }

        return  parkingSlot;
    }

    private Ticket createTicketForSlot(ParkingSlot parkingSlot, Vehicle vehicle){
        return Ticket.createTicket(vehicle, parkingSlot);
    }

    private Price getTicketPrice(Ticket ticket){
        Time endTime = new Time(System.currentTimeMillis());
        long durationInMillis = endTime.getTime() - ticket.getStartTime().getTime();
        long durationInMinutes = TimeUnit.MILLISECONDS.toMinutes(durationInMillis) % 60;

        ParkingFeeCalculator calculator = new ParkingFeeCalculator();
        Price totalPrice = calculator.calculatePrice(ticket, durationInMinutes);

        return  totalPrice;
    }
}
