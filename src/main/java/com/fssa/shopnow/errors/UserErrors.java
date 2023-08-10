package com.fssa.shopnow.errors;

public final class UserErrors {
	
	   public UserErrors() {
		  throw new IllegalStateException("Utility class");
	}
		
	public static final String INVALID_OBJECT = "User object cannot be empty or null";
	public static final String INVALID_NAME = "User name cannot be null or lesser than 3 characters";
}
