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
	public Object updateStatus(HttpServletRequest request) {
		
		String status_string = request.getParameter("r_status");
		int r_status = Integer.valueOf(status_string);
		
		String r_id_string = request.getParameter("r_id");
		int r_id = Integer.valueOf(r_id_string);
		
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");

		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		Request req = new Request(new Status(r_status), r_id);
		
		
		return RequestService.getRequestService().updateStatus(req);
	
	}

	@Override
	public Object viewPendingRequestsForAllEmployees() {
	
		return RequestService.getRequestService().viewPendingRequestsForAllEmployees();
	}

	@Override
	public Object viewResolvedRequestsForAllEmployees() {
		
		return RequestService.getRequestService().viewResolvedRequestsForAllEmployees();
	}

	@Override
	public Object viewAllRequestsOfAnSpecificEmployee(HttpServletRequest request) {
		
		
		int e_id = Integer.parseInt(request.getParameter("id"));
	
		Users loggedUser = (Users) request.getSession().getAttribute("loggedUser");

		//if customer is not logged in
		if (loggedUser == null) {
			return "login.html";
		}
		
		Request req = new Request(new Users(e_id));
		
		return RequestService.getRequestService().viewAllRequestsOfAnSpecificEmployee(req);
	}
	
	

	

}
