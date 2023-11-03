package com.fssa.shopnow.service;
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
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.Assertions;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestService { 

    ProductDao productDao;
    ValidateProduct validate;

    ProductService service = new ProductService(productDao, validate);

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
	 int sellerId = 9399;
	 int shopId = 9474;

	// Insert the declared values for product via constructor
	Product mobile = new Product(name, price, ram, storage, description, imageURL, quantity, brand,sellerId,shopId);

    @Test
    @Order(1)
    public void testAddproduct() throws InvalidProductException, DAOException, ClassNotFoundException, SQLException {
        Product mob = new Product();
        Assertions.assertTrue(service.addProduct(mobile));

        try {
            service.addProduct(mob);
            Assertions.fail("Expected InvalidProductException");
        } catch (InvalidProductException e) {
            Assertions.assertEquals(ProductErrors.INVALID_NAME, e.getMessage());
        }
    }

    @Test
    @Order(2)
    public void testUpdateproduct() throws InvalidProductException, DAOException, ClassNotFoundException {
        Product mob = new Product();
        int id = ProductDao.getProductIdByName(mobile.getName());
        mobile.setId(id);
        Assertions.assertTrue(service.updateProduct(mobile));

        try {
            service.updateProduct(mob);
            Assertions.fail("Expected InvalidProductException");
        } catch (InvalidProductException e) {
            Assertions.assertEquals(ProductErrors.INVALID_NAME, e.getMessage());
        }
    }

    @Test
    @Order(3)
    public void testAddImageUrls() throws InvalidProductException, DAOException, ClassNotFoundException {

        Assertions.assertTrue(service.addImageUrls(imageURL, name));

        try {
            service.addImageUrls(imageURL, null);
            Assertions.fail("Expected InvalidProductException");
        } catch (InvalidProductException e) {
            Assertions.assertEquals(ProductErrors.INVALID_NAME, e.getMessage());
        }
    }

    @Test
    @Order(4)
    public void testDeleteproduct() throws InvalidProductException, DAOException, ClassNotFoundException {

        Assertions.assertTrue(service.deleteProduct(name));
        try {
            service.deleteProduct(null);
            Assertions.fail("Expected InvalidProductException");
        } catch (InvalidProductException e) {
            Assertions.assertEquals(ProductErrors.INVALID_NAME, e.getMessage());
        }
    }
}
