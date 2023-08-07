package com.fssa.shopnow.exception;

/*
 * This is a custom exception class, which represents an exception related to invalid addresses.
 * It is thrown when an invalid address is encountered during the execution of the application.
 */

public class InvalidAddressException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    // Constructor with a message parameter.
    // This constructor is used when you want to throw an InvalidAddressException with a specific error message.
    public InvalidAddressException(String msg) {
        super(msg);
    }

    // Constructor with a Throwable parameter.
    // This constructor is used when you want to wrap another exception (Throwable) inside the InvalidAddressException.
    public InvalidAddressException(Throwable te) {
        super(te);
    }

    // Constructor with both a message and Throwable parameter.
    // This constructor is used when you want to provide a custom error message along with wrapping another exception.
    public InvalidAddressException(String msg, Throwable te) {
        super(msg, te);
    }
}
