package com.fssa.shopnow.errors;

import java.time.LocalDate;

import com.fssa.shopnow.exception.InvalidOrderException;

public final class OrderErrors {

	public static final String NULL_OBJ = "Order cannot be null";
	public static final String INVALID_ADDRESS_ID = "Address id is invalid";
	public static final String INVALID_USER_ID = "User id is invalid";
	public static final String INVALID_SHOP_ID = "Shop id is invalid";
	public static final String INVALID_PRODUCT_ID = "Product id is invalid";
	public static final String INVALID_QUANTITY = "quantity is invalid";
	public static final String INVALID_STATUS = "Status is invalid";
	public static final String INVALID_DATE = "Date is invalid";
	public static final String INVALID_PAYMENT_METHOD = "Payment method is invalid";
	public static final String EXPECT_FAIL = "Expected InvalidOrderException";
}
