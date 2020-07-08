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

import com.example.walletshopping.dao.ProductDao;
import com.example.walletshopping.dto.ProductListResponseDto;
import com.example.walletshopping.dto.ProductResponseDto;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.model.Product;
import com.example.walletshopping.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	Log logger = LogFactory.getLog(ProductServiceImpl.class);

	@Autowired
	ProductDao ProductDao;

	@Override
	public ProductListResponseDto getProductByProductName(String productName) throws InvalidCredentialsException {
		logger.info(" Enter correct ProductName");

		ProductListResponseDto productListResponseDto = new ProductListResponseDto();
		Optional<List<Product>> productDetails = ProductDao.findAllByProductName(productName);
		if (!productDetails.isPresent()) {

			throw new InvalidCredentialsException(" your request are notFound");
		}

		List<ProductResponseDto> productList = productDetails.get().stream()
				.map(Product -> getProductDetailsResponseDto(Product)).collect(Collectors.toList());
		productListResponseDto.setMessage(" available pets");
		productListResponseDto.setStatusCode(HttpStatus.OK.value());
		productListResponseDto.setProductResponse(productList);
		return productListResponseDto;

	}

	private ProductResponseDto getProductDetailsResponseDto(Product product) {

		ProductResponseDto productDetailsResponse = new ProductResponseDto();
		BeanUtils.copyProperties(product, productDetailsResponse);
		return productDetailsResponse;
	}
}
