package com.fssa.shopnow.validator;
import com.fssa.shopnow.errors.UserErrors;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.Address;
import com.fssa.shopnow.model.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestUserValidator {
	
	// Creating attributes for user object
	String name = "sasikumar";
	String email = "abc@gmail.com";
	String mobileNumber = "6398939499";
	String password = "839209#kdk";


	User user1 = new User(name, email, mobileNumber, password);
	
	//@Test
	public void testUserObject(){
		Assertions.assertTrue(ValidateUser.validate(user1));
		
		try{
			ValidateUser.validate(null);
			Assertions.fail(UserErrors.EXPECTED_FAIL);
		}
		catch(InvalidUserException e) {
			Assertions.assertEquals("User is null",e.getMessage());
		}
	}
	
	//@Test
	public void testName(){
		Assertions.assertTrue(ValidateUser.isValidName(name));
		
		try {
			ValidateUser.isValidName(null);
		} 
		catch(InvalidUserException e) {
			Assertions.assertEquals("name cannot be null or empty",e.getMessage());
		}
	}
}
