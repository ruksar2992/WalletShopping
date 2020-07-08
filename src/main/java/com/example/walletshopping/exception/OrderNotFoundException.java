package com.example.walletshopping.exception;

public class OrderNotFoundException extends RuntimeException {

		private static final long serialVersionUID = 1L;

		private final String message;

		@Override
		public String getMessage() {
			return message;
		}

		public OrderNotFoundException(String message) {
			super(message);
			this.message = message;
		}
}
