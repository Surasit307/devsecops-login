package com.ttb.fleet.login.account.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttb.fleet.login.account.dto.AccountIn;
import com.ttb.fleet.login.login.dto.LoginIn;

@Service
public interface AccountService {

	Map<String, Object> create(AccountIn accountIn) throws JsonProcessingException;
	
	Map<String, Object> read(int accountId) throws JsonProcessingException;
	
	Map<String, Object> update(AccountIn accountIn) throws JsonProcessingException;

	Map<String, Object> delete(int accountId) throws JsonProcessingException;


	Map<String, Object> userlogin(LoginIn loginIn) throws JsonProcessingException;


}
