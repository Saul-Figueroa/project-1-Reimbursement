package com.revature.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Request;
import com.revature.model.Status;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class RequestRepositoryJDBC implements RequestRepository{
	
	private static Logger LOGGER = Logger.getLogger(UserRepositoryJDBC.class);
	
	/*
	 Singleton transformation of JDBC implementation object  
	 * */
	private static RequestRepositoryJDBC RequestDaoJdbc;
	
	private RequestRepositoryJDBC() {

	}
	
	public static RequestRepositoryJDBC getRequestDaoJdbc() {
		
		if (RequestDaoJdbc == null) {
			RequestDaoJdbc = new RequestRepositoryJDBC();
		}
		
		return RequestDaoJdbc;
	}
	

	//Insert request using store procedure 
	@Override
	public boolean submitRequest(Request request) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Syntax to insert in a store procedure
			String sql = "{CALL INSERT_REQUESTS (?, ?, ?, ?)}";
			// CallableStatement
			CallableStatement statement = connection.prepareCall(sql);
			
			//Set attributes to be inserted
			statement.setDouble(++statementIndex,  request.getAmount());
			statement.setString(++statementIndex, request.getDescription());
			statement.setInt(++statementIndex, request.getUser().getId());
			statement.setInt(++statementIndex, request.getStatus().getId());
		
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Exception could not insert the request ", e);
		}
		return false;
		
	}

	@Override
	public List<Request> viewPendingRequest(Request request) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Syntax to insert in a store procedure
			String sql = "SELECT U.U_FNAME, R.R_ID, R.R_TIMESTAMP,R.R_AMOUNT, R.R_DESCRIPTION, S.S_NAME FROM REQUEST R INNER JOIN STATUS S ON R.S_ID = S.S_ID INNER JOIN USERS U ON U.U_ID = R.U_ID WHERE R.U_ID = ? AND R.S_ID =21 ORDER BY R.R_ID";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			statement.setInt(++statementIndex, request.getUser().getId());
			
			ResultSet result = statement.executeQuery();
			List<Request> pendingRequest = new ArrayList<Request>();
			
			while(result.next()) {
				pendingRequest.add(new Request(
						result.getInt("R_ID"),
						result.getDate("R_TIMESTAMP"),
						result.getDouble("R_AMOUNT"),
						result.getString("R_DESCRIPTION"),
						new Users(result.getString("U_FNAME")),
						new Status(result.getString("S_NAME"))
						
						));
			}
			
			return pendingRequest;
		} catch (SQLException e) {
			LOGGER.error("Exception, could not retreive requests ", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Request> viewResolvedRequest(Request request) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Syntax to insert in a store procedure
			String sql = "SELECT R.R_ID, R.R_TIMESTAMP,R.R_AMOUNT, R.R_DESCRIPTION, S.S_NAME FROM REQUEST R INNER JOIN STATUS S ON R.S_ID = S.S_ID WHERE R.U_ID = ? AND R.S_ID !=21 ORDER BY R.R_ID";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			statement.setInt(++statementIndex, request.getUser().getId());
			
			ResultSet result = statement.executeQuery();
			List<Request> resolvedRequest = new ArrayList<Request>();
			
			while(result.next()) {
				resolvedRequest.add(new Request(
						result.getInt("R_ID"),
						result.getDate("R_TIMESTAMP"),
						result.getDouble("R_AMOUNT"),
						result.getString("R_DESCRIPTION"),
						new Status(result.getString("S_NAME"))
						
						));
			}
			
			return resolvedRequest;
		} catch (SQLException e) {
			LOGGER.error("Exception, could not retreive requests ", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Request> viewPendingRequestsForAllEmployees() {
try(Connection connection = ConnectionUtil.getConnection()) {
			
			//Syntax to insert in a store procedure
			String sql = "SELECT R.R_ID, R.R_TIMESTAMP,R.R_AMOUNT, R.R_DESCRIPTION, S.S_NAME FROM REQUEST R INNER JOIN STATUS S ON R.S_ID = S.S_ID WHERE R.S_ID =21 ORDER BY R.R_ID";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			
			ResultSet result = statement.executeQuery();
			List<Request> allPendingRequest = new ArrayList<Request>();
			
			while(result.next()) {
				allPendingRequest.add(new Request(
						result.getInt("R_ID"),
						result.getDate("R_TIMESTAMP"),
						result.getDouble("R_AMOUNT"),
						result.getString("R_DESCRIPTION"),
						new Status(result.getString("S_NAME"))
						
						));
			}
			
			return allPendingRequest;
		} catch (SQLException e) {
			LOGGER.error("Exception, could not retreive requests ", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Request> viewResolvedRequestsForAllEmployees() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			//Syntax to insert in a store procedure
			String sql = "SELECT R.R_ID, R.R_TIMESTAMP,R.R_AMOUNT, R.R_DESCRIPTION, S.S_NAME FROM REQUEST R INNER JOIN STATUS S ON R.S_ID = S.S_ID WHERE R.S_ID !=21 ORDER BY R.R_ID";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			
			ResultSet result = statement.executeQuery();
			List<Request> allResolvedRequest = new ArrayList<Request>();
			
			while(result.next()) {
				allResolvedRequest.add(new Request(
						result.getInt("R_ID"),
						result.getDate("R_TIMESTAMP"),
						result.getDouble("R_AMOUNT"),
						result.getString("R_DESCRIPTION"),
						new Status(result.getString("S_NAME"))
						
						));
			}
			
			return allResolvedRequest;
		} catch (SQLException e) {
			LOGGER.error("Exception, could not retreive requests ", e);
		}
		
		return new ArrayList<>();
	}

	@Override
	public List<Request> viewAllRequestsOfAnSpecificEmployee(Request request) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Syntax to insert in a store procedure
			String sql = "SELECT U.U_FNAME, R.R_ID, R.R_TIMESTAMP,R.R_AMOUNT, R.R_DESCRIPTION, S.S_NAME FROM REQUEST R INNER JOIN STATUS S ON R.S_ID = S.S_ID INNER JOIN USERS U ON U.U_ID = R.U_ID WHERE R.U_ID = ? ORDER BY R.R_ID";
			
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			statement.setInt(++statementIndex, request.getUser().getId());
			
			ResultSet result = statement.executeQuery();
			List<Request> requests = new ArrayList<Request>();
			
			while(result.next()) {
				requests.add(new Request(
						result.getInt("R_ID"),
						result.getDate("R_TIMESTAMP"),
						result.getDouble("R_AMOUNT"),
						result.getString("R_DESCRIPTION"),
						new Users(result.getString("U_FNAME")),
						new Status(result.getString("S_NAME"))
						
						));
			}
			
			
			return requests;
		} catch (SQLException e) {
			LOGGER.error("Exception, could not retreive requests ", e);
		}
		
		return new ArrayList<>();
	}
	
	@Override
	public boolean updateStatus(Request request) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			String sql = "UPDATE REQUEST SET S_ID =? WHERE R_ID=?";
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			statement.setInt(++statementIndex, request.getStatus().getId());
			statement.setInt(++statementIndex, request.getId());
			
		
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Exception ", e);
		}
		return false;
		
	}
	
	public static void main(String[] args) {
		
		//insert request
		//LOGGER.info(getRequestDaoJdbc().submitRequest(new Request(300,"New request",new Users(41), new Status(21))));
		
		//view pending requests
		//LOGGER.info(getRequestDaoJdbc().viewPendingRequest(new Request(new Users(21))));
		
		//view resolved requests
		//LOGGER.info(getRequestDaoJdbc().viewResolvedRequest(new Request(new Users(2))));
		
		//view all pending requests for all employees
		//LOGGER.info(getRequestDaoJdbc().viewPendingRequestsForAllEmployees());
		
		//view all resolved requests for all employees
		//LOGGER.info(getRequestDaoJdbc().viewResolvedRequestsForAllEmployees());
		
		//view all requests af an specific employee
		//LOGGER.info(getRequestDaoJdbc().viewAllRequestsOfAnSpecificEmployee(new Request(new Users(21))));
		
		//update request status
		//LOGGER.info(getRequestDaoJdbc().updateStatus(new Request(new Status(22), 21)));
		
	}

	

}


