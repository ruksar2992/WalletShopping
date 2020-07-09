package com.example.walletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Cart;

@Repository
public interface CartDao extends CrudRepository<Cart, Integer> {

	Optional<List<Cart>> findAllByUserId(int userId);

	Optional<Cart> findAllByCartId(int cartId);

	Cart findByCartId(int cartId);

}
