package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.ajax.ClientMessage;
import com.revature.model.Users;
import com.revature.service.UserService;
import com.revature.util.FinalUtil;

public class UserController implements UserControllerInterface{
	
	private static UserController userController = new UserController();
	
	private UserController() {
	}
	
	public static UserController getUserController() {
		return userController;
	}

	@Override
	public Object register(HttpServletRequest request) {
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (request.getMethod().equals("GET")) {
			return "register.html";
		}
		
		Users user = new Users(fname.toUpperCase(), lname.toUpperCase(), email.toUpperCase(), username.toUpperCase(), password);
		
		if (UserService.getUserService().insertUser(user)) {
			return new ClientMessage(FinalUtil.CLIENT_MESSAGE_REGISTRATION_SUCCESSFUL);
		} else {
			return new ClientMessage(FinalUtil.CLIENT_MESSAGE_SOMETHING_WRONG);
		}
	}

	@Override
	public Object viewInformation(HttpServletRequest request)	 {
		
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");
		
		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		return UserService.getUserService().viewInformation(loggedUser);
	}

	@Override
	public Object updateInformation(HttpServletRequest request) {
		
		String fname = request.getParameter("firstname");
		String lname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
     
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");
		
		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		Users user = new Users(loggedUser.getId(), fname.toUpperCase(), lname.toUpperCase(), email.toUpperCase(), username.toUpperCase(), password);
		
		return UserService.getUserService().updateInformation(user);
	}

	@Override
	public Object viewAllEmployees(HttpServletRequest request) {
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");

		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		return UserService.getUserService().viewAllEmployees();
	}

}
