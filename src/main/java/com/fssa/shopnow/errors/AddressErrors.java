package com.fssa.shopnow.errors;

/**
 * The AddressErrors interface defines constants for error messages related to Address validation.
 * These constants provide descriptive error messages that can be used to communicate specific
 * validation issues related to Address attributes in the application.
 * By using constants, it ensures consistency in error message handling throughout the codebase.
 */
public final class AddressErrors {
	
	   private AddressErrors() {
		  throw new IllegalStateException("Utility class");
	}


    /**
     * Error message for an invalid Address object.
     */
    public static final String INVALID_OBJECT = "Address object cannot be null";

    /**
     * Error message for an invalid area attribute in the Address.
     */
    public static final String INVALID_AREA = "Area cannot be null or less than 3 characters";

    /**
     * Error message for an empty or null house number attribute in the Address.
     */
    public static final String EMPTY_HOUSE_NUMBER = "House number cannot be empty";

    /**
     * Error message for an invalid house number pattern in the Address.
     */
    public static final String INVALID_HOUSE_NUMBER = "Invalid house number";

    /**
     * Error message for an invalid landmark attribute in the Address.
     */
    public static final String INVALID_LANDMARK = "Landmark cannot be empty or less than 3 characters";

    /**
     * Error message for an empty or null pincode attribute in the Address.
     */
    public static final String EMPTY_PINCODE = "Pincode cannot be empty";

    /**
     * Error message for an invalid pincode pattern in the Address.
     */
    public static final String INAVLID_PINCODE = "Invalid pincode";
    
    /*
     * Error message for an failure message in test case
     */
    public static final String EXPECT_FAIL = "Expected InvalidAddressException";
    
    public static final String INVALID_ID = "Address id is invalid";
    
    public static final String INVALID_NAME = "name cannot be empty or less than 3 characters";
    
    public static final String INVALID_PHONENUMBER = "mobileNumber cannot be empty";
    
    public static final String INVALID_PHONENUMBER_PATTERN = "Invalid phone number. Please enter a valid Indian phone number.";
    
    
}
