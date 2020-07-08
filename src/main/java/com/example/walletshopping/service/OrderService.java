package com.example.walletshopping.service;


import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;

public interface OrderService {


	OrderResponseDto orderProductByUserId(int userId, OrderRequestDto orderRequestDto);
	

}
