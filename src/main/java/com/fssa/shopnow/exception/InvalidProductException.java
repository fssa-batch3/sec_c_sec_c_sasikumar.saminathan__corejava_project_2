package com.fssa.shopnow.exception;

public class InvalidProductException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidProductException(String msg) {
		super(msg);
	}

	public InvalidProductException(Throwable te) {
		super(te);
	}

	public InvalidProductException(String msg, Throwable te) {
		super(msg, te);  
	}
}
