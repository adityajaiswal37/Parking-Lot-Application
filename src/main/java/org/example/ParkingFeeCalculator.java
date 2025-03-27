package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class ParkingFeeCalculator {
    private static final double GST_RATE = 0.18;
    private static final double SERVICE_TAX_RATE = 0.18;

    public Price calculatePrice(Ticket ticket, long durationInMinutes) {
        if (ticket == null || ticket.getVehicle() == null || ticket.getVehicle().getVehicleCategory() == null) {
            throw new IllegalArgumentException("Invalid ticket or vehicle details");
        }

        VehicleCategory category = ticket.getVehicle().getVehicleCategory();
        double hourlyRate = getHourlyRate(category);

        // Convert duration to hours and round up
        double hours = Math.ceil(durationInMinutes / 60.0);
        double basePrice = hours * hourlyRate;

        // Apply GST and service tax
        double gst = basePrice * GST_RATE;
        double serviceTax = basePrice * SERVICE_TAX_RATE;
        double totalPrice = basePrice + gst + serviceTax;

        // Round to 2 decimal places
        totalPrice = BigDecimal.valueOf(totalPrice)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();

        return new Price(basePrice, gst, serviceTax, totalPrice);
    }

    private double getHourlyRate(VehicleCategory category) {
        return switch (category) {
            case TwoWheeler -> 20;
            case ThreeWheeler -> 30;
            case HotchBack, Sedan, SUV -> 40;
            case Truck, Bus -> 100;
        };
    }
}
