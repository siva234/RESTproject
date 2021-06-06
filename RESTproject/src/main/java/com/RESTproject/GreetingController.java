package com.RESTproject;

import com.RESTproject.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.constraints.Min;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingservice;
	
	@GetMapping("/greeting")
	@Validated
	public ResponseEntity greet(@RequestParam(value = "id",required = false) @Min(value=0, message="Id must be a positive integer") Integer idParam ,
								@RequestParam(value = "account", required = false) String accountParam,
								@RequestParam(value = "type", required = false) String typeParam) throws Exception {
	
	Integer id = idParam;
	String account = accountParam;
	String type = typeParam;
		return greetingservice.validateGreetingParams(id, account, type);
	}
}