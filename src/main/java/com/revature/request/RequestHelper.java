package com.revature.request;

import javax.servlet.http.HttpServletRequest;

import com.revature.controller.RequestController;
import com.revature.controller.LoginController;
import com.revature.controller.UserController;

public class RequestHelper {

	private RequestHelper () {
		
	}
	
	public static Object process(HttpServletRequest request) {
	
		switch (request.getRequestURI()) {
		case "/project-1-Saul-Figueroa/login.do":
			return LoginController.getLoginController().login(request);
			
		case "/project-1-Saul-Figueroa/logout.do":
			return LoginController.getLoginController().logout(request);
			
		case "/project-1-Saul-Figueroa/register.do":
			return UserController.getUserController().register(request);
			
		case "/project-1-Saul-Figueroa/home.do":
			return LoginController.viewHome(request);
		//view employee information 
		case "/project-1-Saul-Figueroa/viewemployee.do":
			return UserController.getUserController().viewInformation(request);
		//employee update his information
		case "/project-1-Saul-Figueroa/updateemployee.do":
			return UserController.getUserController().updateInformation(request);
		//employee can send a request
		case "/project-1-Saul-Figueroa/sendrequest.do":
			return RequestController.getRequestController().submit(request);
		
		//employee can view his pending requests
		case "/project-1-Saul-Figueroa/viewpendingrequests.do":
			return RequestController.getRequestController().viewPendingRequest(request);
		//employee can view his resolved requests
		case "/project-1-Saul-Figueroa/viewresolvedrequests.do":
			return RequestController.getRequestController().viewResolvedRequest(request);
		
			//manager view all employees
		case "/project-1-Saul-Figueroa/viewallemployees.do":
			return UserController.getUserController().viewAllEmployees(request);
			
			
			
			

		default:
			return "/project-1-Saul-Figueroa/not-implemented.html";
		}
		
		
	}
}
