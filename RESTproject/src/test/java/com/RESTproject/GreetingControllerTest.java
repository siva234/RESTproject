package com.RESTproject;

import static org.assertj.core.api.Assertions.assertThat;

import com.RESTproject.pojo.APIException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

@SpringBootTest
public class GreetingControllerTest {

	@Autowired
	private GreetingController controller;

	@Test
	public void greetingTest() throws Exception {
		assertThat(this.controller.greet(123, "personal", "big")
				.equals(ResponseEntity.ok(new MappingJacksonValue("Hi, userId 123"))));

		assertThat(this.controller.greet(123, "business", "big")
				.equals(ResponseEntity.ok(new MappingJacksonValue("Welcome, business user!"))));

		assertThat(this.controller.greet(123, "business", "small")
				.equals(new ResponseEntity(new MappingJacksonValue(new APIException(HttpStatus.BAD_REQUEST, "This path has not yet been implemented.")),HttpStatus.BAD_REQUEST)));

		assertThat(this.controller.greet(123, "personal", "small")
				.equals(new ResponseEntity(new MappingJacksonValue(new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Please check if you gave the right inputs")),HttpStatus.INTERNAL_SERVER_ERROR)));

	}
}
