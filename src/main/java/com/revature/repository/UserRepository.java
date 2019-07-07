package com.revature.repository;

import java.util.List;

import com.revature.model.Users;

public interface UserRepository {
	
	
	public boolean insertUser(Users user);
	
	//Employees can view their information, this will help to Authenticate login
	public Users viewInformation(Users user);
	public boolean updateInformation(Users user);
	//Manager can view all employees
	public List<Users> viewAllEmployees();
	
	//validate username 
	public Users authenticate(Users user);
	

	
	

}
