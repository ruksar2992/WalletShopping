package com.example.walletshopping.dto;

import java.util.List;



public class OrderHistoryListDto {
    private String message;
    private int statusCode;
    List<OrderHistoryDto> orderHistoryDto;
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
    public List<OrderHistoryDto> getOrderHistoryDto() {
        return orderHistoryDto;
    }
    public void setOrderHistoryDto(List<OrderHistoryDto> orderHistoryDto) {
        this.orderHistoryDto = orderHistoryDto;
    }
    
    
    
    
}
