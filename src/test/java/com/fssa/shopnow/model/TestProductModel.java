package com.fssa.shopnow.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import com.fssa.shopnow.model.*;
/*
 * Write the testcases for Product object In this this all methods are tested.
 */

public class TestProductModel {

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
	
	Product product2 = new Product();
 
	@Test
	public void testProductCreation() {

		// Test the all getmethods
		Assertions.assertEquals(id, product.getId());
		Assertions.assertEquals(name, product.getName());
		Assertions.assertEquals(price, product.getPrice());
		Assertions.assertEquals(ram, product.getRam()); 
		Assertions.assertEquals(storage, product.getStorage());
		Assertions.assertEquals(description, product.getDescription());
		Assertions.assertEquals(imageURL, product.getImageURL());
		Assertions.assertEquals(quantity, product.getQuantity());
		Assertions.assertEquals(brand, product.getBrand());
	}
	
	@Test
	public void testIdSet(){
		// Test if the quantity can be set correctly 
        int newID = 5;
        product.setId(newID);
        Assertions.assertEquals(newID, product.getId());
	}
	
	@Test
	public void testNameSet(){
		// Test if the name can be set correctly
        String newName = "redmi 4a";
        product.setName(newName);
        Assertions.assertEquals(newName, product.getName());
	}
	
	@Test
	public void testPriceSet(){
		// Test if the price can be set correctly
        double newPrice = 1000.0;
        product.setPrice(newPrice);
        Assertions.assertEquals(newPrice, product.getPrice());
	}
	
	@Test
	public void testRamSet(){
		// Test if the ram can be set correctly
        int newRam = 6;
        product.setRam(newRam);
        Assertions.assertEquals(newRam, product.getRam());
	}
	
	@Test
	public void testStorageSet(){
		// Test if the storage can be set correctly
        int newStorage = 128;
        product.setStorage(newStorage);
        Assertions.assertEquals(newStorage, product.getStorage());
	}
	
	@Test
	public void testDescriptionSet(){
		// Test if the description can be set correctly
        String newDescription = "Turbo speed mobile";
        product.setDescription(newDescription);
        Assertions.assertEquals(newDescription, product.getDescription());
	}
	
	@Test
	public void testImageURLSet(){
		// Test if the imageURL can be set correctly
		String[] arr = { "https://example.com/image2.jpg", "https://example.com/image2.jpg",
				"https://example.com/image2.jpg", "https://example.com/image2.jpg" };
		List<String> newImageURL = new ArrayList<String>(Arrays.asList(arr));
        product.setImageURL(newImageURL);
        Assertions.assertEquals(newImageURL, product.getImageURL());
	}
	
	@Test
	public void testQuantitySet(){
		// Test if the quantity can be set correctly
        int newQuantity = 4;
        product.setQuantity(newQuantity);
        Assertions.assertEquals(newQuantity, product.getQuantity());
	}
	
	@Test
	public void testBrandSet(){
		// Test if the brand can be set correctly
        String newBrand = "Apple iphone";
        product.setBrand(newBrand);
        Assertions.assertEquals(newBrand, product.getBrand());
	}
	

}
