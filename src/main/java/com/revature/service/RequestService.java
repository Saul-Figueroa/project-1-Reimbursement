package com.revature.service;

import java.util.List;

import com.revature.model.Request;
import com.revature.repository.RequestRepositoryJDBC;

public class RequestService implements RequestServiceInterface{
	
	/*Singleton*/
	
	private static RequestService requestService;
	
	private RequestService() {
	}
	
	public static RequestService getRequestService() {
		if (requestService == null) {
			requestService = new RequestService();
		}
		
		return requestService;
	}

	@Override
	public boolean submitRequest(Request request) {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().submitRequest(request);
	}

	@Override
	public List<Request> viewPendingRequest(Request request) {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().viewPendingRequest(request);
	}

	@Override
	public List<Request> viewResolvedRequest(Request request) {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().viewResolvedRequest(request);
	}

	@Override
	public boolean updateStatus(Request request) {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().updateStatus(request);
	}

	@Override
	public List<Request> viewPendingRequestsForAllEmployees() {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().viewPendingRequestsForAllEmployees();
	}

	@Override
	public List<Request> viewResolvedRequestsForAllEmployees() {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().viewResolvedRequestsForAllEmployees();
	}

	@Override
	public List<Request> viewAllRequestsOfAnSpecificEmployee(Request request) {
		
		return RequestRepositoryJDBC.getRequestDaoJdbc().viewAllRequestsOfAnSpecificEmployee(request);
	}

}
