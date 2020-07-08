package com.example.walletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Orders;

@Repository
public interface OrderDao extends CrudRepository<Orders, Integer> {

	Optional<List<Orders>> findAllByUserId(int userId);

}
