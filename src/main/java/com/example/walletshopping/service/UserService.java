package com.example.walletshopping.service;

import com.example.walletshopping.dto.LoginResponseDto;

public interface UserService {

	public LoginResponseDto authenticateUser(String userName, String password);

}
