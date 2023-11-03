package com.fssa.shopnow.errors;

public final class UserErrors {
	
	   private UserErrors() {
		  throw new IllegalStateException("Utility class");
	}
		
	public static final String INVALID_OBJECT = "User object cannot be empty or null";
	public static final String INVALID_NAME = "User name cannot be null or lesser than 3 characters";
	public static final String EXPECTED_FAIL = "Expected InvalidUserException";
	public static final String CREATE_ERROR = "Error in creating user";
	public static final String UPDATE_ERROR = "Error in updating user";
	public static final String GET_ERROR = "Error in get products";
	public static final String EMAIL_ERROR = "email cannot be null";
	public static final String INVALID_EMAIL = "Invalid email";
	public static final String NULL_MOBILE_NUMBER = "Mobile number cannot be null or empty";
	public static final String INVALID_MOBILE_NUMBER = "Invalid mobile number";
	public static final String NULL_PASSWORD = "Password cannot be null";
	public static final String INVALID_PASSWORD = "Invalid password";
}
