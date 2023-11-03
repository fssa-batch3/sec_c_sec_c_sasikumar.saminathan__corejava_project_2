package com.fssa.shopnow.model;

import org.junit.Test; 
import org.junit.jupiter.api.Assertions;
import com.fssa.shopnow.model.*;


/**
 * This is a test class for the Address class, which tests the getters and setters of the Address attributes.
 */
public class TestAddress {

    // The area or locality where the address is located.
    String area = "Anna Nagar";

    int id = 1;
    int userId = 3;
    
    // The house number or flat/apartment number.
    String houseNumber = "12/34";

    // A landmark or point of reference near the address.
    String landMark = "Near Chennai Central Station";

    // The 6-digit PIN code representing the postal code of the address location.
    String pincode = "600001";
    
    String name = "sasi";
    String phoneNumber = "6385495849";

    // Create an Address object with the given values using the constructor.
    Address address = new Address(name, phoneNumber, area, houseNumber, landMark, pincode);

    /**
     * Test the getters of the Address class to ensure they return the correct attribute values.
     */
    @Test
    public void testAddressGetters() {
    	address.setId(id);
    	address.setUserId(userId);
        Assertions.assertEquals(area, address.getArea());
        Assertions.assertEquals(houseNumber, address.getHouseNumber());
        Assertions.assertEquals(landMark, address.getLandMark());
        Assertions.assertEquals(pincode, address.getPincode());
        Assertions.assertEquals(name, address.getName());
        Assertions.assertEquals(phoneNumber, address.getPhoneNumber());
        Assertions.assertEquals(id, address.getId());
        Assertions.assertEquals(userId, address.getUserId());
    }

    /**
     * Test the setter method for the area attribute of the Address class.
     */
    @Test
    public void testAreaSetter() {
        String newArea = "T Nagar";
        address.setArea(newArea);
        Assertions.assertEquals(newArea, address.getArea());
    }

    /**
     * Test the setter method for the house number attribute of the Address class.
     */
    @Test
    public void testHouseNumberSetter() {
        String newHouseNumber = "13/35";
        address.setHouseNumber(newHouseNumber);
        Assertions.assertEquals(newHouseNumber, address.getHouseNumber());
    }

    /**
     * Test the setter method for the landmark attribute of the Address class.
     */
    @Test
    public void testLandmarkSetter() {
        String newLandmark = "Opposite City Mall";
        address.setLandMark(newLandmark); 
        Assertions.assertEquals(newLandmark, address.getLandMark());
    }

    /**
     * Test the setter method for the pincode attribute of the Address class.
     */
    @Test
    public void testPincodeSetter() {
        String newPincode = "614810";
        address.setPincode(newPincode);
        Assertions.assertEquals(newPincode, address.getPincode());
    }
    
    @Test
    public void testIdSetter() {
        int newId = 2;
        address.setId(newId);
        Assertions.assertEquals(newId, address.getId());
    }
    
    @Test
    public void testUserIdSetter() {
        int newUserId = 4;
        address.setUserId(newUserId);
        Assertions.assertEquals(newUserId, address.getUserId());
    }
    
	@Test
	public void testNameSetter() {
		String newName = "SkKumar";
		address.setName(newName);
		Assertions.assertEquals(newName, address.getName());
	}
	
	@Test
	public void testMobileNumberSetter() {
		String newMobileNumber = "6398348943";
		address.setPhoneNumber(newMobileNumber);
		Assertions.assertEquals(newMobileNumber, address.getPhoneNumber());
	}

}
