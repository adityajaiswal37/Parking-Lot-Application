package org.example;

import java.sql.Time;

public class Invoice {
    private Time startTime;
    private Time endTime;
    private Price basePrice;
    private double gst;
    private double serviceTax;
    private double totalAmountPaid;

    // Constructor
    private Invoice(Builder builder) {
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
        this.basePrice = builder.basePrice;
        this.gst = builder.gst;
        this.serviceTax = builder.serviceTax;
        this.totalAmountPaid = builder.totalAmountPaid;
    }

    // Getters
    public Time getStartTime() { return startTime; }
    public Time getEndTime() { return endTime; }
    public Price getBasePrice() { return basePrice; }
    public double getGst() { return gst; }
    public double getServiceTax() { return serviceTax; }
    public double getTotalAmountPaid() { return totalAmountPaid; }

    // Setters
    public void setStartTime(Time startTime) { this.startTime = startTime; }
    public void setEndTime(Time endTime) { this.endTime = endTime; }
    public void setBasePrice(Price basePrice) { this.basePrice = basePrice; }
    public void setGst(double gst) { this.gst = gst; }
    public void setServiceTax(double serviceTax) { this.serviceTax = serviceTax; }
    public void setTotalAmountPaid(double totalAmountPaid) { this.totalAmountPaid = totalAmountPaid; }

    // Builder Class
    public static class Builder {
        private Time startTime;
        private Time endTime;
        private Price basePrice;
        private double gst;
        private double serviceTax;
        private double totalAmountPaid;

        public Builder startTime(Time startTime) { this.startTime = startTime; return this; }
        public Builder endTime(Time endTime) { this.endTime = endTime; return this; }
        public Builder basePrice(Price basePrice) { this.basePrice = basePrice; return this; }
        public Builder gst(double gst) { this.gst = gst; return this; }
        public Builder serviceTax(double serviceTax) { this.serviceTax = serviceTax; return this; }
        public Builder totalAmountPaid(double totalAmountPaid) { this.totalAmountPaid = totalAmountPaid; return this; }

        public Invoice build() {
            return new Invoice(this);
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", basePrice=" + basePrice +
                ", gst=" + gst +
                ", serviceTax=" + serviceTax +
                ", totalAmountPaid=" + totalAmountPaid +
                '}';
    }
}
