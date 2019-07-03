package com.revature.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DispatcherServlet extends HttpServlet{

	/**
	 * For java 2 compatibility
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object data = RequestHelper.process(request);
		
		//if the controller return a string, we forward to an HTML file
		
		if (data instanceof String) {
			
			String URI = (String) data;
			request.getRequestDispatcher(URI).forward(request, response);
		} 
		//else, we marshall the given POJO
		else {
			response.getWriter().write(new ObjectMapper().writeValueAsString(data));

		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//We just call doGet method with the request and response
		doGet(request, response);
	}

}
