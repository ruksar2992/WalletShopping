package com.example.walletshopping.dto;

import java.util.List;


public class CartDetailsListResponseDto {
	private String message;
	private int statusCode;
	List<CartListResponseDto> cartListResponseDto;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<CartListResponseDto> getCartListResponseDto() {
		return cartListResponseDto;
	}
	public void setCartListResponseDto(List<CartListResponseDto> cartListResponseDto) {
		this.cartListResponseDto = cartListResponseDto;
	}
	
	
}
