package com.example.walletshopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.OrderHistoryListDto;
import com.example.walletshopping.service.OrderHistoryService;

@RestController
public class OrderHistoryController {
	@Autowired
	OrderHistoryService orderHistoryService;
	
	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<OrderHistoryListDto> getOrderHistoryByUserId(@PathVariable int userId) 
	{
		OrderHistoryListDto orderHistoryDetailsList=orderHistoryService.getOrderHistory(userId);	
        return new ResponseEntity<>(orderHistoryDetailsList, HttpStatus.OK);
	}
}
