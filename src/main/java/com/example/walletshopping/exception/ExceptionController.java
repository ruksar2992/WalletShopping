package com.example.walletshopping.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.walletshopping.constants.ApplicationConstants;
import com.google.common.net.HttpHeaders;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ProductNotFountException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ProductNotFountException productNotFountException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(ApplicationConstants.PRODUCT_NOT_FOUND_CODE);
		errorResponse.setMessage(ApplicationConstants.PRODUCT_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(OrderNotFoundException orderNotFountException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(ApplicationConstants.ORDERS_NOT_FOUND_CODE);
		errorResponse.setMessage(ApplicationConstants.ORDERS_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(InvalidCredentialsException invalidCredentialsException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		errorResponse.setMessage(invalidCredentialsException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

}
