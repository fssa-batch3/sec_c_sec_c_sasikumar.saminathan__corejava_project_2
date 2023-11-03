package com.fssa.shopnow.validator;
import com.fssa.shopnow.model.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.shopnow.errors.UserErrors;
import com.fssa.shopnow.exception.*;

public class ValidateUser {
	
	  private ValidateUser() {
		  throw new IllegalStateException("Utility class");
	}
	  
	public static boolean validate(User user) throws InvalidUserException {
		if(user == null){
			throw new InvalidUserException(UserErrors.INVALID_OBJECT);
		}
		
		isValidName(user.getName());
		isValidEmail(user.getEmail());
		isValidMobileNumber(user.getMobileNumber());
		isValidPassword(user.getPassword());
		
		return true;
	}
	
	public static boolean isValidName(String name) throws InvalidUserException {
		if(name == null || "".equals(name.trim()) || name.length() < 4){
			throw new InvalidUserException(UserErrors.INVALID_NAME);
		}
		return true;
	}
	
	public static boolean isValidEmail(String email) throws InvalidUserException {
		if(email == null){
			throw new InvalidUserException(UserErrors.EMAIL_ERROR);
		}
		
		String emailPattern = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
		Pattern pattern = Pattern.compile(emailPattern);
		Matcher matcher = pattern.matcher(email);
		Boolean isMatch = matcher.matches();
	
		if(!isMatch){
			throw new InvalidUserException(UserErrors.INVALID_EMAIL);
		}
		
		return true;
	}
	
	public static boolean isValidMobileNumber(String mobileNumber) throws InvalidUserException{
		if(mobileNumber == null){
			throw new InvalidUserException(UserErrors.NULL_MOBILE_NUMBER);
		}
		
		String regex = "^(\\+91|91)?[6789]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobileNumber);
		boolean isMatch = matcher.matches();
        
        //If it's false throw an InvalidUserException
        if(!isMatch){
        	throw new InvalidUserException(UserErrors.INVALID_MOBILE_NUMBER);
        }
        
        return true;
	}
	
	public static boolean isValidPassword(String password) throws InvalidUserException{
		
		if(password == null){
			throw new InvalidUserException(UserErrors.NULL_PASSWORD);
		}
		
		//Initializing the pattern for password
		String passwordPattern = "(?=^.{8,}$)((?=.*\\\\d)|(?=.*\\\\W+))(?![.\\\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
		
        // Compile the regex pattern
        Pattern pattern = Pattern.compile(passwordPattern);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(password);
		
		//If it's false throw an InvalidUserException
		if(matcher.matches()){
			throw new InvalidUserException(UserErrors.INVALID_PASSWORD);
		}
		
		return true;
	}
	
}
