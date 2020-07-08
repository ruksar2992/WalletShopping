package com.example.walletshopping.serviceimpl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.OrderHistoryDao;
import com.example.walletshopping.dto.OrderHistoryListDto;
import com.example.walletshopping.service.OrderHistoryService;


@Service
public class OrderHistoryServiceImpl implements OrderHistoryService{
	@Autowired
    OrderHistoryDao orderHistoryDao;

	@Override
	public OrderHistoryListDto getOrderHistory(int userId) {
		
		OrderHistoryListDto orderHistoryListDto = new OrderHistoryListDto();
	        Optional<List<Orders>> cartProductList = cartDao.findAllByUserId(userId);
	if (!cartProductList.isPresent()) {
	           
	            throw new InvalidCredentialsException("Ivalid User Credentials!.Check UserId");
	        }
	     
	         List<CartListResponseDto> productList= cartProductList.get().stream().filter(cart-> (cart.getStatusType().equals(StatusType.INCART))).map(cart -> getProductDetails(cart)).collect(Collectors.toList());
	         CartDetailsListResponseDto.setMessage("please find list of products to be order");
	         CartDetailsListResponseDto.setStatusCode(HttpStatus.OK.value());
	         CartDetailsListResponseDto.setCartListResponseDto(productList);
	            return CartDetailsListResponseDto;
	           
	      
	        
	    }
	    private CartListResponseDto getProductDetails(Cart cart) {
	       
	        CartListResponseDto cartListResponseDto=new CartListResponseDto();
	        BeanUtils.copyProperties(cart, cartListResponseDto);
	        return cartListResponseDto;
	    }
	 
	
}

