package com.example.walletshopping.dao;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.walletshopping.model.User;

@Repository
public interface UserDao extends CrudRepository<User, Integer> {

	User findByUserNameAndPassword(String userName, String password);

	Optional<User> findAllByUserId(int userId);

}
