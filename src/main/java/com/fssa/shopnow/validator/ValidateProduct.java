package com.fssa.shopnow.validator;
import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.exception.*;

import java.util.List;
import java.util.regex.Pattern;

import com.fssa.shopnow.model.Product;

public class ValidateProduct {
	
	  private ValidateProduct() {
		  throw new IllegalStateException("Utility class");
	}
	
	public static boolean validate(Product mobile)
			throws InvalidProductException {

		// check for nullity of the parameter
		if (mobile == null) {
			throw new InvalidProductException(ProductErrors.INVALID_OBJECT);
		}
		// Check for name, name should only have alphabets
		// For Simplicity, Check if name has length of 2.
		validateID(mobile.getId());
		validateName(mobile.getName());
		validatePrice(mobile.getPrice()); 
		validateRam(mobile.getRam());
		validateStorage(mobile.getStorage());
		validateDescription(mobile.getDescription());
		validateImageURL(mobile.getImageURL());
		validateBrand(mobile.getBrand());
		validateQty(mobile.getQuantity());
		validateID(mobile.getSellerId());
		validateID(mobile.getShopId());
		
		return true;
		}

	//Validate the id
	public static boolean validateID(int id) throws InvalidProductException{
		if(id < 0) {
			throw new InvalidProductException(ProductErrors.INVALID_ID);
		}
		return true;
	}
	
	
	//Validate the mobile name
	public static boolean validateName(String name)
			throws InvalidProductException {
		if (name == null || "".equals(name.trim()) || name.length() < 4) {
			throw new InvalidProductException(ProductErrors.INVALID_NAME);
		}
		return true; 
	}
	
	//validate the mobile price
	public static boolean validatePrice(double price) throws InvalidProductException{
		
		if(!(price > 100 && price < 500000)) {
			throw new InvalidProductException(ProductErrors.INVALID_PRICE);
		}
		return true;
	}
	
	//verify Mobile ram
	public static boolean validateRam(int ram) throws InvalidProductException{
		if(!(ram == 1 || ram == 2 || ram == 3 || ram == 4 || ram == 6 || ram == 8 || ram == 12)) {
			throw new InvalidProductException(ProductErrors.INVALID_RAM);
		}
		return true;
	}
	
	//Verify Mobile storage
	public static boolean validateStorage(int storage) throws InvalidProductException{
		if(storage == 16 || storage == 32 || storage == 64 || storage == 128 || storage == 256 || storage == 512) {
			return true;
		}
		else
			throw new InvalidProductException(ProductErrors.INVALID_STORAGE);
	}
	
	//Validate the description
	public static boolean validateDescription(String description) throws InvalidProductException {
		if(description == null || "".equals(description.trim()) || description.length() < 4){
			throw new InvalidProductException(ProductErrors.INVALID_DESCRIPTION);
		}
		return true;
	}
	
	//Validate the imageURL
	public static boolean validateImageURL(List<String> imgUrls) throws InvalidProductException {
		 
		if(imgUrls.size() != 4){
			throw new InvalidProductException(ProductErrors.INVALID_IMAGEURL);
		}
		
		//Iterating each url's and check whether it's match with pattern or not
		for( String imgUrl : imgUrls){
			String imgUrlPattern = "^https?://[\\w.-]+(?:/\\S*)?$";
			Boolean isURLMatch = Pattern.matches(imgUrlPattern,imgUrl);
			
			if(!isURLMatch){ 
				throw new InvalidProductException(ProductErrors.INVALID_IMAGEURL);
			}
		}
		return true;
	}
	
	public static boolean validateBrand(String brand) throws InvalidProductException{
		if (brand == null || "".equals(brand.trim()) || brand.length() < 4) {
			throw new InvalidProductException(ProductErrors.INVALID_BRAND);
		}
		return true;
	}
	
	public static boolean validateQty(int quantity) throws InvalidProductException{
		if(quantity <= 0) {
			throw new InvalidProductException(ProductErrors.INVALID_QUANTITY);
		}
		return true;
	}
	
}
