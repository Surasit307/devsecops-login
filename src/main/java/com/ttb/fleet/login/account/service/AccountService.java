package com.ttb.fleet.login.account.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttb.fleet.login.account.dto.AccountIn;
import com.ttb.fleet.login.account.dto.NewpasswordIn;
import com.ttb.fleet.login.login.dto.LoginIn;
import com.ttb.fleet.login.login.dto.LogoutIn;

@Service
public interface AccountService {

	Map<String, Object> create(AccountIn accountIn) throws Exception;
	
	Map<String, Object> read(int accountId) throws Exception;
	
	Map<String, Object> update(AccountIn accountIn) throws Exception;

	Map<String, Object> delete(int accountId) throws Exception;

	Map<String, Object> userlogin(LoginIn loginIn) throws Exception;

	Map<String, Object> userlogout(LogoutIn logoutIn) throws Exception;

	Map<String, Object> newpass(NewpasswordIn newpasswordIn) throws Exception;


}
