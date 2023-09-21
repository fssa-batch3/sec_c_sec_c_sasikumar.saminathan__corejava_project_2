package com.fssa.shopnow.model;

import java.time.LocalDate;

public class Order {
	
	// Fields representing attributes of an order
	private int id;                  // Unique identifier for the order
	private LocalDate date;          // Date when the order was placed
	private int addressId;          // ID of the delivery address associated with the order
	private String status;      // Current status of the order
	private int productId;           // ID of the product being ordered
	private int quantity;            // Quantity of the product in the order
	private int shopId;              // ID of the shop where the order was placed
	private int userId;              // ID of the user who placed the order
	private String paymentMethod;
	
	
	//Constructors for initialize values
	public Order(LocalDate date, int addressId, String status, int productId, int quantity, int shopId, int userId,
			String paymentMethod) {
		this.date = date;
		this.addressId = addressId;
		this.status = status;
		this.productId = productId;
		this.quantity = quantity;
		this.shopId = shopId;
		this.userId = userId;
		this.paymentMethod = paymentMethod;
	}

	// Getter method for retrieving the order's ID
	public int getId() {
		return id;
	}

	// Setter method for setting the order's ID
	public void setId(int id) {
		this.id = id;
	}
	
	// Getter method for retrieving the date of the order
	public LocalDate getDate() {
		return date;
	}
	
	// Setter method for setting the date of the order
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	// Getter method for retrieving the address ID associated with the order
	public int getAddressId() {
		return addressId;
	}
	
	// Setter method for setting the address ID associated with the order
	public void setAddresId(int addressId) {
		this.addressId = addressId;
	}
	
	// Getter method for retrieving the order status
	public String getStatus() {
		return status;
	}
	
	// Setter method for setting the order status
	public void setOrderStatus(String orderStatus) {
		this.status = orderStatus;
	}
	
	// Getter method for retrieving the product ID in the order
	public int getProductId() {
		return productId;
	}
	
	// Setter method for setting the product ID in the order
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	// Getter method for retrieving the quantity of the product in the order
	public int getQuantity() {
		return quantity;
	}
	
	// Setter method for setting the quantity of the product in the order
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	// Getter method for retrieving the shop ID where the order was placed
	public int getShopId() {
		return shopId;
	}
	
	// Setter method for setting the shop ID where the order was placed
	public void setShopId(int shopId) {
		this.shopId = shopId;
	}
	
	// Getter method for retrieving the user ID who placed the order
	public int getUserId() {
		return userId;
	}
	
	// Setter method for setting the user ID who placed the order
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	
}
