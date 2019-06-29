package com.revature.repository;

import java.util.List;

import com.revature.model.Users;

public interface UserRepository {
	
	
	public boolean insertUser(Users user);
	public Users select(Users user); 
	
	//Employees can view their information
	public Users viewInformation(Users user);
	public boolean updateInformation(Users user);
	//Manager can view all employees
	public List<Users> viewAllEmployees(Users user);
	

}
