package com.revature.service;

import java.util.List;

import com.revature.model.Users;

public interface UserServiceInterface {
	
	
	public boolean insertUser(Users user);
	
	//Employees can view their information, this will help to Authenticate login
	public Users viewInformation(Users user);
	public boolean updateInformation(Users user);
	//Manager can view all employees
	public List<Users> viewAllEmployees();
	
	public Users authenticate(Users user);
	
	public String home(Users user);
	


}
