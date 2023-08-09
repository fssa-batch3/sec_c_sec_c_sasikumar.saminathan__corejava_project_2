package com.fssa.shopnow.errors;
/*
 * This interface variables contains error messages for use in Exceptions
 */

public final class ProductErrors {

public static final String INVALID_OBJECT = "Product object cannot be null";
public static final String INVALID_NAME = "Product Name cannot be null or lesser than 3 characters";
public static final String INVALID_ID = "Product ID cannot be less than 1";
public static final String INVALID_PRICE = "Product price cannot be less than 100 or greater than 5,00,000";
public static final String INVALID_RAM = "Product ram is invalid";
public static final String INVALID_STORAGE = "Product storage is invalid";
public static final String INVALID_DESCRIPTION = "Product description cannot be null or less than 3 characters";
public static final String INVALID_IMAGEURL = "Product imageURL format is invalid";
public static final String INVALID_BRAND = "Product brand cannot be null or less than 3 characters";
public static final String INVALID_QUANTITY = "Product quantity cannot be less than 1";

//Product DAO Errors
public static final String CONNECTION_ISSUE = "Unable to connect to the database";
public static final String DAO_INVALID_OBJECT = "Product is invalid for DAO layer";
public static final String CLOSE_ERROR = "Error in closing connection";
public static final String CREATE_ERROR = "Error in creating product";
public static final String UPDATE_ERROR = "Error in updating product";
public static final String DAO_INVALID_ID = "Product ID is invalid for DAO layer";
public static final String DELETE_ERROR = "Error deleting product";
public static final String GET_ERROR = "Error fetching products";

//Valdator failure message
public static final String EXPECT_FAIL = "Expected InvalidProductException";

}
