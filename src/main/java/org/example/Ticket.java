package org.example;

import java.sql.Time;

public class Ticket {
    private String ticketNumber;
    private Time startTime;
    private Time endTime;
    private Vehicle vehicle;
    private ParkingSlot parkingSlot;

    public static Ticket createTicket(Vehicle vehicle, ParkingSlot parkingSlot){
        return new Ticket.Builder()
                .ticketNumber(vehicle.getVehicleNumber()+System.currentTimeMillis())
                .startTime(new Time(System.currentTimeMillis()))
                .vehicle(vehicle)
                .parkingSlot(parkingSlot)
                .build();
    }

    // Getters
    public String getTicketNumber() { return ticketNumber; }
    public Time getStartTime() { return startTime; }
    public Time getEndTime() { return endTime; }
    public Vehicle getVehicle() { return vehicle; }
    public ParkingSlot getParkingSlot() { return parkingSlot; }

    // Setters
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }
    public void setStartTime(Time startTime) { this.startTime = startTime; }
    public void setEndTime(Time endTime) { this.endTime = endTime; }
    public void setVehicle(Vehicle vehicle) { this.vehicle = vehicle; }
    public void setParkingSlot(ParkingSlot parkingSlot) { this.parkingSlot = parkingSlot; }

    // Builder
    public static class Builder {
        private String ticketNumber;
        private Time startTime;
        private Time endTime;
        private Vehicle vehicle;
        private ParkingSlot parkingSlot;

        public Builder ticketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; return this; }
        public Builder startTime(Time startTime) { this.startTime = startTime; return this; }
        public Builder endTime(Time endTime) { this.endTime = endTime; return this; }
        public Builder vehicle(Vehicle vehicle) { this.vehicle = vehicle; return this; }
        public Builder parkingSlot(ParkingSlot parkingSlot) { this.parkingSlot = parkingSlot; return this; }

        public Ticket build() {
            Ticket ticket = new Ticket();
            ticket.ticketNumber = this.ticketNumber;
            ticket.startTime = this.startTime;
            ticket.endTime = this.endTime;
            ticket.vehicle = this.vehicle;
            ticket.parkingSlot = this.parkingSlot;
            return ticket;
        }
    }
}
