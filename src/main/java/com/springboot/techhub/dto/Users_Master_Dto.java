package com.springboot.techhub.dto;

import java.util.Date;

public class Users_Master_Dto {

	private String F_Name;
	private String L_Name;
	private String username;
	private String password;
	private String user_email;
	private String Phone_number;
	private Date user_DOB;
	private String user_Role;
	private String address;
	private String city;
	
	public String getF_Name() {
		return F_Name;
	}
	public void setF_Name(String f_Name) {
		F_Name = f_Name;
	}
	public String getL_Name() {
		return L_Name;
	}
	public void setL_Name(String l_Name) {
		L_Name = l_Name;
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
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getPhone_number() {
		return Phone_number;
	}
	public void setPhone_number(String phone_number) {
		Phone_number = phone_number;
	}
	public Date getUser_DOB() {
		return user_DOB;
	}
	public void setUser_DOB(Date user_DOB) {
		this.user_DOB = user_DOB;
	}
	public String getUser_Role() {
		return user_Role;
	}
	public void setUser_Role(String user_Role) {
		this.user_Role = user_Role;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public Users_Master_Dto() {
		super();
	}
	public Users_Master_Dto(String f_Name, String l_Name, String username, String password, String user_email,
			String phone_number, Date user_DOB, String user_Role,String address,String city) {
		
		F_Name = f_Name;
		L_Name = l_Name;
		this.username = username;
		this.password = password;
		this.user_email = user_email;
		Phone_number = phone_number;
		this.user_DOB = user_DOB;
		this.user_Role = user_Role;
		this.address = address;
		this.city=city;
	}
	
}
