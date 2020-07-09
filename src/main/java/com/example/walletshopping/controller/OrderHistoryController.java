package com.example.walletshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.OrderHistoryListDto;
import com.example.walletshopping.service.OrderHistoryService;

@RestController
public class OrderHistoryController {
	private static Log logger = LogFactory.getLog(OrderHistoryController.class);

	@Autowired
	OrderHistoryService orderHistoryService;

	/**
	 * @param userId
	 * @return
	 */
	@GetMapping("/users/{userId}/orders")
	public ResponseEntity<OrderHistoryListDto> getOrderHistoryByUserId(@PathVariable int userId) {
		logger.info("dispalying list of orders");

		OrderHistoryListDto orderHistoryDetailsList = orderHistoryService.getOrderHistory(userId);
		return new ResponseEntity<>(orderHistoryDetailsList, HttpStatus.OK);
	}

	/**
	 * @param month
	 * @param userId
	 * @return
	 */
	@GetMapping("/users/{userId}/ordersmonth")
	public ResponseEntity<OrderHistoryListDto> getOrderHistoryByUserIdAndMonth(@RequestParam("month") int month,
			@PathVariable int userId) {
		logger.info("dispalying list of  based on ordersmonth");

		OrderHistoryListDto orderHistoryDetailsList = orderHistoryService.getOrderHistoryByMonth(userId, month);
		return new ResponseEntity<>(orderHistoryDetailsList, HttpStatus.OK);
	}
}