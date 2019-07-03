package com.revature.service;

import org.apache.log4j.Logger;

import com.revature.model.Users;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryJDBC;

public class UserService {
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	//Dependency
	
	private UserRepository userRepository = UserRepositoryJDBC.getUserDaoJdbc();
	
	public boolean registerUser(Users user) {
		LOGGER.trace("Entering register user " +user);
		return true;
		//return userRepository.insertUser(user);
		
	}

}
