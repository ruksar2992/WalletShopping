package com.example.walletshopping.serviceimpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.OrderDao;
import com.example.walletshopping.dto.OrderHistoryDto;
import com.example.walletshopping.dto.OrderHistoryListDto;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.model.Orders;
import com.example.walletshopping.service.OrderHistoryService;

@Service
public class OrderHistoryServiceImpl implements OrderHistoryService {
	@Autowired
	OrderDao orderDao;

	@Override

	public OrderHistoryListDto getOrderHistory(int userId) {

		OrderHistoryListDto orderHistoryListDto = new OrderHistoryListDto();
		Optional<List<Orders>> cartProductList = orderDao.findAllByUserId(userId);
		if (!cartProductList.isPresent()) {

			throw new InvalidCredentialsException("Invalid User Credentials!.Check UserId");
		}

		List<OrderHistoryDto> OrderList = cartProductList.get().stream()
				.filter(orders -> (orders.getOrderDate().isEqual(LocalDate.now())))
				.map(orders -> getProductListDetails(orders)).collect(Collectors.toList());
		orderHistoryListDto.setMessage("please find list of orders");
		orderHistoryListDto.setStatusCode(HttpStatus.OK.value());
		orderHistoryListDto.setOrderHistoryDto(OrderList);
		return orderHistoryListDto;

	}

	private OrderHistoryDto getProductListDetails(Orders orders) {

		OrderHistoryDto cartListResponseDto = new OrderHistoryDto();
		BeanUtils.copyProperties(orders, cartListResponseDto);
		return cartListResponseDto;
	}

	@Override
	public OrderHistoryListDto getOrderHistoryByMonth(int userId, int month) {
		OrderHistoryListDto orderHistoryListDto = new OrderHistoryListDto();
		Optional<List<Orders>> cartProductList = orderDao.findAllByUserId(userId);
		if (!cartProductList.isPresent()) {

			throw new InvalidCredentialsException("Invalid User Credentials!.Check UserId");
		}

		List<OrderHistoryDto> OrderList = cartProductList.get().stream()
				.filter(orders -> (orders.getOrderDate().getMonthValue() == month))
				.map(orders -> getProductListDetails(orders)).collect(Collectors.toList());
		orderHistoryListDto.setMessage("please find list of orders");
		orderHistoryListDto.setStatusCode(HttpStatus.OK.value());
		orderHistoryListDto.setOrderHistoryDto(OrderList);
		return orderHistoryListDto;

	}

}
