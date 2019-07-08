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
		return null;
		
		
		
		
		
								
	}

}
