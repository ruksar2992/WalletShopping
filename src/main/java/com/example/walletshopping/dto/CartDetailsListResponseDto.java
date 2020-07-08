package com.example.walletshopping.dto;

import java.util.List;


public class CartDetailsListResponseDto {
	private String message;
	private int statusCode;
	List<CartListResponseDto> CartListResponseDto;

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
		return CartListResponseDto;
	}
	public void setCartListResponseDto(List<CartListResponseDto> cartListResponseDto) {
		CartListResponseDto = cartListResponseDto;
	}
	
}
