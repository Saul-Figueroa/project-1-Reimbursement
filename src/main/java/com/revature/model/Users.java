package com.revature.model;

public class Users {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;
	private Role role;
	
	
	
	public Users() {
		this.firstName ="";
		this.lastName ="";
		this.email = "";
		this.username ="";
		this.password = "";
	}
	
	public Users(int id) {
		this();
		this.id = id;
	}

	

	public Users(String username, String password) {
		this();
		this.username = username;
		this.password = password;
	}

	
	public Users(String firstName) {
		this();
		this.firstName = firstName;
	}

	public Users(int id, String firstName, String lastName, String email, String username, String password, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	public Users(int id, String firstName, String lastName, String email, String username, Role role) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.role = role;
	}
	
	public Users(int id,String firstName, String lastName, String email, String username, String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		
	}

	public Users(String firstName, String lastName, String email, String username, String password, Role role) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}


}
