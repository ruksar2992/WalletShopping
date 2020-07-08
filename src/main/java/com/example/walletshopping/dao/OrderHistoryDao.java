package com.example.walletshopping.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.controller.OrderHistory;

@Repository
public interface OrderHistoryDao extends CrudRepository<OrderHistory, Integer> {
	@Query(value="select * from order_history ord where ord.user_id=:userId",nativeQuery = true)
	Optional<List<OrderHistory>> getOrderHistoryByUserId(int userId);

}