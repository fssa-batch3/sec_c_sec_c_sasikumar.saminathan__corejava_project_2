package com.fssa.shopnow.validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.exception.*;
import com.fssa.shopnow.model.Product;
import com.fssa.shopnow.validator.*;

public class TestProductValidator {
	// Declaring the values for product
	int id = 1;
	String name = "Mobile Phone";
	double price = 499.99;
	int ram = 8;
	int storage = 128;
	String description = "A powerful mobile phone.";
	String[] arr = { "https://example.com/image1.jpg", "https://example.com/image1.jpg",
			"https://example.com/image1.jpg", "https://example.com/image1.jpg" };
	List<String> imageURL = new ArrayList<String>(Arrays.asList(arr));
	int quantity = 10;
	String brand = "BrandX"; 

	// Insert the declared values for product via constructor
	Product product = new Product(id, name, price, ram, storage, description, imageURL, quantity, brand);
	
	@Test
	public void testProductObject(){
		//Validate the object
		Assertions.assertTrue(ValidateProduct.validate(product));
		
		try {
			ValidateProduct.validate(null);
			Assertions.fail(ProductErrors.EXPECT_FAIL); 
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_OBJECT,e.getMessage());
		}
	}
	
	@Test
	public void testProductName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateName(name));
		
		try {
			ValidateProduct.validateName(null);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_NAME,e.getMessage());
		}
	}
	
	@Test
	public void testProductID(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateID(id));
		
		try {
			ValidateProduct.validateID(-3);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_ID,e.getMessage());
		}
	}
	
	@Test
	public void testPriceName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validatePrice(price));
		
		
	}
	
	@Test
	public void testInvalidPrice(){
		try {
			ValidateProduct.validatePrice(-1);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_PRICE, e.getMessage());
		}
	}
	
	@Test
	public void testRamName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateRam(ram));
		
		try {
			ValidateProduct.validateRam(-2);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_RAM,e.getMessage());
		}
	}
	
	@Test
	public void testStorageName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateStorage(storage));
		
		try {
			ValidateProduct.validateStorage(-10);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_STORAGE,e.getMessage());
		}
	}
	
	@Test
	public void testDescriptionName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateDescription(description));
		
		try {
			ValidateProduct.validateDescription(null);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_DESCRIPTION,e.getMessage());
		}
	}
	
	@Test
	public void testImageURLName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateImageURL(imageURL));
		 
		try {
			
			List<String> imageURLlist = new ArrayList<String>(Arrays.asList(arr));
			imageURLlist.add("https://example.com/image2.jpg");
			
			ValidateProduct.validateImageURL(imageURLlist);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_IMAGEURL,e.getMessage());
		}
	}
	
	@Test
	public void testQuantityName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateQty(quantity));
		
		try {
			ValidateProduct.validateQty(0);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_QUANTITY,e.getMessage());
		}
	}
	
	@Test
	public void testBrandName(){
		//Validate the product name
		Assertions.assertTrue(ValidateProduct.validateBrand(brand));
		
		try {
			ValidateProduct.validateBrand(null);
			Assertions.fail(ProductErrors.EXPECT_FAIL);
		}
		catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_BRAND,e.getMessage());
		}
	}
	
	
	
	
}
