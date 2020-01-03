package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/login")
	public boolean login (@RequestBody User user) {
		return userServiceImpl.login(user.getUsername(), user.getPassword());		
	}
	
	@PostMapping("/register")
	public boolean register(@RequestBody User user) {
		return userServiceImpl.registration(user.getUsername(), user.getPassword());
	}
	
}
