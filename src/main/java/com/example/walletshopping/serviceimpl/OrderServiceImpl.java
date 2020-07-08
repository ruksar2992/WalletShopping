package com.example.walletshopping.serviceimpl;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.walletshopping.dao.OrderDao;
import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;
import com.example.walletshopping.model.Orders;
import com.example.walletshopping.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	OrderDao orderDao;
	

	@Override
	public OrderResponseDto orderProductByUserId(int userId, OrderRequestDto orderRequestDto) {
		Orders order = new Orders();
		OrderResponseDto orderResponse=new OrderResponseDto();
		order.setOrderDate(LocalDate.now());
		order.setTotalAmount(orderResponse.getTotalAmount());
		
		
		
		
		return null;
	}
}
		
	
	
	

