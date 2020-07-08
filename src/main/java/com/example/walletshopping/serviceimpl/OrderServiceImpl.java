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
		double totalPrice = 0;
		for (int cartId : orderRequestDto.getCartIdLists()) {

			Optional<Cart> cartProductList = cartDao.findById(cartId);
			if (!cartProductList.isPresent()) {

				throw new InvalidCredentialsException("Ivalid User Credentials!.Check UserId");
			}

			int productQuantity = cartProductList.get().getQuantity();
			Optional<Product> cartPoduct = productDao.findById(cartProductList.get().getProductId());
			Product product = new Product();
			if (cartPoduct.isPresent())
				product = cartPoduct.get();
			double price = (product.getProductprice()) * productQuantity;
			Wallet wallet = walletDao.findAllByWalletId(orderRequestDto.getWalletId());
			if (price < wallet.getWalletPoints()) {
				order.setUserId(userId);
				order.setProductId(cartProductList.get().getProductId());
				order.setWalletId(orderRequestDto.getWalletId());
				order.setOrderDate(LocalDate.now());
				order.setTotalAmount(price);
				orderDao.save(order);

				cartServiceImpl.updateProductStatus(cartProductList.get().getCartId());

				double amount = wallet.getWalletPoints() - price;
				wallet.setWalletPoints(amount);
				walletDao.save(wallet);

			} else {
				throw new InvalidWalletPoints("insufficient wallet points");

			}
			totalPrice = totalPrice + price;
		}

		orderResponseDto.setMessage("ProductOrderSuccessfully");
		orderResponseDto.setOrderdate(LocalDate.now());
		orderResponseDto.setTotalAmount(totalPrice);
		orderResponseDto.setStatusCode(HttpStatus.OK.value());
		return orderResponseDto;

	}

}
