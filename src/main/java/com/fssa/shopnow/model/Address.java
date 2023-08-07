package com.fssa.shopnow.model;

/*
 * This class represents an Address and contains information related to users' addresses.
 */

public class Address {

    // The area or locality where the address is located.
    String area;

    // The house number or flat/apartment number.
    String houseNumber;

    // A landmark or point of reference near the address.
    String landMark;

    // The 6-digit PIN code representing the postal code of the address location.
    String pincode;

    // Constructor for initializing Address objects with provided values.
    public Address(String area, String houseNumber, String landMark, String pincode) {
        this.area = area;
        this.houseNumber = houseNumber;
        this.landMark = landMark;
        this.pincode = pincode;
    }

    // Getters and setters for retrieving and updating the address properties.

    // Get the area of the address.
    public String getArea() {
        return area;
    }

    // Set the area of the address.
    public void setArea(String area) {
        this.area = area;
    }

    // Get the house number of the address.
    public String getHouseNumber() {
        return houseNumber;
    }

    // Set the house number of the address.
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    // Get the landmark near the address.
    public String getLandMark() {
        return landMark;
    }

    // Set the landmark near the address.
    public void setLandMark(String landMark) {
        this.landMark = landMark;
    }

    // Get the PIN code of the address.
    public String getPincode() {
        return pincode;
    }

    // Set the PIN code of the address.
    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

}
