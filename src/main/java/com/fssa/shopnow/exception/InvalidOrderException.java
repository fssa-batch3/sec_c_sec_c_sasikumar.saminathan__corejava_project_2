package com.fssa.shopnow.exception;

/*
 * This exception for invalid users
 */
public class InvalidOrderException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidOrderException(String msg) {
		super(msg);
	}

	public InvalidOrderException(Throwable te) {
		super(te);
	}

	public InvalidOrderException(String msg, Throwable te) {
		super(msg, te);  
	}
}
