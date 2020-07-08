package com.example.walletshopping.service;

import java.util.List;

import com.example.walletshopping.dto.OrderHistoryDto;

public interface OrderHistoryService {

	public List<OrderHistoryDto> getOrderHistoryByUserId(int userId);

}
