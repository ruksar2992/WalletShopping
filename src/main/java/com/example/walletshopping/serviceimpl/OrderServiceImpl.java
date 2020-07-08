package com.example.walletshopping.serviceimpl;

import java.time.LocalDate;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.CartDao;
import com.example.walletshopping.dao.OrderDao;
import com.example.walletshopping.dao.ProductDao;
import com.example.walletshopping.dao.WalletDao;
import com.example.walletshopping.dto.OrderRequestDto;
import com.example.walletshopping.dto.OrderResponseDto;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.exception.InvalidWalletPoints;
import com.example.walletshopping.model.Cart;
import com.example.walletshopping.model.Orders;
import com.example.walletshopping.model.Product;
import com.example.walletshopping.model.Wallet;
import com.example.walletshopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	private static Log logger = LogFactory.getLog(OrderServiceImpl.class);

	@Autowired
	OrderDao orderDao;
	@Autowired
	CartDao cartDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	WalletDao walletDao;
	@Autowired
	CartServiceImpl cartServiceImpl;

	/**
	 * passing userId Return orders
	 */

	@Override
	public OrderResponseDto orderProductByUserId(int userId, OrderRequestDto orderRequestDto) {
		logger.info("dispalying ordering products");

		Orders order = new Orders();
		OrderResponseDto orderResponseDto = new OrderResponseDto();
		Optional<Cart> cartProductList = cartDao.findAllByCartId(orderRequestDto.getCartId());
		if (!cartProductList.isPresent()) {

			throw new InvalidCredentialsException("Ivalid User Credentials!.Check UserId");
		}
		int productQuantity = cartProductList.get().getQuantity();
		Optional<Product> cartPoductList1 = productDao.findAllByProductId(cartProductList.get().getProductId());
		double totalPrice = (cartPoductList1.get().getProductprice()) * productQuantity;
		Wallet wallet = walletDao.findAllByWalletId(orderRequestDto.getWalletId());
		if (totalPrice < wallet.getWalletPoints()) {
			order.setUserId(userId);
			order.setProductId(cartProductList.get().getProductId());
			order.setWalletId(orderRequestDto.getWalletId());
			order.setOrderDate(LocalDate.now());
			order.setTotalAmount(totalPrice);
			orderDao.save(order);
			cartServiceImpl.updateProductStatus(cartProductList.get().getCartId());

			double amount = wallet.getWalletPoints() - totalPrice;
			wallet.setWalletPoints(amount);
			walletDao.save(wallet);

			orderResponseDto.setMessage("ProductOrderSuccessfully");
			orderResponseDto.setProductName(cartPoductList1.get().getProductName());
			orderResponseDto.setOrderDate(LocalDate.now());
			orderResponseDto.setTotalAmount(totalPrice);
			orderResponseDto.setStatusCode(HttpStatus.OK.value());
			return orderResponseDto;

		} else {
			throw new InvalidWalletPoints("insufficient wallet points");
		}

	}

}
