package com.RESTproject;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GreetingControllerTest {

	@Autowired
	private GreetingController controller;

	@Test
	public void contextLoads() throws Exception {
		assertThat(this.controller.greeting(123, "personal", "big").equals(new Greeting("Hi, userId 123")));
		assertThat(this.controller.greeting(123, "business", "big").equals(new Greeting("Welcome, business user!")));
		assertThat(this.controller.greeting(123, "business", "small").equals(new Greeting("This path has not yet been implemented.")));
	}
}
