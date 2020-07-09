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

import com.example.walletshopping.dao.CartDao;
import com.example.walletshopping.dao.UserDao;
import com.example.walletshopping.dto.CartRequestDto;
import com.example.walletshopping.model.Cart;
import com.example.walletshopping.model.User;
import com.example.walletshopping.serviceimpl.CartServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

	@Mock
	CartDao cartDao;

	@Mock
	UserDao userDao;

	@InjectMocks
	CartServiceImpl cartServiceImpl;

	@Test
	public void getListByProductNameTest() {
		User user = new User();
		List<CartRequestDto> cartRequestDto = new ArrayList<>();

		when(userDao.findAllByUserId(any(int.class))).thenReturn(Optional.of(user));
		cartServiceImpl.addingProductsToCart(1, cartRequestDto);
		verify(userDao).findAllByUserId(any(int.class));
	}

	@Test
	public void getListByProductNameTest1() {
		List<Cart> cart = new ArrayList<>();

		when(cartDao.findAllByUserId(any(int.class))).thenReturn(Optional.of(cart));
		cartServiceImpl.getProductsFromCart(1);
		verify(cartDao).findAllByUserId(any(int.class));
	}
}
