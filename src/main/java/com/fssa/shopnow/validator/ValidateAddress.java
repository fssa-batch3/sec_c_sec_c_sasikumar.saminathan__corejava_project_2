package com.fssa.shopnow.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.shopnow.errors.AddressErrors;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.Address;
/**
 * The ValidateAddress class provides methods to validate the attributes of an Address object.
 * It performs various checks to ensure the integrity and validity of address-related information.
 * If any validation fails, it throws an InvalidAddressException with an appropriate error message.
 */

public class ValidateAddress {
	
	  private ValidateAddress() {
		  throw new IllegalStateException("Utility class"); 
	}

	public static boolean isValidObj(Address address) throws InvalidAddressException {

		// Check the nullity of the object
		if (address == null) {
			throw new InvalidAddressException(AddressErrors.INVALID_OBJECT);
		}
		 
		//Validate the all attrubiutes 
		isValidName(address.getName());
		isValidMobileNumber(address.getPhoneNumber());
		isvalidId(address.getUserId());
		isValidArea(address.getArea());
		isValidHouseNumber(address.getHouseNumber());
		isValidLandmark(address.getLandMark());
		isValidPincode(address.getPincode());

		return true;
	}
	
	//Validate the id
	public static boolean isvalidId(int id) throws InvalidAddressException{
		if(id < 0) {
			throw new InvalidAddressException(AddressErrors.INVALID_ID);
		}
		return true;
	}
	
	public static boolean isValidName(String name) throws InvalidAddressException {
		if(name == null || "".equals(name.trim()) || name.length() < 3){
			throw new InvalidAddressException(AddressErrors.INVALID_NAME);
		}
		return true;
	}
	
	public static boolean isValidMobileNumber(String mobileNumber) throws InvalidAddressException{
		if(mobileNumber == null){
			throw new InvalidAddressException(AddressErrors.INVALID_PHONENUMBER);
		}
		
		String regex = "^(\\+91|91)?[6789]\\d{9}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(mobileNumber);
		boolean isMatch = matcher.matches();
        
        //If it's false throw an InvalidUserException
        if(!isMatch){
        	throw new InvalidAddressException(AddressErrors.INVALID_PHONENUMBER_PATTERN);
        }
        
        return true;
	}

	public static boolean isValidArea(String area) throws InvalidAddressException {
		if (area == null || "".equals(area.trim()) || area.length() < 3) {
			throw new InvalidAddressException(AddressErrors.INVALID_AREA);
		}
		return true;
	}

	public static boolean isValidHouseNumber(String houseNumber) throws InvalidAddressException {
		// Check if the house number is not empty
		if (houseNumber == null || houseNumber.trim().isEmpty()) {
			throw new InvalidAddressException(AddressErrors.EMPTY_HOUSE_NUMBER);
		}


		String regexPattern = "^[\\w\\s\\-/]+$";

		// Matching the pattern and return the boolean value
		Boolean isMatch = Pattern.matches(regexPattern, houseNumber);

		// if that false throw an InvalidAddressException
		if (!isMatch) {
			throw new InvalidAddressException(AddressErrors.INVALID_HOUSE_NUMBER);
		}

		return true;
	}

	public static boolean isValidLandmark(String landmark) throws InvalidAddressException{

		// Check the landmark if it's null or contains only white spaces or length less
		// than 3 charcters
		// throw an InvalidAddressException
		if (landmark == null || landmark.isBlank() || landmark.length() < 3) {
			throw new InvalidAddressException(AddressErrors.INVALID_LANDMARK);
		}
		return true;
	}

	public static boolean isValidPincode(String pincode) throws InvalidAddressException{
		// Check the landmark if it's null or contains only white spaces throw an
		// InvalidAddressException
		if (pincode == null || pincode.isBlank()) {
			throw new InvalidAddressException(AddressErrors.EMPTY_PINCODE);
		}

		// Use a regular expression to validate the Indian PIN code pattern
		// The regex pattern checks for exactly 6 digits (0-9)
		String regexPattern = "^[0-9]{6}$";
		
		// Matching the pattern and return the boolean value
		Boolean isMatch = Pattern.matches(regexPattern, pincode);

		// if that false throw an InvalidAddressException
		if (!isMatch) {
			throw new InvalidAddressException(AddressErrors.INAVLID_PINCODE);
		}

		return true;
	}
}
