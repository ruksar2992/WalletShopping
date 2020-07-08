package com.example.walletshopping.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.walletshopping.controller.CartController;
import com.example.walletshopping.dto.CartDetailsListResponseDto;
import com.example.walletshopping.dto.CartResponseDto;
import com.example.walletshopping.exception.ProductNotFountException;
import com.example.walletshopping.service.CartService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CartControllerTest {

	@InjectMocks
	CartController cartController;

	@Mock
	CartService cartService;

	MockMvc mockMvc;
	ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(cartController).build();

	}

	/*
	 * @Test public void findCartDetails() throws ProductNotFountException {
	 * 
	 * CartResponseDto cart = new CartResponseDto();
	 * cart.setMessage("successfully"); cart.setStatuscode(601);
	 * 
	 * Mockito.when(cartService.getProductsFromCart(1)).thenReturn(null);
	 * 
	 * ResponseEntity<CartResponseDto> responsebusdetailsdto =
	 * cartController.addingProductsToCart(1, null); assertEquals(HttpStatus.OK,
	 * responsebusdetailsdto.getStatusCode());
	 * 
	 * }
	 */

	@Test
	public void findCartDetails1() throws ProductNotFountException {

		CartDetailsListResponseDto cart = new CartDetailsListResponseDto();
		cart.setMessage("successfully");
		cart.setStatusCode(400);
		cart.setCartListResponseDto(cart.getCartListResponseDto());

		Mockito.when(cartService.getProductsFromCart(1)).thenReturn(null);

		ResponseEntity<CartDetailsListResponseDto> responsebusdetailsdto = cartController.getProductsOfCart(1);
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}

}
