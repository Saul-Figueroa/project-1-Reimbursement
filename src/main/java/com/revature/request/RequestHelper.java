package com.revature.request;

import javax.servlet.http.HttpServletRequest;

public class RequestHelper {

	private RequestHelper () {
		
	}
	
	public static Object process(HttpServletRequest request) {
	
		switch (request.getRequestURI()) {
		case "/login.do":
			

		default:
			return "not-implemented.html";
		}
		
		
	}
}
