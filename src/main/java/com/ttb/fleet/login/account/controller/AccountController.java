package com.ttb.fleet.login.account.controller;

import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ttb.fleet.login.account.dto.AccountIn;
import com.ttb.fleet.login.account.service.AccountService;
import com.ttb.fleet.login.common.dto.ApiStatusOut;
import com.ttb.fleet.login.common.dto.ResponseOut;
import com.ttb.fleet.login.common.utils.StopWatch;
import com.ttb.fleet.login.login.dto.LoginIn;



@RestController
@CrossOrigin
@RequestMapping("/api")
public class AccountController {
	
	@Autowired
	private AccountService accountService;
	
	private final Logger logger = LoggerFactory
			.getLogger(com.ttb.fleet.login.account.controller.AccountController.class);
	
	@PostMapping("/v1/account") //Create Account
	public ResponseEntity<ResponseOut> createAccount(@RequestHeader Map<String, String> headers,
			@RequestBody(required = false) AccountIn body) {
		StopWatch watch = new StopWatch();
		ObjectMapper mapper = new ObjectMapper();
		logger.info(String.format("CreateAccount Controller Request Header: %s", headers.keySet().stream()
				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
		ApiStatusOut apistatus = new ApiStatusOut();
		ResponseOut response = new ResponseOut();
		try {
			apistatus.setCode("S0000");
			apistatus.setBusinessMessage("Create Data Successful");
			apistatus.setDeveloperMessage("Success");
			response.setApiStatus(apistatus);
			response.setData((Map<String, Object>) accountService.create(body));
			logger.info(String.format("CreateAccount Controller Response: %s", mapper.writeValueAsString(response)));
			logger.info(String.format("CreateAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
			return ResponseEntity.status(HttpStatus.OK).body(response);
		} catch (Exception e) {
			apistatus.setCode("E5000");
			apistatus.setBusinessMessage("Service Not Available");
			apistatus.setDeveloperMessage(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
  @GetMapping("/v1/account/{account_id}") //Select
  public ResponseEntity<ResponseOut> readAccount(@RequestHeader Map<String, String> headers, @PathVariable int account_id) {
      StopWatch watch = new StopWatch();
      ObjectMapper mapper = new ObjectMapper();
      logger.info(String.format("ReadAccount Controller Request Header: %s", headers.keySet().stream()
              .map(key -> key + ":" + headers.get(key))
              .collect(Collectors.joining(", ", "{", "}"))));
      ApiStatusOut apistatus = new ApiStatusOut();
      ResponseOut response = new ResponseOut();
      try {
          Map data = (Map<String, Object>)  accountService.read(account_id);
          if(data == null){
              apistatus.setCode("E404");
              apistatus.setBusinessMessage("Data not found");
              apistatus.setDeveloperMessage("Data not found");
              response.setApiStatus(apistatus);
              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
          }
          apistatus.setCode("S0000");
          apistatus.setBusinessMessage("Query Data Successful");
          apistatus.setDeveloperMessage("Success");
          response.setApiStatus(apistatus);
          response.setData(data);
          logger.info(String.format("ReadAccount Controller Response: %s", mapper.writeValueAsString(response)));
          logger.info(String.format("ReadAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
          return ResponseEntity.status(HttpStatus.OK).body(response);
      } catch (Exception e) {
          apistatus.setCode("E5000");
          apistatus.setBusinessMessage("Service Not Available");
          apistatus.setDeveloperMessage(e.getMessage());
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
      }
      
  }
      @PutMapping("/v1/account") //Update message
  	 public ResponseEntity<ResponseOut> updateAccount(@RequestHeader Map<String, String> headers,
  			@RequestBody(required = false) AccountIn body) {
  		StopWatch watch = new StopWatch();
  		ObjectMapper mapper = new ObjectMapper();
  		logger.info(String.format("UpdateAccount Controller Request Header: %s", headers.keySet().stream()
  				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
  		ApiStatusOut apistatus = new ApiStatusOut();
  		ResponseOut response = new ResponseOut();
  		try {
  			Map data = (Map<String, Object>) accountService.update(body);
  			if (data == null) {
  				apistatus.setCode("E404");
  				apistatus.setBusinessMessage("Data not found");
  				apistatus.setDeveloperMessage("Data not found");
  				response.setApiStatus(apistatus);
  				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
  			}
  			apistatus.setCode("S0000");
  			apistatus.setBusinessMessage("Update Data Successful");
  			apistatus.setDeveloperMessage("Success");
  			response.setApiStatus(apistatus);
  			response.setData(data);
  			logger.info(String.format("UpdateAccount Controller Response: %s", mapper.writeValueAsString(response)));
  			logger.info(String.format("UpdateAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
  			return ResponseEntity.status(HttpStatus.OK).body(response);
  		} catch (Exception e) {
  			apistatus.setCode("E5000");
  			apistatus.setBusinessMessage("Service Not Available");
  			apistatus.setDeveloperMessage(e.getMessage());
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  		}
  	}

  	@DeleteMapping("/v1/account/{account_id}") //Delete message
  	public ResponseEntity<ResponseOut> deleteAccount(@RequestHeader Map<String, String> headers,
  			@PathVariable int account_id) {
  		StopWatch watch = new StopWatch();
  		ObjectMapper mapper = new ObjectMapper();
  		logger.info(String.format("DeleteAccount Controller Request Header: %s", headers.keySet().stream()
  				.map(key -> key + ":" + headers.get(key)).collect(Collectors.joining(", ", "{", "}"))));
  		ApiStatusOut apistatus = new ApiStatusOut();
  		ResponseOut response = new ResponseOut();
  		try {
  			apistatus.setCode("S0000");
  			apistatus.setBusinessMessage("Delete Data Successful");
  			apistatus.setDeveloperMessage("Success");
  			response.setApiStatus(apistatus);
  			response.setData((Map<String, Object>) accountService.delete(account_id));
  			logger.info(String.format("DeleteAccount Controller Response: %s", mapper.writeValueAsString(response)));
  			logger.info(String.format("DeleteAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
  			return ResponseEntity.status(HttpStatus.OK).body(response);
  		} catch (Exception e) {
  			apistatus.setCode("E5000");
  			apistatus.setBusinessMessage("Service Not Available");
  			apistatus.setDeveloperMessage(e.getMessage());
  			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
  		}
  	}
      
  	
	  @PostMapping("/v1/login")
	  public ResponseEntity<ResponseOut> AccessLogin(@RequestHeader Map<String, String> headers, 
			  @RequestBody(required = false) LoginIn body) {
	      StopWatch watch = new StopWatch();
	      ObjectMapper mapper = new ObjectMapper();
	      logger.info(String.format("ValidLogin Controller Request Header: %s", headers.keySet().stream()
	              .map(key -> key + ":" + headers.get(key))
	              .collect(Collectors.joining(", ", "{", "}"))));
	      
	      ApiStatusOut apistatus = new ApiStatusOut();
	      ResponseOut response = new ResponseOut();
	      logger.info("test");
	      try {
	    	  
	          Map data = (Map<String, Object>) 	accountService.userlogin(body);
	          if(data == null){
	              apistatus.setCode("E404");
	              apistatus.setBusinessMessage("Data not found");
	              apistatus.setDeveloperMessage("Data not found");
	              response.setApiStatus(apistatus);
	              return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	          }
	          
	          apistatus.setCode("S0000");
	          apistatus.setBusinessMessage("Login Successful");
	          apistatus.setDeveloperMessage("Success");
	          response.setApiStatus(apistatus);
	          response.setData(data);
	          logger.info(String.format("ReadAccount Controller Response: %s", mapper.writeValueAsString(response)));
	          logger.info(String.format("ReadAccount Controller elapse time %.4f seconds", watch.elapsedTime()));
	          return ResponseEntity.status(HttpStatus.OK).body(response);
	          
	      } catch (Exception e) {
	          apistatus.setCode("E5000");
	          apistatus.setBusinessMessage("Service Not Available");
	          apistatus.setDeveloperMessage(e.getMessage());
	          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
	      }
      
  }
  
}
  

