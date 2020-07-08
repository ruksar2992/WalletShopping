package com.example.walletshopping.orderhistorycontroller;

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
import com.example.walletshopping.dto.OrderHistoryDto;
import com.example.walletshopping.exception.ProductNotFountException;
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
	public void getOrderHistoryByUserId() throws ProductNotFountException {

		OrderHistoryDto orderhist = new OrderHistoryDto();
		orderhist.setOrderId(1);
		orderhist.setProductId(1);
		orderhist.setProductName("bag");
		orderhist.setPrice(1000);
		Mockito.when(orderHistoryService.getOrderHistoryByUserId(userId)).thenReturn(null);

		ResponseEntity<OrderHistoryDto> responsedetailsdto = (ResponseEntity<OrderHistoryDto>) orderHistoryController.getOrderHistoryByUserId(userId);
		assertEquals(HttpStatus.OK, responsedetailsdto.getStatusCode());

	}
}




