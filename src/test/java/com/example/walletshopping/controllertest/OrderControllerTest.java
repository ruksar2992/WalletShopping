
package com.example.walletshopping.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.walletshopping.controller.OrderController;
import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;
import com.example.walletshopping.service.OrderService;

@ExtendWith(MockitoExtension.class)

public class OrderControllerTest {

	@InjectMocks
	OrderController orderController;

	@Mock
	OrderService orderService;

	@Test
	public void orderDetails1() {
		OrderRequestDto orders = new OrderRequestDto();
		orders.setWalletId(1);

		OrderResponseDto order = new OrderResponseDto();

		Mockito.when(orderService.orderProductByUserId(1, orders)).thenReturn(order);

		ResponseEntity<OrderResponseDto> responseOrderdetailsdto = orderController.orderProduts(1, orders);
		assertEquals(HttpStatus.OK, responseOrderdetailsdto.getStatusCode());

	}

	@Test
	public void orderDetails() {
		OrderRequestDto orders = new OrderRequestDto();
		orders.setWalletId(2);

		OrderResponseDto order = new OrderResponseDto();

		Mockito.when(orderService.orderProductByUserId(1, orders)).thenReturn(order);

		ResponseEntity<OrderResponseDto> responseOrderdetailsdto = orderController.orderProduts(1, orders);
		assertEquals(HttpStatus.OK, responseOrderdetailsdto.getStatusCode());

	}

	@Test
	public void orderDetails2() {
		OrderRequestDto orders = new OrderRequestDto();
		orders.setWalletId(2);

		OrderResponseDto order = new OrderResponseDto();

		Mockito.when(orderService.orderProductByUserId(1, orders)).thenReturn(order);

		ResponseEntity<OrderResponseDto> responseOrderdetailsdto = orderController.orderProduts(1, orders);
		assertEquals(HttpStatus.OK, responseOrderdetailsdto.getStatusCode());

	}

}
