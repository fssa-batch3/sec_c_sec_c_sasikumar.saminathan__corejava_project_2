package com.fssa.shopnow.exception;

/*
 * This exception for invalid users
 */
public class InvalidUserException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable te) {
		super(te);
	}

	public InvalidUserException(String msg, Throwable te) {
		super(msg, te);  
	}
}