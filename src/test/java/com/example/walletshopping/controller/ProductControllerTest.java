package com.example.walletshopping.controller;

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

import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.dto.ProductResponseDto;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.service.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)

public class ProductControllerTest {

	@InjectMocks
	ProductController productController;

	@Mock
	ProductService productService;
	
	MockMvc mockMvc;
    ObjectMapper objectMapper;

	
	 @BeforeEach
	    public void setUp() {
	        objectMapper = new ObjectMapper();
	        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();   
	        
	    }

	@Test
	public void findDogDetails() throws InvalidCredentialsException {

		ProductResponseDto products = new ProductResponseDto();
		products.setProductId(1);
		products.setProductName("mobile");
		products.setProductprice(1000);
		products.setProductDescription("made in india");
		Mockito.when(productService.getProductByProductName("productName")).thenReturn(null);

		ResponseEntity<ProductListResponseDto> responsebusdetailsdto = productController.searchProducts("productName");
		assertEquals(HttpStatus.OK, responsebusdetailsdto.getStatusCode());

	}
}


