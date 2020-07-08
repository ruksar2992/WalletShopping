package com.example.walletshopping.servicetest;

import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.walletshopping.dao.UserDao;
import com.example.walletshopping.exception.InvalidCredentialsException;
import com.example.walletshopping.serviceimpl.UserServiceImpl;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {

	@Mock
	UserDao userDao;

	@InjectMocks
	UserServiceImpl userServiceImpl;

	@Test
	public void authenticateTest() {
		when(userDao.findByUserNameAndPassword("monisha", "moni")).thenReturn(null);

		assertThrows(InvalidCredentialsException.class, () -> userServiceImpl.authenticateUser("monisha", "moni"));

	}
}