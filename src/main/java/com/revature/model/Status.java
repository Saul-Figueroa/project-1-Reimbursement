package com.revature.model;

public class Status {
	
	private int id;
	private String name;
	private String description;
	
	
	public Status() {
		this.name = "";
		this.description = "";
	}
	
	public Status(int id) {
		this();
		this.id = id;
	}

	public Status(String name) {
		this();
		this.name = name;
		
	}


	public Status(int id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Status [id=" + id + ", name=" + name + ", description=" + description + "]";
	}
	

}
