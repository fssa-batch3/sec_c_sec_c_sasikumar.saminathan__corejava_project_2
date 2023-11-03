package com.fssa.shopnow.errors;

public final class ShopErrors {

	// Private constructor to prevent instantiation, as this is a utility class
	   private ShopErrors() {
		  throw new IllegalStateException("Utility class");
	   }
	   
	// Error messages for various validation and exception scenarios
	   public static final String EXPECTED_FAIL = "Expected InvalidShopException";
	   public static final String NULL_OBJECT = "Shop cannot be null";
	   public static final String NULL_NAME = "Name cannot be null or empty";
	   public static final String NULL_MOBILE_NUMBER = "Mobile number cannot be null";
	   public static final String INVALID_MOBILE_NUMBER = "Invalid mobile number";
	   public static final String INVALID_ID = "Shop ID cannot be less than 1";
	   public static final String INVALID_IMAGEURL = "Shop imageURL format is invalid";
	   public static final String INVALID_AREA = "Area cannot be null or less than 3 characters";
	   public static final String EMPTY_PINCODE = "Pincode cannot be null or empty";
	   public static final String INAVLID_PINCODE = "Invalid pincode";
	   public static final String NULL_ADDRESS = "address cannot be null or empty";
	   public static final String INVALID_LAT = "Invalid latitude";
	   public static final String INVALID_LON = "Invalid longtitude";
	   public static final String NULL_LICENSE = "License cannot be null or empty";	   
}
