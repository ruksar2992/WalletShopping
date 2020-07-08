package com.example.walletshopping;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.walletshopping.controller.CartController;
import com.example.walletshopping.controller.OrderController;
import com.example.walletshopping.controller.OrderHistoryController;
import com.example.walletshopping.controller.ProductController;
import com.example.walletshopping.controller.UserController;

@SpringBootTest
class WalletshoppingApplicationTests {

	@Autowired
	CartController cartController;
	@Autowired
	UserController userController;
	@Autowired
	OrderController orderController;
	@Autowired
	OrderHistoryController orderHistoryController;
	@Autowired
	ProductController productController;

	@Test
	public void contexLoads() throws Exception {
		assertThat(cartController).isNotNull();
	}

	@Test
	public void contexLoads1() throws Exception {
		assertThat(userController).isNotNull();
	}

	@Test
	public void contexLoads2() throws Exception {
		assertThat(orderController).isNotNull();
	}

	@Test
	public void contexLoads3() throws Exception {
		assertThat(orderHistoryController).isNotNull();
	}

	@Test
	public void contexLoads4() throws Exception {
		assertThat(productController).isNotNull();
	}
}
