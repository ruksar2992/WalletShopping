package com.example.walletshopping.service;

import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.exception.ProductNotFountException;

public interface ProductService {

	ProductListResponseDto getProductByProductName(String productName) throws ProductNotFountException;

}
