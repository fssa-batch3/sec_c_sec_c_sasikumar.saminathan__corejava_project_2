package com.fssa.shopnow.validator;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.shopnow.errors.AddressErrors;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.validator.*;

public class TestAddressValidator {
	
    // The area or locality where the address is located.
    String area = "Anna Nagar";

    // The house number or flat/apartment number.
    String houseNumber = "12/34";

    // A landmark or point of reference near the address.
    String landMark = "Near Chennai Central Station";

    // The 6-digit PIN code representing the postal code of the address location.
    String pincode = "600001";

    // Create an Address object with the given values using the constructor.
    Address address = new Address(area, houseNumber, landMark, pincode);
    
    public void testObject() {
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidObj(address));
    	
    	try {
			ValidateAddress.isValidObj(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(e.getMessage(),AddressErrors.INVALID_OBJECT);
		}
    }
    
    public void testArea(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidArea(area));
    	
    	try {
			ValidateAddress.isValidArea(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(e.getMessage(),AddressErrors.INVALID_AREA);
		}
    }
    
    public void testHouseNumber(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidHouseNumber(houseNumber));
    	
    	try {
			ValidateAddress.isValidHouseNumber(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(e.getMessage(),AddressErrors.INVALID_HOUSE_NUMBER);
		}
    }
    
    public void testLandmark(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidLandmark(landMark));
    	
    	try {
			ValidateAddress.isValidLandmark(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(e.getMessage(),AddressErrors.INVALID_LANDMARK);
		}
    }
    
    public void testPincode(){
    	
    	//validate the address it will return true
    	Assertions.assertTrue(ValidateAddress.isValidPincode(pincode));
    	
    	try {
			ValidateAddress.isValidPincode(null);
			Assertions.fail(AddressErrors.EXPECT_FAIL);
		} catch (InvalidAddressException e) {
			Assertions.assertEquals(e.getMessage(),AddressErrors.EMPTY_PINCODE);
		}
    }
}
