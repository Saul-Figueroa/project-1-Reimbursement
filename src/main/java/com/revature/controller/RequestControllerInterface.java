package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.revature.model.Request;

public interface RequestControllerInterface {
	
	//Employees can submit requests and view pending and resolved requests
	public Object submit(HttpServletRequest request);
	public Object viewPendingRequest(HttpServletRequest request);
	public Object viewResolvedRequest(HttpServletRequest request);

	
	//Managers can Approve/Deny pending requests, view all pending requests for all employees, 
	//view all resolved requests for all employees, view requests of an specific employee, 
	public Object updateStatus(Request request);
	public Object viewPendingRequestsForAllEmployees();
	public Object viewResolvedRequestsForAllEmployees();
	public Object viewAllRequestsOfAnSpecificEmployee(HttpServletRequest request);
	

}
