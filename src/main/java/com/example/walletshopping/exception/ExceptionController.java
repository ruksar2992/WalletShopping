package com.example.walletshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;


@ControllerAdvice
public class ExceptionController {
	

    /*@ExceptionHandler(value = InvalidCredentialsException.class)
    public ResponseEntity<ErrorResponse> exception(InvalidCredentialsException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setStatusCode(HttpStatus.NOT_FOUND.value());
       
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }*/
}



