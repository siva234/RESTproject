package com.RESTproject;

import com.RESTproject.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GreetingControllerTest {

	@Autowired
	GreetingController greetingController;

	@MockBean
	GreetingService greetingService;

	@Test
	public void testGreetController() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		when(greetingService.validateGreetingParams(123,"personal","small")).thenReturn(ResponseEntity.ok("done"));

		ResponseEntity responseEntity =  greetingController.greet(123,"personal","small");

		assertEquals(responseEntity.getStatusCode().value(), 200);
		assertEquals(responseEntity.getBody(), "done");
	}
}
