package com.example.walletshopping.serviceimpl;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.walletshopping.dao.UserDao;
import com.example.walletshopping.dto.LoginResponseDto;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.model.User;
import com.example.walletshopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	private static Log logger = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserDao userDao;

	@Override
	public LoginResponseDto authenticateUser(@Valid String userName, String password) {
		logger.info("implementaion of authenticating the user");
		User user = userDao.findByUserNameAndPassword(userName, password);

		if (user != null) {
			LoginResponseDto loginResponseDto = new LoginResponseDto();
			loginResponseDto.setUserId(user.getUserId());
			loginResponseDto.setMessage("logged in successfully");
			loginResponseDto.setStatuscode(HttpStatus.OK.value());
			return loginResponseDto;

		} else {
			throw new InvalidCredentialsException("invalid credentials !! please try again with valid credentials");
		}
	}
}
