package com.example.walletshopping.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.Order;

@Repository
public interface OrderDao extends CrudRepository<Order, Integer> {

}
