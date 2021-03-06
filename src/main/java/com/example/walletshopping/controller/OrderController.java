package com.example.walletshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
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

	private static Log logger = LogFactory.getLog(OrderController.class);

	@Autowired
	OrderService orderService;

	/**
	 * @param userId
	 * @param orderRequestDto
	 * @return
	 */
	@PostMapping("/users/{userId}/orders")
	public ResponseEntity<OrderResponseDto> orderProduts(@PathVariable("userId") int userId,
			@RequestBody OrderRequestDto orderRequestDto) {
		logger.info("dispalying ordering products");

		OrderResponseDto orderResponseDto = orderService.orderProductByUserId(userId, orderRequestDto);

		return new ResponseEntity<>(orderResponseDto, HttpStatus.OK);

	}
}
