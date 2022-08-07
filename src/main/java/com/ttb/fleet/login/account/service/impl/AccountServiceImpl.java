package com.ttb.fleet.login.account.service.impl;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ttb.fleet.login.account.dto.AccountIn;
import com.ttb.fleet.login.account.service.AccountService;
import com.ttb.fleet.login.entity.Account;
import com.ttb.fleet.login.entity.Login;
import com.ttb.fleet.login.login.dto.LoginIn;
import com.ttb.fleet.login.repository.AccountRepository;
import com.ttb.fleet.login.repository.LoginRepository;




@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    
    @Autowired
    private LoginRepository loginRepository;
    
	private final Logger logger = LoggerFactory
			.getLogger(com.ttb.fleet.login.account.controller.AccountController.class);

    @Override //Create Message
    public Map<String,Object> create(AccountIn accountIn) throws JsonProcessingException {
        Account account = new Account();
        //account.setAccountId(accountIn.getAccountId());
        account.setFirstname(accountIn.getFirstname());
        account.setLastname(accountIn.getLastname());
        account.setGender(accountIn.getGender());
        account.setAddress(accountIn.getAddress());
        account.setUsername(accountIn.getFirstname());
        account.setPassword(accountIn.getPassword());
        account.setEmail(accountIn.getEmail());
        account.setEmail_validation(null);
        account.setNewpassword(null);
        account.setDate(new Timestamp(System.currentTimeMillis()));
        
      
        accountRepository.save(account);
        String json = new Gson().toJson(account);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }
    
    
    @Override //Read Account
    public Map<String,Object> read(int accountId) throws JsonProcessingException {
    	
    	Account account = accountRepository.findAccountByAccountId(accountId);
   
    	String json = new Gson().toJson(account);
    	Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
    	return result;
    	
    }
    
    @Override //Update Account
    public Map<String,Object> update(AccountIn accountIn) throws JsonProcessingException {
    	Account account = accountRepository.findAccountByAccountId(accountIn.getAccountId());
        if(account == null){
            return null;
        }
        account.setAccountId(accountIn.getAccountId());
        account.setFirstname(accountIn.getFirstname());
        account.setLastname(accountIn.getLastname());
        account.setGender(accountIn.getGender());
        account.setAddress(accountIn.getAddress());
        account.setUsername(accountIn.getFirstname());
        account.setPassword(accountIn.getPassword());
        account.setEmail(accountIn.getEmail());
        account.setDate(new Timestamp(System.currentTimeMillis()));
        
       
        
        accountRepository.save(account);
        String json = new Gson().toJson(account);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }

    @Override //Delete Account
    public Map<String,Object> delete(int accountId) throws JsonProcessingException {
        Account account = accountRepository.findAccountByAccountId(accountId);
        accountRepository.delete(account);
        String json = new Gson().toJson(account);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    }


    @Override //Login
    public Map<String,Object> userlogin(LoginIn loginIn) throws JsonProcessingException {
    	
        Login login = new Login();
        //logger.info("testA");
    	//Account account = accountRepository.checkLogin(loginIn);
    	//logger.info("testB");
        
       //Account account = new Account();
    	//Account account = accountRepository.checkLogin(username , password);
    	//if(username.equals(account.getUsername()) && password.equals(account.getPassword())) {
    	
    	//Insert user_login
        login.setUsername("user");
        login.setStatus_login("online");
        login.setToken(null);
        login.setDate(new Timestamp(System.currentTimeMillis()));
    	
        loginRepository.save(login);
        String json = new Gson().toJson(login);
        Map<String,Object> result = new ObjectMapper().readValue(json, HashMap.class);
        return result;
    	//}
    	
		//return null;
    	
		//return null;
 
   
    }
}