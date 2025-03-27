package org.example;

public class Address {
    String street;
    String building;
    String city;
    String state;
    String country;
    String postalCode;

    // Getters
    public String getStreet() { return street; }
    public String getBuilding() { return building; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public String getPostalCode() { return postalCode; }

    // Setters
    public void setStreet(String street) { this.street = street; }
    public void setBuilding(String building) { this.building = building; }
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setCountry(String country) { this.country = country; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public static class Builder {
        private String street;
        private String building;
        private String city;
        private String state;
        private String country;
        private String postalCode;

        public Builder street(String street) { this.street = street; return this; }
        public Builder building(String building) { this.building = building; return this; }
        public Builder city(String city) { this.city = city; return this; }
        public Builder state(String state) { this.state = state; return this; }
        public Builder country(String country) { this.country = country; return this; }
        public Builder postalCode(String postalCode) { this.postalCode = postalCode; return this; }

        public Address build() {
            Address address = new Address();
            address.street = this.street;
            address.building = this.building;
            address.city = this.city;
            address.state = this.state;
            address.country = this.country;
            address.postalCode = this.postalCode;
            return address;
        }
    }
}
