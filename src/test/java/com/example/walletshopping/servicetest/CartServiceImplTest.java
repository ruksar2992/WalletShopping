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
import com.example.walletshopping.dto.CartDetailsListResponseDto;
import com.example.walletshopping.dto.CartResponseDto;
import com.example.walletshopping.exception.ProductNotFountException;
import com.example.walletshopping.model.Cart;
import com.example.walletshopping.serviceimpl.CartServiceImpl;

@ExtendWith(MockitoExtension.class)
public class CartServiceImplTest {

	@Mock
	CartDao cartDao;

	@InjectMocks
	CartServiceImpl cartServiceImpl;

	/*
	 * @Test public void getListByProductNameTest() { CartResponseDto
	 * cartResponseDto = new CartResponseDto();
	 * 
	 * cartResponseDto.setMessage("successfully");
	 * cartResponseDto.setStatuscode(400);
	 * 
	 * List<CartResponseDto> petAnimalResponseList = new ArrayList<>();
	 * 
	 * petAnimalResponseList.add(cartResponseDto);
	 * 
	 * Cart cart=new Cart(); cart.setCartId(1); cart.setProductId(1);
	 * cart.setQuantity(2); cart.setUserId(1); // cart.setStatusType(statusType);
	 * 
	 * 
	 * List<Cart> productList = new ArrayList<>(); productList.add(cart);
	 * 
	 * when(cartDao.findAllByUserId(any(int.class))).thenReturn(Optional.of(
	 * productList)); cartServiceImpl.addingProductsToCart(1,);
	 * verify(cartDao).findAllByUserId(any(int.class)); }
	 */
	
	@Test
	public void getListByProductNameTest1()  {
		CartDetailsListResponseDto cartResponseDto = new CartDetailsListResponseDto();

		cartResponseDto.setMessage("successfully");
		cartResponseDto.setStatusCode(200);
		cartResponseDto.setCartListResponseDto(cartResponseDto.getCartListResponseDto());;

		List<CartDetailsListResponseDto> petAnimalResponseList = new ArrayList<>();

		petAnimalResponseList.add(cartResponseDto);

		Cart cart=new Cart();
		cart.setCartId(1);
		cart.setProductId(1);
		cart.setQuantity(2);
		cart.setUserId(1);
		cart.setStatusType(cart.getStatusType());
		
		
		List<Cart> productList = new ArrayList<>();
		productList.add(cart);

		when(cartDao.findAllByUserId(any(int.class))).thenReturn(Optional.of(productList));
		cartServiceImpl.getProductsFromCart(1);
		verify(cartDao).findAllByUserId(any(int.class));
	}
}
