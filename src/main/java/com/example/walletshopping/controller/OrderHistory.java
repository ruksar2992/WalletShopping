package com.example.walletshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.OrderHistoryDto;
import com.example.walletshopping.service.OrderHistoryService;

@RestController
public class OrderHistory {
	@Autowired
	OrderHistoryService orderHistoryService;
	
	
	@GetMapping("/users/{userId}/orders")
	public List<OrderHistoryDto> getOrderHistoryByUserId(@PathVariable int userId) 
	{
		return orderHistoryService.getOrderHistoryByUserId(userId);	
	}


}
