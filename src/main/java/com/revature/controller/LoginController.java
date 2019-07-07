package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import com.revature.ajax.ClientMessage;
import com.revature.model.Users;
import com.revature.service.UserService;

public class LoginController implements LoginControllerInterface{
	
	private static LoginController loginController = new LoginController();
	
	private LoginController() {
	}
	
	public static LoginController getLoginController() {
		
		return loginController;
	}

	@Override
	public Object login(HttpServletRequest request) {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		if (request.getMethod().equals("GET")) {
			
			return "login.html";
			
		}
		
		Users loggedUser = UserService.getUserService().authenticate(new Users(username, password));
		
		//if authentication failed
		if (loggedUser == null) {
			return new ClientMessage("AUTHENTICATION FAILED");
		}
		
		
		//store the customer information in the session
		request.getSession().setAttribute("loggedUser", loggedUser);
		
		
		return loggedUser;
	}

	@Override
	public String logout(HttpServletRequest request) {
	
		request.getSession().invalidate();
		return "login.html";
	}
	

}