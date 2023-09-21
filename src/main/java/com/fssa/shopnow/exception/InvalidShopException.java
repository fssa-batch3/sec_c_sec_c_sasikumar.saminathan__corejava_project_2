package com.fssa.shopnow.exception;

/*
 * This exception for invalid users
 */
public class InvalidShopException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidShopException(String msg) {
		super(msg);
	}

	public InvalidShopException(Throwable te) {
		super(te);
	}

	public InvalidShopException(String msg, Throwable te) {
		super(msg, te);  
	}
}