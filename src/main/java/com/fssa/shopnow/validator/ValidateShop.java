package com.fssa.shopnow.validator;

import java.util.List;
import java.util.regex.Pattern;

import com.fssa.shopnow.errors.AddressErrors;
import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.errors.ShopErrors;
import com.fssa.shopnow.exception.InvalidAddressException;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.exception.InvalidShopException;
import com.fssa.shopnow.exception.InvalidUserException;
import com.fssa.shopnow.model.Shop;

public class ValidateShop {
	
	private ValidateShop() {
		  throw new IllegalStateException("Utility class");
	}
	
	public static boolean validate(Shop shop) throws InvalidShopException {
		if(shop == null) {
			throw new InvalidShopException(ShopErrors.NULL_OBJECT);
		}
		
		isValidName(shop.getName());
		isValidMobileNumber(shop.getPhoneNumber());
		isValidId(shop.getId());
		isValidLatitude(shop.getLat());
		isValidLongtitude(shop.getLon());
		isValidLicense(shop.getLicense());
		isValidPincode(shop.getPincode());
		isValidAddress(shop.getAddress());
		isValidArea(shop.getArea());
		isValidId(shop.getSellerId());
		isValidImageURL(shop.getImage());
		
		return true;
	}
	
	public static boolean isValidName(String name) throws InvalidShopException {
		if(name == null || "".equals(name.trim()) || name.length() < 4){
			throw new InvalidShopException(ShopErrors.NULL_NAME);
		}
		return true;
	}
	
	public static boolean isValidMobileNumber(String mobileNumber) throws InvalidShopException{
		if(mobileNumber == null){
			throw new InvalidShopException(ShopErrors.NULL_MOBILE_NUMBER);
		}
        
        //If it's false throw an InvalidUserException
        if(mobileNumber.length() != 10){
        	throw new InvalidShopException(ShopErrors.INVALID_MOBILE_NUMBER);
        }
        
        return true;
	}
	
	//Validate the id
	public static boolean isValidId(int id) throws InvalidShopException{
		if(id < 0) {
			throw new InvalidShopException(ShopErrors.INVALID_ID);
		}
		return true;
	}
	
	//Validate the imageURL
	public static boolean isValidImageURL(String imgUrl) throws InvalidShopException {
		 
		if(imgUrl == null){
			throw new InvalidShopException(ShopErrors.INVALID_IMAGEURL);
		}
		
		//Iterating each url's and check whether it's match with pattern or not
			String imgUrlPattern = "^https?://[\\w.-]+(?:/\\S*)?$";
			Boolean isURLMatch = Pattern.matches(imgUrlPattern,imgUrl);
			
			if(!isURLMatch){ 
				throw new InvalidShopException(ShopErrors.INVALID_IMAGEURL);
			}
		
		return true;
	}
	
	public static boolean isValidArea(String area) throws InvalidShopException {
		if (area == null || "".equals(area.trim()) || area.length() < 3) {
			throw new InvalidShopException(ShopErrors.INVALID_AREA);
		}
		return true;
	}
	
	public static boolean isValidPincode(String pincode) {
		// Check the landmark if it's null or contains only white spaces throw an
		// InvalidAddressException
		if (pincode == null || pincode.isBlank()) {
			throw new InvalidShopException(ShopErrors.EMPTY_PINCODE);
		}

		// Use a regular expression to validate the Indian PIN code pattern
		// The regex pattern checks for exactly 6 digits (0-9)
		String regexPattern = "^[0-9]{6}$";
		// Matching the pattern and return the boolean value
		Boolean isMatch = Pattern.matches(regexPattern, pincode);

		// if that false throw an InvalidAddressException
		if (!isMatch) {
			throw new InvalidShopException(ShopErrors.INAVLID_PINCODE);
		}

		return true;
	}
	
	public static boolean isValidAddress(String address) throws InvalidShopException{
		
		if(address == null || "".equals(address.trim()) || address.length() < 4){
			throw new InvalidShopException(ShopErrors.NULL_ADDRESS);
		}
		return true;
	}
	
    public static boolean isValidLatitude(double latitude) throws InvalidShopException {
        boolean isValid = latitude >= -90.0 && latitude <= 90.0;
        
        if(!isValid){
        	throw new InvalidShopException(ShopErrors.INVALID_LAT);
        }
        return true;
    }
    
    public static boolean isValidLongtitude(double longitude) throws InvalidShopException {
        boolean isValid = longitude >= -180.0 && longitude <= 180.0;
        
        if(!isValid){
        	throw new InvalidShopException(ShopErrors.INVALID_LON);
        }
        return true;
    }
    
	public static boolean isValidLicense(String licesnse) throws InvalidShopException {
		if(licesnse == null || "".equals(licesnse.trim()) || licesnse.length() < 4){
			throw new InvalidShopException(ShopErrors.NULL_LICENSE);
		}
		return true;
	}
		
}
