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

	//Native Query
	//@Query(value = "select * from account u where u.username = ?1 " , nativeQuery = true) 
	//Account findUserByUsernameNative(String username);
	
	//function findBy 
	public Account findByUsername(String username);



}
