package com.example.rest.controller;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

public class HelloControllerTest {
	MockHttpServletRequest request;
	MockHttpServletResponse response;
	HelloController controller;
	RequestMappingHandlerAdapter adapter;
	HelloInterface myInterface;
	
	@Before
	public void setUp() {
        myInterface = EasyMock.createMock(HelloInterface.class);
  
		controller = new HelloController();
		adapter = new RequestMappingHandlerAdapter();
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
	}
	@Test
	public void testHello() throws Exception {
		request.setRequestURI("/hello");		
		request.addParameter("name", "Denis");
		ModelAndView myModel = controller.handleRequestInternal(request, response);
		
		int status = response.getStatus();
		if( status != 200 ){
			fail("Status was not 200");
		}
		String myName = (String) myModel.getModel().get("name");
		System.out.println("name=" + myName);
		if( myName == null || myName.isEmpty() || myName.equals("Denis") == false ){
			fail("The parameter name has an invalid value.");
		}
	}

}
