package com.simplify.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller  
public class CommonController {
	
	/*
	 *  @Controller와 @RestController 의 비교
	 *  
	 *  Spring 개발에 있어서 일반적으로 사용하는 @Controller annotation 을 사용하게 되면 아래와 같은 부분을 주의해야 한다. 
	 *  아래 CommonController2 파일을 보면 /2 에 대해서는 String 을 return 하는데, 
	 *  이에 대한 response body 는 정의되어 있지 않고, /demo2에 대해서는 ResponseBody annotation이 붙어 있으므로 그 자체를 body 로 인식하고 return 한다. 
	 *  향후 ModelAndView를 사용하게 되면 @Controller를 주로 사용하게 될 것이고, 
	 *  하나의 Controller 안에 ModelAndView 를 return 하는 것과 Contents 자체를 return 하는 method 가 혼재하게 되면 
	 *  Contents 를 return 하는 method는 반드시 @ResponseBody 를 붙여서 ajax call 등에 대처해 주어야 한다.
	 *  
	 */
	
	@RequestMapping("/2")
	public String root_test() throws Exception {
		return "Hello Root(/2)";
	}
	
	@RequestMapping("/demo2")
	public @ResponseBody String demo_text() throws Exception {
		return "Hello Demo(/2)";
	}

}
