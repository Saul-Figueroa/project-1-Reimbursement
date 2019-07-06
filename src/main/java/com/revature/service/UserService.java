package com.revature.service;

import java.util.List;

import com.revature.model.Users;
import com.revature.repository.UserRepositoryJDBC;

public class UserService implements UserServiceInterface{
	
		/*Singleton*/
	private static UserService userService;
	
	private UserService() {
	}
			
	public static UserService getUserService() {
		
		if (userService == null) {
			
			userService = new UserService();		
		}
		return userService;
	}
			
			
	@Override
	public boolean insertUser(Users user) {
		
		return UserRepositoryJDBC.getUserDaoJdbc().insertUser(user);
	}

	@Override
	public Users viewInformation(Users user) {

		return UserRepositoryJDBC.getUserDaoJdbc().viewInformation(user);
	}

	@Override
	public boolean updateInformation(Users user) {

		return UserRepositoryJDBC.getUserDaoJdbc().updateInformation(user);
	}

	@Override
	public List<Users> viewAllEmployees() {
	
		return UserRepositoryJDBC.getUserDaoJdbc().viewAllEmployees();
	}

	@Override
	public Users authenticate(Users user) {
		
		return null;
	}

}
