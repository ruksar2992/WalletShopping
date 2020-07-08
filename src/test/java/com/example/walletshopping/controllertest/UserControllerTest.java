package com.example.walletshopping.controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.walletshopping.controller.UserController;
import com.example.walletshopping.dto.LoginRequestDto;
import com.example.walletshopping.dto.LoginResponseDto;
import com.example.walletshopping.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	ObjectMapper objectMapper;

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	MockMvc mockMvc;

	LoginRequestDto loginRequestDto;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

		loginRequestDto = new LoginRequestDto();
		loginRequestDto.setPassword("moni");
		loginRequestDto.setUserName("monisha");

	}

	@Test
	public void loginTest() throws Exception {

		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("successfull login");
		loginResponseDto.setStatuscode(200);
		loginResponseDto.setUserId(1);

		Mockito.when(userService.authenticateUser(loginRequestDto.getUserName(), loginRequestDto.getPassword()))
				.thenReturn(loginResponseDto);

		ResponseEntity<LoginResponseDto> loginResponse = userController.userLogin(loginRequestDto);
		assertEquals(HttpStatus.OK, loginResponse.getStatusCode());

	}

}
