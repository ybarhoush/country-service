package com.example.countryservice;

import com.example.countryservice.services.CountryWebService;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CountryWebControllerTest {

	@Autowired
    CountryWebControllerTest countryWebController;

	//https://docs.spring.io/spring-framework/docs/current/reference/html/testing.html#integration-testing
	/* 	As stated in the Spring Reference Manual,
    	The Spring MVC Test framework provides first class support for testing Spring MVC 
		code using a fluent API that can be used with JUnit, TestNG, or any other testing framework. 
		Itâ€™s built on the Servlet API mock objects from the spring-test module and hence does not 
		use a running Servlet container.
		The last sentence spells it out: Spring MVC Test does not use a running Servlet container.
		In fact, it cannot be used with a running Servlet container or any kind of actual server (local or remote).
		As an alternative, if you must test against an external server, you could then consider using REST Assured
		instead of Spring MVC Test for those special cases.
 */

}