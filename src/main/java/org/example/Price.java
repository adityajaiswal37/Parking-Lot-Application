package org.example;

public class Price {
    private final double basePrice;
    private final double gst;
    private final double serviceTax;
    private final double totalPrice;

    public Price(double basePrice, double gst, double serviceTax, double totalPrice) {
        this.basePrice = basePrice;
        this.gst = gst;
        this.serviceTax = serviceTax;
        this.totalPrice = totalPrice;
    }

    public double getBasePrice() { return basePrice; }
    public double getGst() { return gst; }
    public double getServiceTax() { return serviceTax; }
    public double getTotalPrice() { return totalPrice; }

    @Override
    public String toString() {
        return "Base Price: " + basePrice + " | GST: " + gst + " | Service Tax: " + serviceTax + " | Total: " + totalPrice;
    }
}
