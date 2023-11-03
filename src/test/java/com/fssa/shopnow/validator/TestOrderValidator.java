package com.fssa.shopnow.validator;

import java.time.LocalDate;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import com.fssa.shopnow.errors.OrderErrors;
import com.fssa.shopnow.exception.InvalidOrderException;
import com.fssa.shopnow.model.Order;

public class TestOrderValidator {

	// Fields representing attributes of an order
	int id = 1; // Unique identifier for the order
	LocalDate date = LocalDate.now(); // Date when the order was placed
	int addressId = 1; // ID of the delivery address associated with the order
	String status = "In-transit"; // Current status of the order
	int productId = 1; // ID of the product being ordered
	int quantity = 1; // Quantity of the product in the order
	int shopId = 2; // ID of the shop where the order was placed
	int userId = 3; // ID of the user who placed the order
	String paymentMethod = "UPI";

	Order order = new Order(date, addressId, status, productId, quantity, shopId, userId, paymentMethod);

	@Test
	public void testOrderObj() {

		Assertions.assertTrue(ValidateOrder.isValidObj(order));

		try {
			ValidateOrder.isValidObj(null);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.NULL_OBJ, e.getMessage());
		}
	}

	@Test
	public void testOrderDate() {
		Assertions.assertTrue(ValidateOrder.isValidDate(date));

		try {
			ValidateOrder.isValidDate(null);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_DATE, e.getMessage());
		}
	}
	
	@Test
	public void testAddressId() {
		Assertions.assertTrue(ValidateOrder.isvalidAddressId(addressId));

		try {
			ValidateOrder.isvalidAddressId(-7);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_ADDRESS_ID, e.getMessage());
		}
	}
	
	@Test
	public void testProductId() {
		Assertions.assertTrue(ValidateOrder.isvalidProductId(productId));

		try {
			ValidateOrder.isvalidProductId(-4);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_PRODUCT_ID, e.getMessage());
		}
	}
	
	@Test
	public void testUserId() {
		Assertions.assertTrue(ValidateOrder.isvalidUserId(userId));

		try {
			ValidateOrder.isvalidUserId(-4);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_USER_ID, e.getMessage());
		}
	}
	
	@Test
	public void testShopId() {
		Assertions.assertTrue(ValidateOrder.isvalidShopId(shopId));

		try {
			ValidateOrder.isvalidShopId(-4);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_SHOP_ID, e.getMessage());
		}
	}
	
	@Test
	public void testStatus() {
		Assertions.assertTrue(ValidateOrder.isValidStatus(status));

		try {
			ValidateOrder.isValidStatus(null);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_STATUS, e.getMessage());
		}
	}
	
	@Test
	public void testPaymentMethod() {
		Assertions.assertTrue(ValidateOrder.isValidPaymentMethod(paymentMethod));

		try {
			ValidateOrder.isValidPaymentMethod(null);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_PAYMENT_METHOD, e.getMessage());
		}
	}
	
	@Test
	public void testQuantity() {
		Assertions.assertTrue(ValidateOrder.isValidQty(quantity));

		try {
			ValidateOrder.isValidQty(-4);
			Assertions.fail(OrderErrors.EXPECT_FAIL);
		} catch (InvalidOrderException e) {
			Assertions.assertEquals(OrderErrors.INVALID_QUANTITY, e.getMessage());
		}
	}
}
