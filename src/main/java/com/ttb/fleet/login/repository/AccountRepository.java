package com.ttb.fleet.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ttb.fleet.login.entity.Account;
import com.ttb.fleet.login.entity.Login;
import com.ttb.fleet.login.login.dto.LoginIn;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer>{

	Account findAccountByAccountId(Integer accountId);

	//Account checkLogin(String username, String password);

	//@Query(value = "select * from account where username = :username " ,nativeQuery = true) 
	//Account checkLogin(String username,String password);

	//Account checkLogin(LoginIn loginIn);

}
