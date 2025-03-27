package org.example;

public class ParkingSlot {
    String name;
    boolean isAvailable = true;
    ParkingSlotType parkingSlotType;
    Vehicle vehicle;


    public ParkingSlot(String name, ParkingSlotType parkingSlotType){
        this.name = name;
        this.parkingSlotType = parkingSlotType;
    }

    protected boolean isAvailable(){
        return  this.isAvailable;
    }

    protected void addVehicle(Vehicle vehicle){
        if(!this.isAvailable){
            this.vehicle = vehicle;
            this.isAvailable = false;
        }
    }

    protected void removeVehicle(){
        if(this.isAvailable){
            this.vehicle = null;
            this.isAvailable = true;
        }

    }
}
