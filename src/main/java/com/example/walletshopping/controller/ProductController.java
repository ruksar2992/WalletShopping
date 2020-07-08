package com.example.walletshopping.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService productService;
	private static Log logger = LogFactory.getLog(ProductController.class);

	@GetMapping("/product")
	public ResponseEntity<ProductListResponseDto> searchProducts(@RequestParam("productName") String productName)
			throws InvalidCredentialsException {
		logger.info("dispalying list of products");

		ProductListResponseDto productDetailsResponse = productService.getProductByProductName(productName);
		return new ResponseEntity<>(productDetailsResponse, HttpStatus.OK);
	}

}
