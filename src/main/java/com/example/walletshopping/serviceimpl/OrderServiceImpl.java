package com.example.walletshopping.serviceimpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.walletshopping.dao.OrderDao;
import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;
import com.example.walletshopping.model.Order;
import com.example.walletshopping.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	

	@Override
	public OrderResponseDto orderProductByUserId(int userId, OrderRequestDto orderRequestDto) {
		Order order = new Order();
		return null;
	}
}
		
	
	
	

