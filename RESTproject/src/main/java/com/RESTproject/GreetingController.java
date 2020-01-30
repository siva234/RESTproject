package com.RESTproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingservice;
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "id",required = false) Integer idParam ,
							@RequestParam(value = "account", required = false) String accountParam,
							@RequestParam(value = "type", required = false) String typeParam) throws Exception {
	
	Integer id = idParam;
	String account = accountParam;
	String type = typeParam;
	String resultString = greetingservice.greetingParamsLogic(id, account, type);
			
	return new Greeting(resultString);
	}
}
