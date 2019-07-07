package com.revature.repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.revature.model.Role;
import com.revature.model.Users;
import com.revature.util.ConnectionUtil;

public class UserRepositoryJDBC implements UserRepository{
	
	private static Logger LOGGER = Logger.getLogger(UserRepositoryJDBC.class);
	
	/*
	 Singleton transformation of JDBC implementation object  
	 * */
	
	private static UserRepositoryJDBC UserDaoJdbc;
	
	private  UserRepositoryJDBC() {
		
	}
	
	public static UserRepositoryJDBC getUserDaoJdbc() {
		if (UserDaoJdbc == null) {
			UserDaoJdbc = new UserRepositoryJDBC();
			
		}
		
		return UserDaoJdbc;
	}
	
	
	//Insert user using store procedure 
	@Override
	public boolean insertUser(Users user) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			//Syntax to insert in a store procedure
			String sql = "{CALL INSERT_USERS (?, ?, ?, ?, ?, ?)}";
			// CallableStatement
			CallableStatement statement = connection.prepareCall(sql);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, user.getFirstName());
			statement.setString(++statementIndex, user.getLastName());
			statement.setString(++statementIndex, user.getEmail());
			statement.setString(++statementIndex, user.getUsername());
			statement.setString(++statementIndex, user.getPassword());
			statement.setInt(++statementIndex, user.getRole().getId());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Exception creating a new customer with stored procedure", e);
		}
		return false;
	}

	@Override
	public Users viewInformation(Users user) {
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			String sql = "SELECT * FROM USERS WHERE R_ROLE = 1 AND U_ID =?";
			// PreparedStatement
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			statement.setInt(++statementIndex, user.getId());
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return new Users(
						result.getInt("U_ID"),
						result.getString("U_FNAME"),
						result.getString("U_LNAME"),
						result.getString("U_EMAIL"),
						result.getString("U_USERNAME"),
						result.getString("U_PASSWORD"),
						new Role(result.getInt("R_ROLE"))
						);
			}
		} catch (SQLException e) {
			LOGGER.error("Exception retrieving user information ", e);
		}
		return new Users();
	}

	@Override
	public List<Users> viewAllEmployees() {
		try(Connection connection = ConnectionUtil.getConnection()) {
			
			String sql = "SELECT U.U_ID, U.U_FNAME, U.U_LNAME, U.U_EMAIL, U.U_USERNAME, ER.ER_NAME FROM USERS U INNER JOIN EMPLOYEE_ROLE ER ON U.R_ROLE = ER.ER_ID WHERE U.R_ROLE != 2";                                                  
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			
			List<Users> users = new ArrayList<Users>();
			
			
			while(result.next()) {
				        users.add( new Users(
						result.getInt("U_ID"),
						result.getString("U_FNAME"),
						result.getString("U_LNAME"),
						result.getString("U_EMAIL"),
						result.getString("U_USERNAME"),
						new Role(result.getString("ER_NAME"))
						));
			}
			return users;
		} catch (SQLException e) {
			LOGGER.error("Exception, could not retrieve all users ", e);
		}
		return new ArrayList<>();
	}
	
	@Override
	public boolean updateInformation(Users user) {
		
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
	
			String sql = "UPDATE USERS SET U_FNAME =? , U_LNAME =? , U_EMAIL =? , U_USERNAME=? , U_PASSWORD =? WHERE U_ID = ?";
			PreparedStatement statement = connection.prepareStatement(sql);
			
			//Set attributes to be inserted
			statement.setString(++statementIndex, user.getFirstName() );
			statement.setString(++statementIndex, user.getLastName());
			statement.setString(++statementIndex, user.getEmail());
			statement.setString(++statementIndex, user.getUsername());
			statement.setString(++statementIndex, user.getPassword());
			statement.setInt(++statementIndex, user.getId());
			
			if(statement.executeUpdate() > 0) {
				return true;
			}
		} catch (SQLException e) {
			LOGGER.error("Exception could not update information ", e);
		}
		
		return false;
	}
	
	@Override
	public Users authenticate(Users user) {
			
		try(Connection connection = ConnectionUtil.getConnection()) {
			int statementIndex = 0;
			
			String sql = "SELECT * FROM USERS WHERE U_USERNAME=?";
			// PreparedStatement
			PreparedStatement statement = connection.prepareStatement(sql);
			//Set attributes to be inserted
			statement.setString(++statementIndex, user.getUsername());
			ResultSet result = statement.executeQuery();
			
			if(result.next()) {
				return new Users(
						result.getInt("U_ID"),
						result.getString("U_FNAME"),
						result.getString("U_LNAME"),
						result.getString("U_EMAIL"),
						result.getString("U_USERNAME"),
						result.getString("U_PASSWORD"),
						new Role(result.getInt("R_ROLE"))
						);
			}
		} catch (SQLException e) {
			LOGGER.error("Exception retrieving user information ", e);
		}
		return new Users();
	}
	
	
	public static void main(String[] args) {
		
		//Testing insert
		//LOGGER.info(getUserDaoJdbc().insertUser(new Users("TEST2","TEST2","TEST2","TEST2","TEST2",new Role(1))));
		
		//view an specific employee
		//LOGGER.info(getUserDaoJdbc().viewInformation(new Users(2)));
		
		//view all employees
		//LOGGER.info(getUserDaoJdbc().viewAllEmployees());
		
		//update information
		//LOGGER.info(getUserDaoJdbc().updateInformation(new Users(41, "Jonh","Jonh","jonh@gmail.com","JONH","123")));
		
		//Select * using username 
		//LOGGER.info(getUserDaoJdbc().authenticate(new Users("JONH")));
		
	}

	

	

}
