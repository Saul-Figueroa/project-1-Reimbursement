package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public interface LoginControllerInterface {

	/*
	 * if the method is GET, it will return the login view
	 * 
	 * if the method is POST,
	 * 
	 * --> if the service layer returns null, we return a message "authentication failed"
	 * 
	 * 
	 * --> else, it will return the User information (and store it in the session)
	 * */
	
	
	public Object login(HttpServletRequest request);
	
	
	//Invalidates the session and returns the login view
	public String logout(HttpServletRequest request);

}
