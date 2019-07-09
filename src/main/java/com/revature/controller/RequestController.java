package com.revature.controller;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Request;
import com.revature.model.Status;
import com.revature.model.Users;
import com.revature.service.RequestService;

public class RequestController implements RequestControllerInterface{
	
	private static RequestController requestController = new RequestController();
	
	private RequestController() {
	}
	
	public static RequestController getRequestController() {
		return requestController;
	}

	@Override
	public Object submit(HttpServletRequest request) {
		String amountString = request.getParameter("amount");
		double amount = Double.valueOf(amountString);
		String description = request.getParameter("description");
		
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");
		
		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		Request req = new Request(amount, description, new Users(loggedUser.getId()), new Status(21));
		
		return RequestService.getRequestService().submitRequest(req);
	}

	@Override
	public Object viewPendingRequest(HttpServletRequest request) {
	
	Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");

		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		Request req = new Request(new Users(loggedUser.getId()));
		
		return RequestService.getRequestService().viewPendingRequest(req);
	}

	@Override
	public Object viewResolvedRequest(HttpServletRequest request) {
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");

		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		Request req = new Request(new Users(loggedUser.getId()));
		
		return RequestService.getRequestService().viewResolvedRequest(req);
	}

	@Override
	public Object updateStatus(Request request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object viewPendingRequestsForAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object viewResolvedRequestsForAllEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object viewAllRequestsOfAnSpecificEmployee(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
