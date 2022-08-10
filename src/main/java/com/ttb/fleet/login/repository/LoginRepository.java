package com.ttb.fleet.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ttb.fleet.login.entity.Account;
import com.ttb.fleet.login.entity.Login;
import com.ttb.fleet.login.login.dto.LoginIn;

@Repository
public interface LoginRepository extends JpaRepository<Login,Integer>{


	Login findLoginByLoginId(Integer loginId);

	Login findByUsername(String username);

}
