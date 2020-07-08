package com.example.walletshopping.dto;

import java.time.LocalDate;

public class OrderHistoryDto {

       private int orderId;
       private int productId ;
       private double totalAmount;
       private LocalDate orderDate ;
       
       
       
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
       
       
       
       
       
}
       
       
       
       
       
	
	