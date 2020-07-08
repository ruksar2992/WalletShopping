/*
 * package com.example.walletshopping.controllertest;
 * 
 * import static org.junit.jupiter.api.Assertions.assertEquals;
 * 
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.Mockito; import
 * org.mockito.junit.jupiter.MockitoExtension; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity;
 * 
 * import com.example.walletshopping.controller.OrderController; import
 * com.example.walletshopping.dto.OrderRequestDto; import
 * com.example.walletshopping.dto.OrderResponseDto; import
 * com.example.walletshopping.service.OrderService;
 * 
 * 
 * 
 * 
 * @ExtendWith(MockitoExtension.class)
 * 
 * public class OrderControllerTest {
 * 
 * 
 * 
 * @InjectMocks OrderController orderController;
 * 
 * @Mock OrderService orderService;
 * 
 * @Test public void bookingDetails() { OrderRequestDto booking = new
 * OrderRequestDto(); booking.setCartId(1); booking.setWalletId(1);
 * 
 * OrderResponseDto book = new OrderResponseDto();
 * 
 * Mockito.when(orderService.orderProductByUserId(1, booking)).thenReturn(book);
 * 
 * ResponseEntity<OrderResponseDto> responsebusdetailsdto =
 * orderController.orderProduts(1, booking); assertEquals(HttpStatus.OK,
 * responsebusdetailsdto.getStatusCode());
 * 
 * }
 * 
 * @Test public void bookingDetails1() { OrderRequestDto booking = new
 * OrderRequestDto(); booking.setCartId(2); booking.setWalletId(2);
 * 
 * OrderResponseDto book = new OrderResponseDto();
 * 
 * Mockito.when(orderService.orderProductByUserId(1, booking)).thenReturn(book);
 * 
 * ResponseEntity<OrderResponseDto> responsebusdetailsdto =
 * orderController.orderProduts(1, booking); assertEquals(HttpStatus.OK,
 * responsebusdetailsdto.getStatusCode());
 * 
 * }
 * 
 * @Test public void bookingDetails2() { OrderRequestDto booking = new
 * OrderRequestDto(); booking.setCartId(2); booking.setWalletId(2);
 * 
 * OrderResponseDto book = new OrderResponseDto();
 * 
 * Mockito.when(orderService.orderProductByUserId(1, booking)).thenReturn(book);
 * 
 * ResponseEntity<OrderResponseDto> responsebusdetailsdto =
 * orderController.orderProduts(1, booking); assertEquals(HttpStatus.OK,
 * responsebusdetailsdto.getStatusCode());
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */