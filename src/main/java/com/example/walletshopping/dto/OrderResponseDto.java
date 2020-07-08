package com.example.walletshopping.dto;

import java.time.LocalDate;

public class OrderResponseDto {
	private String productName;
	private double totalAmount;
	private LocalDate Orderdate;
	private String message;
	private int statusCode;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	

	public LocalDate getOrderdate() {
		return Orderdate;
	}

	public void setOrderdate(LocalDate orderdate) {
		Orderdate = orderdate;
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
