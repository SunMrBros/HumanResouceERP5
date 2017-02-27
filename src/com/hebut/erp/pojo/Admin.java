package com.hebut.erp.pojo;

public class Admin {
	private String name;
	private String password;
	private String email;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", password=" + password + ", email="
				+ email + "]";
	}
	public Admin(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
