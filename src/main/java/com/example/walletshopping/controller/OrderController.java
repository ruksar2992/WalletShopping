package com.example.walletshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;
import com.example.walletshopping.service.OrderService;

@RestController
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<OrderResponseDto> orderProduts(@PathVariable("userId") int userId,
			@RequestBody OrderRequestDto orderRequestDto) {

		OrderResponseDto orderResponseDto = orderService.orderProductByUserId(userId,orderRequestDto);


		        return new ResponseEntity<OrderResponseDto>(orderResponseDto, HttpStatus.OK);


		    }
}

	


