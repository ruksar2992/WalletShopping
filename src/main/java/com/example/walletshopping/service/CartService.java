package com.example.walletshopping.service;

import java.util.List;

import com.example.walletshopping.dto.CartDetailsListResponseDto;
import com.example.walletshopping.dto.CartRequestDto;
import com.example.walletshopping.dto.CartResponseDto;

public interface CartService {

	CartResponseDto addingProductsToCart(int userId, List<CartRequestDto> cartRequestDtoList);

	CartDetailsListResponseDto getProductsFromCart(int userId);

}
