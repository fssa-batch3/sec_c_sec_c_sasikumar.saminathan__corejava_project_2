package com.fssa.shopnow.validator;
import com.fssa.shopnow.errors.UserErrors;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestUserValidator {
	
	// Creating attributes for user object
	int id = 1;
	String name = "sasikumar";
	String email = "abc@gmail.com";
	String mobileNumber = "6398939499";
	String password = "839209#Sdk";


	// Create a User object for testing
	User user1 = new User(id, name, email, mobileNumber, password);

	// Test case for validating a User object
	@Test
	public void testUserObject() {
	    // Assert that the User object is valid
	    Assertions.assertTrue(ValidateUser.validate(user1));
	    
	    try {
	        // Attempt to validate a null User object, expecting an InvalidUserException
	        ValidateUser.validate(null);
	        Assertions.fail(UserErrors.EXPECTED_FAIL);
	    } catch (InvalidUserException e) {
	        // Ensure that the correct error message is received
	        Assertions.assertEquals(UserErrors.INVALID_OBJECT, e.getMessage());
	    }
	}

	// Test case for validating User name
	@Test
	public void testName() {
	    // Assert that the User name is valid
	    Assertions.assertTrue(ValidateUser.isValidName(name));
	    
	    try {
	        // Attempt to validate a null User name, expecting an InvalidUserException
	        ValidateUser.isValidName(null);
	    } catch (InvalidUserException e) {
	        // Ensure that the correct error message is received
	        Assertions.assertEquals(UserErrors.INVALID_NAME, e.getMessage());
	    }
	}

	// Test case for validating User email
	@Test
	public void testEmail() {
	    // Assert that the User email is valid
	    Assertions.assertTrue(ValidateUser.isValidEmail(email));
	    
	    try {
	        // Attempt to validate a null User email, expecting an InvalidUserException
	        ValidateUser.isValidEmail(null);
	    } catch (InvalidUserException e) {
	        // Ensure that the correct error message is received
	        Assertions.assertEquals(UserErrors.EMAIL_ERROR, e.getMessage());
	    }
	}

	// Test case for validating User mobile number
	@Test
	public void testMobileNumber() {
	    // Assert that the User mobile number is valid
	    Assertions.assertTrue(ValidateUser.isValidMobileNumber(mobileNumber));
	    
	    try {
	        // Attempt to validate a null User mobile number, expecting an InvalidUserException
	        ValidateUser.isValidMobileNumber(null);
	    } catch (InvalidUserException e) {
	        // Ensure that the correct error message is received
	        Assertions.assertEquals(UserErrors.NULL_MOBILE_NUMBER, e.getMessage());
	    }
	}

	// Test case for validating User password
	@Test
	public void testPassword() {
	    // Assert that the User password is valid
	    Assertions.assertTrue(ValidateUser.isValidPassword(password));
	    
	    try {
	        // Attempt to validate a null User password, expecting an InvalidUserException
	        ValidateUser.isValidPassword(null);
	    } catch (InvalidUserException e) {
	        // Ensure that the correct error message is received
	        Assertions.assertEquals(UserErrors.NULL_PASSWORD, e.getMessage());
	    }
	}

}
