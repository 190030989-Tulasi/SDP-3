package com.klu.web.dto;

public class UserRegistrationDto {
	private String firstName;
	private String lastName;
	private String uname;
	private String password;
	

	public UserRegistrationDto(){
		
	}
	
	public UserRegistrationDto(String firstName, String lastName,String uname, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.uname = uname;
		this.password = password;
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
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
