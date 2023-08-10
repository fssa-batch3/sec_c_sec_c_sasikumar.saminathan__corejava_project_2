package com.fssa.shopnow.dao;

import com.fssa.shopnow.dao.*;
import com.fssa.shopnow.exception.InvalidProductException;
import com.fssa.shopnow.model.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestProductDao {

	// Declaring the values for product
	int id = 10;
	String name = "redmi pro 2";
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
	public void testAddProduct() throws InvalidProductException, DAOException, ClassNotFoundException, SQLException {

		Assertions.assertTrue(ProductDao.addProduct(product));

	}

	@Test
	public void testUpdateProduct() throws DAOException, InvalidProductException, ClassNotFoundException {

		Assertions.assertTrue(ProductDao.updateProduct(product));
	}
	
	@Test
	public void testgetIdByName() throws DAOException, ClassNotFoundException {

		int id = ProductDao.getProductIdByName("redmi 12");

		boolean value = (id > 0) ? true : false;

		Assertions.assertTrue(value);

	}

	@Test
	public void testGetProduct() throws DAOException, ClassNotFoundException {
		// This test case will check if the getAllTasks method returns a non-empty list
		List<Product> allProducts = ProductDao.getAllProducts();

		// Assert that the list is not null and not empty
		Assertions.assertFalse(allProducts.isEmpty());
	}

	 @Test
	public void testAddImageUrls() throws DAOException, InvalidProductException, ClassNotFoundException {
		Assertions.assertTrue(ProductDao.addImageUrls(imageURL, "redmi 12"));
	}  
	@Test
	public void testDeleteProduct() throws DAOException, ClassNotFoundException {

		Assertions.assertTrue(ProductDao.deleteProduct(name));

	}
	
}
