package com.revature.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Users;
import com.revature.repository.UserRepository;
import com.revature.repository.UserRepositoryJDBC;

public class UserService implements UserServiceInterface{
	
	private static final Logger LOGGER = Logger.getLogger(UserService.class);
	
	//Dependency
	
	private UserRepository userRepository = UserRepositoryJDBC.getUserDaoJdbc();
	
	public boolean registerUser(Users user) {
		LOGGER.trace("Entering register user " +user);
		return true;
		//return userRepository.insertUser(user);
		
	}

	@Override
	public boolean insertUser(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Users viewInformation(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateInformation(Users user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Users> viewAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Users authenticate(Users user) {
		// TODO Auto-generated method stub
		return null;
	}

}
