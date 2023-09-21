package com.fssa.shopnow.validator;
import com.fssa.shopnow.model.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.fssa.shopnow.exception.*;

public class ValidateUser {
	
	  private ValidateUser() {
		  throw new IllegalStateException("Utility class");
	}
	  
	public static boolean validate(User user) throws InvalidUserException {
		if(user == null){
			throw new InvalidUserException("User is null");
		}
		
		isValidName(user.getName());
		isValidEmail(user.getEmail());
		isValidMobileNumber(user.getMobileNumber());
		isValidPassword(user.getPassword());
		
		return true;
	}
	
	public static boolean isValidName(String name) throws InvalidUserException {
		if(name == null || "".equals(name.trim()) || name.length() < 4){
			throw new InvalidUserException("name cannot be null or empty");
		}
		return true;
	}
	
	public static boolean isValidEmail(String email) throws InvalidUserException {
		if(email == null){
			throw new InvalidUserException("email cannot be null");
		}
		
		//Pattern for email
		String emailPattern = "^[\\w\\.-]+@[a-zA-Z\\d\\.-]+\\.[a-zA-Z]{2,}$";
		
		//If it's match with argument email it will return true else false
		Boolean isMatch = Pattern.matches(emailPattern, email);
		
		if(!isMatch){
			throw new InvalidUserException("Invalid email");
		}
		
		return true;
	}
	
	public static boolean isValidMobileNumber(String mobileNumber) throws InvalidUserException{
		if(mobileNumber == null){
			throw new InvalidUserException("mobileNumber cannot be null");
		}
        
        //If it's false throw an InvalidUserException
        if(mobileNumber.length() != 10){
        	throw new InvalidUserException("Invalid mobile number");
        }
        
        return true;
	}
	
	public static boolean isValidPassword(String password) throws InvalidUserException{
		
		if(password == null){
			throw new InvalidUserException("password cannot be null");
		}
		
		//Initializing the pattern for password
		String passwordPattern = "(?=^.{8,}$)((?=.*\\\\d)|(?=.*\\\\W+))(?![.\\\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(passwordPattern);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(password);
		
		//If it's false throw an InvalidUserException
		if(matcher.matches()){
			throw new InvalidUserException("Invalid password");
		}
		
		return true;
	}
	
}
