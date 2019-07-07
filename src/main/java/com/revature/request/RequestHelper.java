package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.LoginController;

public class RequestHelper {

	private RequestHelper () {
		
	}
	
	public static Object process(HttpServletRequest request) {
	
		switch (request.getRequestURI()) {
		case "/project-1-Saul-Figueroa/login.do":
			return LoginController.getLoginController().login(request);
			
		case "/project-1-Saul-Figueroa/register.do":
			return "";
			

		default:
			return "/project-1-Saul-Figueroa/not-implemented.html";
		}
		
		
	}
}
