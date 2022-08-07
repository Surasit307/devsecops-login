package com.ttb.fleet.login.login.dto;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties
public class LoginIn implements Serializable {
	private static final long serialVersionUID = 1L;
	@JsonProperty("username")
	private String username;
	@JsonProperty("password")
	private String password;
	
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


	
	

	

	



	
	

	
}