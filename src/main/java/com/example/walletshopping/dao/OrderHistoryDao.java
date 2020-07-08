package com.example.walletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.controller.OrderHistory;

@Repository
public interface OrderHistoryDao extends CrudRepository<OrderHistory, Integer> {

	Optional<List<OrderHistory>> getOrderHistoryByUserId(int userId);

}
