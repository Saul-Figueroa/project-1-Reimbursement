package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Users;

public interface UserControllerInterface {
	
	/*Register the user
	 * 
	 * --> if method is GET return the register view
	 * 
	 * --> else return a message, "registration was successful or not"
	 * */
	
	public Object register(HttpServletRequest request);
	
	public Object viewInformation(HttpServletRequest request);
	
	public Object updateInformation(HttpServletRequest request);
	
	public Object viewAllEmployees(HttpServletRequest request);
	

}
