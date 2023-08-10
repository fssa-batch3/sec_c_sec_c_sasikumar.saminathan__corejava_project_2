package com.fssa.shopnow.service;
import com.fssa.shopnow.service.*;
import com.fssa.shopnow.validator.ValidateProduct;
import com.fssa.shopnow.dao.DAOException;
import com.fssa.shopnow.dao.ProductDao;
import com.fssa.shopnow.errors.ProductErrors;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.model.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestService {
	
	
	ProductDao productDao;
    ValidateProduct validate;
	
	ProductService service = new ProductService(productDao,validate);
	
	String[] arr = { "https://example.com/image1.jpg", "https://example.com/image1.jpg",
			"https://example.com/image1.jpg", "https://example.com/image1.jpg" };
	
	String name = "Apple 14";
	List<String> imageURL = new ArrayList<String>(Arrays.asList(arr));
	
	Product mobile = new Product(99,name,499.99,8,128,"A powerful mobile phone.",imageURL,10,"apple");
  
	@Test
	public void testAddproduct() throws InvalidProductException, DAOException, ClassNotFoundException, SQLException {
		Product mob = new Product();
		Assertions.assertTrue(service.addProduct(mobile));
		
		try {
			service.addProduct(mob); 
			Assertions.fail("Expected InvalidProductException");
		} catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_NAME,e.getMessage());
		}
	} 
	 
	@Test 
	public void testUpdateproduct() throws InvalidProductException, DAOException, ClassNotFoundException {
		Product mob = new Product();
		Assertions.assertTrue(service.updateProduct(mobile));
		
		try {
			service.updateProduct(mob);
			Assertions.fail("Expected InvalidProductException");
		} catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_NAME,e.getMessage());
		}
	} 
	
	@Test
	public void testAddImageUrls() throws InvalidProductException,DAOException, ClassNotFoundException {
		
		Assertions.assertTrue(service.addImageUrls(imageURL, "redmi 12"));
		
		try {
			service.addImageUrls(imageURL,null); 
			Assertions.fail("Expected InvalidProductException");
		} catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_NAME, e.getMessage());
		}
	}
	
	@Test
	public void testDeleteproduct() throws InvalidProductException, DAOException, ClassNotFoundException {
		
		Assertions.assertTrue(service.deleteProduct(name));
		try {
			service.deleteProduct(null);
			Assertions.fail("Expected InvalidProductException");
		} catch (InvalidProductException e) {
			Assertions.assertEquals(ProductErrors.INVALID_NAME,e.getMessage());
		}
	}  
}
