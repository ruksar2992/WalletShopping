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

import com.example.walletshopping.dao.ProductDao;
import com.example.walletshopping.dto.ProductResponseDto;
import com.example.walletshopping.exception.ProductNotFountException;
import com.example.walletshopping.model.Product;
import com.example.walletshopping.serviceimpl.ProductServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ProductServiceImplTest {

	@Mock
	ProductDao productDao;

	@InjectMocks
	ProductServiceImpl productServiceImpl;

	@Test
	public void getListByProductNameTest() throws ProductNotFountException {
		ProductResponseDto productAnimalResponse = new ProductResponseDto();

		productAnimalResponse.setProductDescription("6 gb");
		productAnimalResponse.setProductId(1);
		productAnimalResponse.setProductName("mobiles");
		productAnimalResponse.setProductprice(10000);

		List<ProductResponseDto> petAnimalResponseList = new ArrayList<>();

		petAnimalResponseList.add(productAnimalResponse);

		Product product = new Product();
		product.setProductDescription("6 gb");
		product.setProductId(1);
		product.setProductName("mobiles");
		product.setProductprice(10000);

		List<Product> productList = new ArrayList<>();
		productList.add(product);

		when(productDao.findAllByProductName(any(String.class))).thenReturn(Optional.of(productList));
		productServiceImpl.getProductByProductName("productName");
		verify(productDao).findAllByProductName(any(String.class));
	}

}
