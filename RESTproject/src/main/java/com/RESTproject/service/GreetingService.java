package com.RESTproject.service;

import com.RESTproject.pojo.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {



	public ResponseEntity validateGreetingParams(Integer id, String account, String type){
		Object resultString;

		if( id!=null && account.equals("personal") && id>0)
		{
			log.info("Path of Id= %d, Account= %s ", id, account);
			resultString = "Hi, userId "+id;

			return ResponseEntity.ok(resultString);
		}
		if(account.equals("business") && type.equals("big"))
		{
			log.info("Path of Account= %s, Type= %s ", account, type);
			resultString = "Welcome, "+account+" user!";

			return ResponseEntity.ok(resultString);
		}
		if(account.equals("business") && type.equals("small"))
		{
			log.info("Unimplemetned Path Account= %s, Type= %s ", account, type);
			return  new ResponseEntity(new APIException(HttpStatus.BAD_REQUEST, "This path has not yet been implemented."),HttpStatus.BAD_REQUEST);
		}
		log.info("Wrong inputs received Id= %d, Account= %s, Type= %s ", id, account, type);
		return  new ResponseEntity(new APIException(HttpStatus.BAD_REQUEST, "Please check if you gave the right inputs"), HttpStatus.BAD_REQUEST);
	}
}