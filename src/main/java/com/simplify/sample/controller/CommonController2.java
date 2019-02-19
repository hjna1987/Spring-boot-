package com.simplify.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  
public class CommonController2 {
	
	/*
	 *   @RestController annotation을 붙여주면 그대로 Restful API 를 사용하는 Controller 가 되고,
	 *   따라서 각 Request Mapping 에 적어준 url 이 호출될 때 마다 Return 으로 적어준 내용이 반환된다.
	 *   여기서는 String 으로 return 해 주므로, 그대로 내용이 보이고, 
	 *   만약 method 에 return 이 List<String> 과 같은 형태라면 json 배열 형태의 내용이 화면에 보일 것이다. 
	 *   이 부분은 Response body 를 알아서 handle해 주는 것이 Spring에 포함되어 있다. 
	 *   또한 String 앞에 @ResponseBody 를 명시하지 않아도 정상 동작하는 이유는 @RestController 에 @ResponseBody 가 포함되어 있기 때문이다. 
	 *   이 부분은 다음으로 설명할 @Controller 에서는 반드시 명시해주어야 하는 것과 일맥하여 중요하게 알아 두어야 할 부분이다. 
	 *   (즉, @Controller 에서는 일반 String 을 return 하기 위해서(ajax 에 대한 응답)는 반드시 @ResponseBody 를 적어 주어야 한다)
	 */
	
	@RequestMapping("/")
	public String root_test() throws Exception{
		return "Hello Root(/)";
	}
	
	@RequestMapping("/demo")
	public String demo_text() throws Exception{
		return "Hello Demo(/)";
	}

}
