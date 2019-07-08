package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.HomeController;
import com.revature.controller.LoginController;
import com.revature.controller.UserController;

public class RequestHelper {

	private RequestHelper () {
		
	}
	
	public static Object process(HttpServletRequest request) {
	
		switch (request.getRequestURI()) {
		case "/project-1-Saul-Figueroa/login.do":
			return LoginController.getLoginController().login(request);
			
		case "/project-1-Saul-Figueroa/register.do":
			return UserController.getUserController().register(request);
			
		case "/project-1-Saul-Figueroa/home.do":
			return LoginController.viewHome(request);
			
			

		default:
			return "/project-1-Saul-Figueroa/not-implemented.html";
		}
		
		
	}
}
