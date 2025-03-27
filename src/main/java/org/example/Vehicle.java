package org.example;

public class Vehicle {
    private String vehicleNumber;
    private VehicleCategory vehicleCategory;

    // Getters
    public String getVehicleNumber() { return vehicleNumber; }
    public VehicleCategory getVehicleCategory() { return vehicleCategory; }

    // Setters
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    public void setVehicleCategory(VehicleCategory vehicleCategory) { this.vehicleCategory = vehicleCategory; }

    // Builder
    public static class Builder {
        private String vehicleNumber;
        private VehicleCategory vehicleCategory;

        public Builder vehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; return this; }
        public Builder vehicleCategory(VehicleCategory vehicleCategory) { this.vehicleCategory = vehicleCategory; return this; }

        public Vehicle build() {
            Vehicle vehicle = new Vehicle();
            vehicle.vehicleNumber = this.vehicleNumber;
            vehicle.vehicleCategory = this.vehicleCategory;
            return vehicle;
        }
    }
}
