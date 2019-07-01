package com.revature.model;

import java.util.Date;

public class Request {
	
	private int id;
	private Date timestamp;
	private double amount;
	private String description;
	//private Clob receip;
	private Users user;
	private Status status;
	
	
	public Request() {
		this.timestamp = null;
		this.amount = 0.0;
		this.description = "";
		this.user = null;
		this.status = null;
	}


	public Request(int id) {
		this();
		this.id = id;
	}
	
	public Request(Users user) {
		super();
		this.user = user;
	}

	public Request( double amount, String description, Users user, Status status) {
		this.amount = amount;
		this.description = description;
		this.user = user;
		this.status = status;
	}
	

	public Request(int id, Date timestamp, double amount, String description, Status status) {
		this.id = id;
		this.timestamp = timestamp;
		this.amount = amount;
		this.description = description;
		this.status = status;
	}
	
	public Request(int id, Date timestamp, double amount, String description, Users user, Status status) {
		this.id = id;
		this.timestamp = timestamp;
		this.amount = amount;
		this.description = description;
		this.user = user;
		this.status = status;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Users getUser() {
		return user;
	}


	public void setUser(Users user) {
		this.user = user;
	}


	public Status getStatus() {
		return status;
	}


	public void setStatus(Status status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Request [id=" + id + ", timestamp=" + timestamp + ", amount=" + amount + ", description=" + description
				+ ", user=" + user + ", status=" + status + "]";
	}
	
	

}
