package com.fssa.shopnow.validator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.shopnow.errors.AddressErrors;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.validator.*; 

public class TestAddressValidator {
	
    
	 int id = 3;
	 String name = "Ramkumar";
	 String phoneNumber = "6395954959";
	 String area = "Anna Nagar";
	 String houseNumber = "12/34";
	 String landMark = "Near Chennai Central Station";
	 String pincode = "600001";
	 int userId = 2;

    // Create an Address object with the given values using the constructor.
    Address address = new Address(id, name, phoneNumber, area, houseNumber, landMark, pincode, userId);
    
    @Test
    public void testObject() {
    	
    	//validate the address it will return true 
    	Assertions.assertTrue(ValidateAddress.isValidObj(address));
    	
    	try {
			ValidateAddress.isValidObj(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_OBJECT,e.getMessage());
		}
    }
    
    @Test
    public void testArea(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidArea(area));
    	
    	try {
			ValidateAddress.isValidArea(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_AREA,e.getMessage());
		}
    }
    
    @Test
    public void testHouseNumber(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidHouseNumber(houseNumber));
    	
    	try {
			ValidateAddress.isValidHouseNumber(null);  
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.EMPTY_HOUSE_NUMBER,e.getMessage());
		}
    }
    
    @Test
    public void testLandmark(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidLandmark(landMark));
    	
    	try {
			ValidateAddress.isValidLandmark(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_LANDMARK,e.getMessage());
		} 
    }
     
    @Test
    public void testPincode(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidPincode(pincode));
    	
    	try {
			ValidateAddress.isValidPincode(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.EMPTY_PINCODE,e.getMessage());
		}
    }
    
    @Test
    public void testId(){
    	
    	Assertions.assertTrue(ValidateAddress.isvalidId(id));
    	
    	try {
			ValidateAddress.isvalidId(-4);
			Assertions.fail(AddressErrors.INVALID_ID);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_ID,e.getMessage());
		}
    }
    
    @Test
    public void testName(){
    	
    	Assertions.assertTrue(ValidateAddress.isValidName(name));
    	
    	try {
			ValidateAddress.isValidName(null);
			Assertions.fail(AddressErrors.INVALID_NAME);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_NAME,e.getMessage());
		}
    }
    
    @Test
    public void testMobileNumber(){
    	
    	Assertions.assertTrue(ValidateAddress.isValidMobileNumber(phoneNumber));
    	
    	try {
			ValidateAddress.isValidMobileNumber(null);
			Assertions.fail(AddressErrors.INVALID_PHONENUMBER);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_PHONENUMBER,e.getMessage());
		}
    }
    
    @Test
    public void testUserId(){
    	
    	Assertions.assertTrue(ValidateAddress.isvalidId(userId));
    	
    	try {
			ValidateAddress.isvalidId(-4);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(AddressErrors.INVALID_ID,e.getMessage());
		}
    }
}
