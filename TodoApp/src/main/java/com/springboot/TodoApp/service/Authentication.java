package com.springboot.TodoApp.service;

import org.springframework.stereotype.Service;

@Service
public class Authentication {
	public boolean validateUser(String username, String password) {
		boolean isValidUsername = username.equalsIgnoreCase("SinghShubham1308");
		boolean isValidPassword = password.equalsIgnoreCase("1234567890");
		return isValidUsername && isValidPassword;
	}
}
