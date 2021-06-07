
package com.RESTproject;

import com.RESTproject.pojo.APIException;
import com.RESTproject.service.GreetingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class GreetingServiceTest {

    @Autowired
    GreetingService greetingService;

    @Test
    public void verifyGreetingWithId123AndAccountPersonal(){

        assertEquals(200,
                greetingService.validateGreetingParams(123, "personal", "big").getStatusCodeValue());

        assertEquals("Hi, userId 123",
                greetingService.validateGreetingParams(123, "personal", "big").getBody());

    }
    @Test
    public void verifyGreetingWithAccountBusinessAndTypesmall(){

        assertEquals(400,
                greetingService.validateGreetingParams(123, "business", "small").getStatusCodeValue());

        assertEquals(new APIException(HttpStatus.BAD_REQUEST, "This path has not yet been implemented."),
                greetingService.validateGreetingParams(123, "business", "small").getBody());


    }

    @Test
    public void verifyGreetingWithAccountbusinessAndTypeBig(){

        assertEquals(200,
                greetingService.validateGreetingParams(123, "business", "big").getStatusCodeValue());

        assertEquals("Welcome, business user!",
                greetingService.validateGreetingParams(123, "business", "big").getBody());

    }

    @Test
    public void verifyGreetingWithIdNullAccountPersonalAndTypeSmall(){

        assertEquals(400,
                greetingService.validateGreetingParams(null, "personal", "small").getStatusCodeValue());

        assertEquals(new APIException(HttpStatus.BAD_REQUEST, "Please check if you gave the right inputs"),
                greetingService.validateGreetingParams(null, "personal", "small").getBody());

    }

}