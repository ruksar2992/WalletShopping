package com.example.walletshopping.dto;

import java.util.List;

public class ProductListResponseDto {

	List<ProductResponseDto> productResponse;
	private String message;
	private int statusCode;

	public List<ProductResponseDto> getProductResponse() {
		return productResponse;
	}

	public void setProductResponse(List<ProductResponseDto> productResponse) {
		this.productResponse = productResponse;
	}

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

}
