
package com.RESTproject;

import com.RESTproject.service.GreetingService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class GreetingServiceTest {

        @Autowired
        GreetingService greetingService;

        @Test
        public void greetingStatusTest(){

            assertEquals(greetingService.validateGreetingParams(123, "personal", "big").getStatusCodeValue(),
                    200);

            assertEquals(greetingService.validateGreetingParams(123, "business", "big").getStatusCodeValue(),
                    200);

            assertEquals(greetingService.validateGreetingParams(123, "business", "small").getStatusCodeValue(),
                    400);

            assertEquals(greetingService.validateGreetingParams(-1, "personal", "small").getStatusCodeValue(),
                    500);

        }
        @Test
        public void greetingResponseBodyTest() throws JSONException {

            /*JSONAssert.assertEquals(ResponseEntity.ok(new MappingJacksonValue("Hi, userId 123")).getBody().toString(), greetingService.validateGreetingParams((Integer) 123, "personal", "small").getBody().toString(), false);

            JSONAssert.assertEquals(ResponseEntity.ok(new MappingJacksonValue("Welcome, business user!")).getBody().toString(), greetingService.validateGreetingParams(123, "business", "big").getBody().toString(), false);

             assertThat(greetingService.validateGreetingParams(123, "business", "big").getBody(),
                    ResponseEntity.ok(new MappingJacksonValue("Welcome, business user!")).getBody());

            assertEquals(greetingService.validateGreetingParams(123, "business", "big").getBody()
                    , (ResponseEntity.ok(new MappingJacksonValue("Welcome, business user!")).getBody()));

            assertEquals(greetingService.validateGreetingParams(123, "business", "small")
                    , (new ResponseEntity(new MappingJacksonValue(new APIException(HttpStatus.BAD_REQUEST, "This path has not yet been implemented.")),HttpStatus.BAD_REQUEST)));

            assertEquals(greetingService.validateGreetingParams(123, "personal", "small")
                    , (new ResponseEntity(new MappingJacksonValue(new APIException(HttpStatus.INTERNAL_SERVER_ERROR, "Please check if you gave the right inputs")),HttpStatus.INTERNAL_SERVER_ERROR)));*/

        }
    }