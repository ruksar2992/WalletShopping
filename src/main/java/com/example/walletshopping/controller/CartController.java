package com.example.walletshopping.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.CartDetailsListResponseDto;
import com.example.walletshopping.dto.CartRequestDto;
import com.example.walletshopping.dto.CartResponseDto;
import com.example.walletshopping.service.CartService;


@RestController
public class CartController {
	private static Log logger = LogFactory.getLog(CartController.class);

	@Autowired
	CartService cartService;

	/**
	 * @param userId
	 * @param cartRequestDtoList
	 * @return
	 */
	@PostMapping("/users/{userId}/cart")
	public ResponseEntity<CartResponseDto> addingProductsToCart(@PathVariable("userId") int userId,
			@RequestBody List<CartRequestDto> cartRequestDtoList) {
		logger.info("Adding list of products to cart");

		CartResponseDto cartResponse = cartService.addingProductsToCart(userId, cartRequestDtoList);

		return new ResponseEntity<>(cartResponse, HttpStatus.OK);

	}

	/**
	 * @param userId
	 * @return
	 */
	@PostMapping("/users/{userId}/carts")
	public ResponseEntity<CartDetailsListResponseDto> getProductsOfCart(@PathVariable("userId") int userId) {

		logger.info("Displaying the list of products in cart");

		CartDetailsListResponseDto cartDetailsList = cartService.getProductsFromCart(userId);

		return new ResponseEntity<>(cartDetailsList, HttpStatus.OK);

	}

}
