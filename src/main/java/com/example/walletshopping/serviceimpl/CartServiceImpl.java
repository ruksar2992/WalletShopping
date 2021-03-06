package com.example.walletshopping.serviceimpl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.CartDao;
import com.example.walletshopping.dao.UserDao;
import com.example.walletshopping.dto.CartDetailsListResponseDto;
import com.example.walletshopping.dto.CartListResponseDto;
import com.example.walletshopping.dto.CartRequestDto;
import com.example.walletshopping.dto.CartResponseDto;
import com.example.walletshopping.enumpack.StatusType;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.model.Cart;
import com.example.walletshopping.model.User;
import com.example.walletshopping.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	private static Log logger = LogFactory.getLog(CartServiceImpl.class);

	@Autowired
	UserDao userDao;
	@Autowired
	CartDao cartDao;

	@Override
	public CartResponseDto addingProductsToCart(int userId, List<CartRequestDto> cartRequestDtoList) {
		logger.info("Adding list of products to cart");

		CartResponseDto cartResponseDto = new CartResponseDto();
		Optional<User> user = userDao.findAllByUserId(userId);
		if (!user.isPresent()) {
			throw new InvalidCredentialsException("UserId is not valid,Enter correct one");
		}

		List<Cart> cartList = cartRequestDtoList.stream().map(cartRequestDto -> addToCart(cartRequestDto, userId))
				.collect(Collectors.toList());
		if (cartList != null) {
			cartResponseDto.setMessage("Product successfully added in to cart");
			cartResponseDto.setStatuscode(HttpStatus.OK.value());
			return cartResponseDto;

		}
		cartResponseDto.setMessage("Product not added in to cart");
		cartResponseDto.setStatuscode(HttpStatus.BAD_REQUEST.value());
		return cartResponseDto;
	}

	private Cart addToCart(CartRequestDto cartRequestDto, int userId) {

		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setProductId(cartRequestDto.getProductId());
		cart.setQuantity(cartRequestDto.getQuantity());
		cart.setStatusType(StatusType.INCART);
		cartDao.save(cart);
		return cart;

	}

	@Override
	public CartDetailsListResponseDto getProductsFromCart(int userId) {
		logger.info("displaying list of ordres in cart");

		CartDetailsListResponseDto cartDetailsListResponseDto = new CartDetailsListResponseDto();
		Optional<List<Cart>> cartProductList = cartDao.findAllByUserId(userId);
		if (!cartProductList.isPresent()) {

			throw new InvalidCredentialsException("Ivalid User Credentials!.Check UserId");
		}

		List<CartListResponseDto> productList = cartProductList.get().stream()
				.filter(cart -> (cart.getStatusType().equals(StatusType.INCART))).map(cart -> getProductDetails(cart))
				.collect(Collectors.toList());
		cartDetailsListResponseDto.setMessage("please find list of products to be order");
		cartDetailsListResponseDto.setStatusCode(HttpStatus.OK.value());
		cartDetailsListResponseDto.setCartListResponseDto(productList);
		return cartDetailsListResponseDto;

	}

	private CartListResponseDto getProductDetails(Cart cart) {

		CartListResponseDto cartListResponseDto = new CartListResponseDto();
		BeanUtils.copyProperties(cart, cartListResponseDto);
		return cartListResponseDto;
	}

	public void updateProductStatus(int cartId) {
		Optional<Cart> cart = cartDao.findById(cartId);
		if (cart.isPresent()) {
			cart.get().setStatusType(StatusType.ORDERED);
			cartDao.save(cart.get());

		}

	}

}
