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

import com.example.walletshopping.controller.OrderHistoryController;
import com.example.walletshopping.dto.OrderHistoryListDto;
import com.example.walletshopping.service.OrderHistoryService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class OrderHistoryControllerTest {

	@InjectMocks
	OrderHistoryController orderHistoryController;

	@Mock
	OrderHistoryService orderHistoryService;

	MockMvc mockMvc;
	ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(orderHistoryController).build();

	}

	@Test
	public void findCartDetails() {

		OrderHistoryListDto cart = new OrderHistoryListDto();
		cart.setMessage("successfully");
		cart.setStatusCode(400);
		cart.setOrderHistoryDto(cart.getOrderHistoryDto());
		Mockito.when(orderHistoryService.getOrderHistory(1)).thenReturn(cart);

		ResponseEntity<OrderHistoryListDto> responseCartdetailsdto = orderHistoryController.getOrderHistoryByUserId(1);
		assertEquals(HttpStatus.OK, responseCartdetailsdto.getStatusCode());

	}

	@Test
	public void findCartDetails1() {

		OrderHistoryListDto cart = new OrderHistoryListDto();
		cart.setMessage("successfully");
		cart.setStatusCode(400);
		cart.setOrderHistoryDto(cart.getOrderHistoryDto());
		Mockito.when(orderHistoryService.getOrderHistoryByMonth(1, 06)).thenReturn(cart);

		ResponseEntity<OrderHistoryListDto> responseCartdetailsdto = orderHistoryController
				.getOrderHistoryByUserIdAndMonth(06, 1);
		assertEquals(HttpStatus.OK, responseCartdetailsdto.getStatusCode());

	}

}
