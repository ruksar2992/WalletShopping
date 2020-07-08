package com.example.walletshopping.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.walletshopping.controller.OrderHistory;
import com.example.walletshopping.dao.OrderHistoryDao;
import com.example.walletshopping.dto.OrderHistoryDto;
import com.example.walletshopping.service.OrderHistoryService;


@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{
	//private static Log logger = LogFactory.getLog(OrderHistoryServiceImpl.class);
	@Autowired
    OrderHistoryDao orderHistoryDao;
	
	@Override
	public List<OrderHistoryDto> getOrderHistoryByUserId(int userId) {
		Optional<List<OrderHistory>> orderhistoryOptional = orderHistoryDao.getOrderHistoryByUserId(userId);
		if(orderhistoryOptional.isPresent()) {
			return orderhistoryOptional.get().stream().map(orderHistory->getorderHistorydto(orderHistory)).collect(Collectors.toList());
		}
		List<OrderHistoryDto> orderhistdto=new ArrayList<OrderHistoryDto>();
		return orderhistdto;
	}
	private OrderHistoryDto getorderHistorydto(OrderHistory orderHistory) {
		OrderHistoryDto orderHistoryDto=new OrderHistoryDto();
		BeanUtils.copyProperties(orderHistory, orderHistoryDto);
		return orderHistoryDto;
	}
}

