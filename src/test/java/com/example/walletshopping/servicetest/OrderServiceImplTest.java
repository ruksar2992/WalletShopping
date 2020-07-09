package com.example.walletshopping.servicetest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.walletshopping.dao.CartDao;
import com.example.walletshopping.model.Cart;
import com.example.walletshopping.serviceimpl.CartServiceImpl;

@ExtendWith(MockitoExtension.class)
public class OrderServiceImplTest {

	@Mock
	CartDao cartDao;

	@InjectMocks
	CartServiceImpl CartServiceImpl;

	@Test
	public void orderProductByUserId() {
		Cart cart = new Cart();
		when(cartDao.findById(any(int.class))).thenReturn(Optional.of(cart));
		CartServiceImpl.updateProductStatus(1);
		verify(cartDao).findById(any(int.class));
	}

	@Test
	public void orderProductByUserId1() {
		Cart cart = new Cart();
		when(cartDao.findById(any(int.class))).thenReturn(Optional.of(cart));
		CartServiceImpl.updateProductStatus(1);
		verify(cartDao).findById(any(int.class));
	}

}
