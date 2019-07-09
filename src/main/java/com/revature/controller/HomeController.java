package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Users;

public class HomeController implements HomeControllerInterface{
	
	private static HomeController homeController = new HomeController();
	
	private HomeController() {
	}
	
	public static HomeController getHomeController() {
		return homeController;
	}

	@Override
	public String home(HttpServletRequest request) {
		
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");
		
		//if user is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		
		if (loggedUser.getRole().equals(2)) {
			return "AdminHome.html";
		} 
			return "UserHome.html";
			
									
	}

}
