package com.example.walletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Product;

/**
 * @author hemas
 *
 */
@Repository
public interface ProductDao extends CrudRepository<Product, Integer> {

	 Optional<List<Product>> findAllByProductName(String productName);

	Optional<Product> findAllByProductId(int productId);
		
	
	

}
