package com.fssa.shopnow.model;

/*
 * This class represents an Address and contains information related to users' addresses.
 */

public class Address {

	private int id;
	private String name;
	private String phoneNumber;
	private String area;
	private String houseNumber;
	private String landMark;
	private String pincode;
	private int userId;

    // Constructor for initializing Address objects with provided values.
    public Address(String name, String phoneNumber, String area, String houseNumber, String landMark,
			String pincode) {
		
		this.name = name;
		this.phoneNumber = phoneNumber;
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

    //Get the name of the address
	public String getName() {
		return name;
	}

	//Set the name of the address
	public void setName(String name) {
		this.name = name;
	}

	//Get the name of the address
	public String getPhoneNumber() {
		return phoneNumber;
	}

	//Set the phoneNumber of the address
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//Get the userId of the address
	public int getUserId() {
		return userId;
	}

	//Set the UserId of the address
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
   
}
