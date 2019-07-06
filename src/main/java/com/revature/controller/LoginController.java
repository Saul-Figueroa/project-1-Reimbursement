package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

public class LoginController implements LoginControllerInterface{
	
	private static LoginController loginController;
	
	private LoginController() {
	}
	
	public static LoginController getLoginController() {
		
		return loginController;
	}

	@Override
	public Object login(HttpServletRequest request) {
		
	
		return null;
	}

	@Override
	public String logout(HttpServletRequest request) {
	
		request.getSession().invalidate();
		return "login.html";
	}
	

}
