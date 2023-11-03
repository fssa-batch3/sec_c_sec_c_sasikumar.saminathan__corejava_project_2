package com.fssa.shopnow.model;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TestOrder {

	// Fields representing attributes of an order
	private int id = 1;                  // Unique identifier for the order
	private LocalDate date = LocalDate.now();          // Date when the order was placed
	private int addressId = 1;          // ID of the delivery address associated with the order
	private String status = "In-transit";      // Current status of the order
	private int productId = 1;           // ID of the product being ordered
	private int quantity = 1;            // Quantity of the product in the order
	private int shopId = 2;              // ID of the shop where the order was placed
	private int userId = 3;              // ID of the user who placed the order
	private String paymentMethod = "UPI";
	
	Order order = new Order(date, addressId, status, productId, quantity, shopId, userId, paymentMethod);
	
	@Test
	public void testOrderGetters() {
		order.setId(1);
		Assertions.assertEquals(id,order.getId());
		Assertions.assertEquals(date,order.getDate());
		Assertions.assertEquals(addressId,order.getAddressId());
		Assertions.assertEquals(status,order.getStatus());
		Assertions.assertEquals(productId,order.getProductId());
		Assertions.assertEquals(quantity,order.getQuantity());
		Assertions.assertEquals(shopId,order.getShopId());
		Assertions.assertEquals(userId,order.getUserId());
		Assertions.assertEquals(paymentMethod,order.getPaymentMethod());
	}
	
	@Test
	public void testIdSet(){
        int newID = 5;
        order.setId(newID);
        Assertions.assertEquals(newID, order.getId());
	}
	
	@Test
	public void testDateSet(){
        LocalDate newDate = LocalDate.now();
        order.setDate(newDate);
        Assertions.assertEquals(newDate, order.getDate());
	}
	
	@Test
	public void testAddressIdSet(){
        int newAddressID = 5;
        order.setAddresId(newAddressID);
        Assertions.assertEquals(newAddressID, order.getAddressId());
	}
	
	@Test
	public void testStatusSet(){
        String newStatus = "Delivered";
        order.setOrderStatus(newStatus);
        Assertions.assertEquals(newStatus, order.getStatus());
	}
	
	@Test
	public void testProductIdSet(){
        int newProductID = 5;
        order.setProductId(newProductID);
        Assertions.assertEquals(newProductID, order.getProductId());
	}
	
	@Test
	public void testQuantitySet(){
        int newQuantity = 5;
        order.setQuantity(newQuantity);
        Assertions.assertEquals(newQuantity, order.getQuantity());
	}
	
	@Test
	public void testShopIdSet(){
        int newShopID = 5;
        order.setShopId(newShopID);
        Assertions.assertEquals(newShopID, order.getShopId());
	}
	
	@Test
	public void testUserIdSet(){
        int newUserID = 5;
        order.setUserId(newUserID);
        Assertions.assertEquals(newUserID, order.getUserId());
	}
	
	@Test
	public void testPaymentMethodSet(){
        String newPaymentMethod = "Cash on delivery";
        order.setPaymentMethod(newPaymentMethod);
        Assertions.assertEquals(newPaymentMethod, order.getPaymentMethod());
	}
	
	
}
