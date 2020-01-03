package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDao;
import com.example.demo.model.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean login(String username, String password) {
		boolean status = false;
		User retrievedUser = userDao.findById(username).orElse(null);
		if (retrievedUser == null) {
			System.out.println("Username does not exist");
		}
		else {
			if (password.contentEquals(retrievedUser.getPassword())) {
				status = true;
			}
			else {
				System.out.println("Incorrect Password Entered");
			}
			
		}			
		return status;
	}

	@Override
	public boolean registration(String username, String password) {
		boolean status = false;
		User newUser = new User();
		newUser.setPassword(password);
		newUser.setUsername(username);
		
		User retrievedUser = userDao.findById(username).orElse(null);
		if (retrievedUser == null) {
			userDao.save(newUser);
			status = true;
			System.out.println("User created");
		}
		else {
			System.out.println("Username already exists, please choose a different username");
		}
		
		return status;
	}
}
