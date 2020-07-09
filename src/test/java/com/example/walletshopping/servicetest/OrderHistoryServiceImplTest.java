package com.example.walletshopping.servicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.walletshopping.dao.OrderDao;
import com.example.walletshopping.model.Orders;
import com.example.walletshopping.serviceimpl.OrderHistoryServiceImpl;

@ExtendWith(MockitoExtension.class)

public class OrderHistoryServiceImplTest {

	@Mock
	OrderDao orderDao;

	@InjectMocks
	OrderHistoryServiceImpl orderHistoryServiceImpl;

	@Test
	public void orderProductByUserId() {
		List<Orders> orders = new ArrayList<>();
		when(orderDao.findAllByUserId(any(int.class))).thenReturn(Optional.of(orders));
		orderHistoryServiceImpl.getOrderHistory(1);
		verify(orderDao).findAllByUserId(any(int.class));

	}

}
