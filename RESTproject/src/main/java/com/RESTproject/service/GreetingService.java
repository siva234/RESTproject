package com.RESTproject.service;

import com.RESTproject.pojo.APIException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {



	public ResponseEntity validateGreetingParams(Integer id, String account, String type){
		Object resultString=null;
		if(account.equals("personal") && id>=0)
		{
			log.info("Path of Id= %d, Account= %s ", id, account);
			resultString = "Hi, userId "+id;
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(resultString);
			return ResponseEntity.ok(mappingJacksonValue);
		}
		if(account.equals("business") && type.equals("big"))
		{
			log.info("Path of Account= %s, Type= %s ", account, type);
			resultString = "Welcome, "+account+" user!";
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(resultString);
			return ResponseEntity.ok(mappingJacksonValue);
		}
		if(account.equals("business") && type.equals("small"))
		{
			log.info("Unimplemetned Path Account= %s, Type= %s ", account, type);
			MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new APIException(HttpStatus.BAD_REQUEST, "This path has not yet been implemented."));
			return  new ResponseEntity(mappingJacksonValue,HttpStatus.BAD_REQUEST);
		}
		log.info("Wrong inputs received Id= %d, Account= %s, Type= %s ", id, account, type);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Please check if you gave the right inputs"));
		return  new ResponseEntity(mappingJacksonValue,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}