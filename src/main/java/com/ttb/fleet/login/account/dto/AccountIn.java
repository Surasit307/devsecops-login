package com.ttb.fleet.login.account.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class AccountIn implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JsonProperty("account_id")
	private int accountId;
	@JsonProperty("firstname")
	private String firstname;
	@JsonProperty("lastname")
	private String lastname;
	@JsonProperty("gender")
	private String gender;
	@JsonProperty("address")
	private String address;
	@JsonProperty("username")
	public String username;
	@JsonProperty("password")
	private String password;
	@JsonProperty("email")
	private String email;
	/*@JsonProperty("email_validation")
	private String email_validation;
	@JsonProperty("newpassword")
	private String newpassword;*/
	
	public int getAccountId() {
		return accountId;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getGender() {
		return gender;
	}
	public String getAddress() {
		return address;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	


	
	
	
	
	
	


	

}
