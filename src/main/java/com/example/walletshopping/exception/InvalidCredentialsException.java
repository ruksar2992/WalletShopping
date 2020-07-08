package com.example.walletshopping.exception;

/**
 * @author hemas
 *
 */
public class InvalidCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	private final String message;

	@Override
	public String getMessage() {
		return message;
	}

	public InvalidCredentialsException(String message) {
		super(message);
		this.message = message;
	}

}
