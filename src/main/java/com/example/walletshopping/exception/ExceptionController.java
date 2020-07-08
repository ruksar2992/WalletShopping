package com.example.walletshopping.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		String allErrors = ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage())
				.collect(Collectors.joining(","));
		errorResponse.setStatusMessage(allErrors);
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}

}
