package com.RESTproject;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
	
	public GreetingService() {
		
	}
	
	public String greetingParamsLogic(Integer id,String account,String type) throws Exception {
		if(account.equals("personal") && (id == 123))
		{
				return "Hi, userId "+id;
		}
		else if(account.equals("business") && type.equals("big"))
		{
				return "Welcome, "+account+" user!";
		}
		else
		{
			throw new Exception("This path has not yet been implemented.");		
		}
	}
}
