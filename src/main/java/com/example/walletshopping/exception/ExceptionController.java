package com.example.walletshopping.exception;


<<<<<<< HEAD
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.stream.Collectors;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.example.walletshopping.constants.ApplicationConstants;
import com.example.walletshopping.dto.ErrorResponse;

@RestControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {
	@ExceptionHandler(value = InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(InvalidCredentialsException invalidCredentialsException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		errorResponse.setStatusMessage(invalidCredentialsException.getMessage());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
=======

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
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
	@ExceptionHandler(value = OrderNotFoundException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(OrderNotFoundException orderNotFountException) {
>>>>>>> 194a85842ffd0a27ff33d313e6811572b6e1a246
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(ApplicationConstants.Orders_NOT_FOUND_CODE);
		errorResponse.setMessage(ApplicationConstants.ORDERS_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(InvalidCredentialsException invalidCredentialsException) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatusCode(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setMessage(invalidCredentialsException.getMessage());

 

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

<<<<<<< HEAD
	@ExceptionHandler(value = ProductNotFountException.class)
	public ResponseEntity<ErrorResponse> exceptionHandler(ProductNotFountException productNotFountException) {
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(ApplicationConstants.PRODUCT_NOT_FOUND_CODE);
		errorResponse.setStatusMessage(ApplicationConstants.PRODUCT_NOT_FOUND);
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);

	}
=======
 

    }

 

	/*
	 * @Override protected ResponseEntity<Object>
	 * handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	 * headers, HttpStatus status, WebRequest request) { ErrorResponse errorResponse
	 * = new ErrorResponse();
	 * errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value()); String allErrors
	 * = ex.getBindingResult().getFieldErrors().stream().map(e ->
	 * e.getDefaultMessage()) .collect(Collectors.joining(","));
	 * errorResponse.setMessage(allErrors); return new
	 * ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); }
	 */
>>>>>>> 194a85842ffd0a27ff33d313e6811572b6e1a246
}


