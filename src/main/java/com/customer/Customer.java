package com.customer;

public class Customer {
	private int id;
	private String name;
	private String email;
	private String phone;
	private String uname;
	private String upass;
	
	public Customer(int id, String name, String email, String phone, String uname, String upass) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.uname = uname;
		this.upass = upass;
	}
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public String getUname() {
		return uname;
	}

	public String getUpass() {
		return upass;
	}
}
