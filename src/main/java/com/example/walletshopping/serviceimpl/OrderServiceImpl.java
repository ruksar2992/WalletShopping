package com.example.walletshopping.serviceimpl;


import java.time.LocalDate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.OrderDao;
import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;
import com.example.walletshopping.model.Orders;
import com.example.walletshopping.service.OrderService;
@Service
public class OrderServiceImpl implements OrderService {
	private static Log logger = LogFactory.getLog(OrderServiceImpl.class);

	@Autowired
	OrderDao orderDao;
	

	/**
	 *passing userId
	 *Return orders
	 */
	@Override
	public OrderResponseDto orderProductByUserId(int userId, OrderRequestDto orderRequestDto) {
		logger.info("dispalying ordering products");

		Orders order = new Orders();
		OrderResponseDto orderResponseDto=new OrderResponseDto();
		order.setOrderDate(LocalDate.now());
		order.setTotalAmount(orderResponseDto.getTotalAmount());
		
		
		orderResponseDto.setMessage("ProductOrderSuccessfully");
		orderResponseDto.setStatusCode(HttpStatus.OK.value());
		return orderResponseDto;
		
		
		
		
		
		
		
		
		
	}
}
		
	
	
	

