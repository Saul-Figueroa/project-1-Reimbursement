package com.revature.service;

import java.util.List;

import com.revature.model.Request;

public interface RequestServiceInterface {
	
	
	//Employees can submit requests, view their pending and resolved requests 
	//(could be approved or denied), view their information, update their information
	public boolean submitRequest(Request request);
	public List<Request> viewPendingRequest(Request request);
	public List<Request> viewResolvedRequest(Request request);

	
	//Managers can Approve/Deny pending requests, view all pending requests for all employees, 
	//view all resolved requests for all employees, view requests of an specific employee, 
	public boolean updateStatus(Request request);
	public List<Request> viewPendingRequestsForAllEmployees();
	public List<Request> viewResolvedRequestsForAllEmployees();
	public List<Request> viewAllRequestsOfAnSpecificEmployee(Request request);
	

}
