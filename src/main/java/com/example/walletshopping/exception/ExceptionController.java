package com.example.walletshopping.exception;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.walletshopping.constants.ApplicationConstants;

/**
 * @author hemas
 *
 */
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = ProductNotFountException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ProductNotFountException productNotFountException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(ApplicationConstants.PRODUCT_NOT_FOUND_CODE);
		errorResponse.setMessage(ApplicationConstants.PRODUCT_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	
}
