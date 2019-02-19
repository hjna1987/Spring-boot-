package com.simplify.sample.jsp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JspController {

	@RequestMapping("/jsp")
	public String jsp() throws Exception{
		// 정상동작 :http://localhost:8080/jsp
		// SpringBootSample/src/main/webapp/WEB-INF/jsp/main.jsp 이 return 됨.
		
		return "main";
	}
	@RequestMapping("/abcd")
	public String abcd() throws Exception{
		// 에러 :  http://localhost:8080/abcd
		// return string 은 이제 더 이상 string으로서의 의미를 갖지 못하고 경로 안의 특정 값일 뿐입니다. 
		// 모든 return 에 대해서 prefix와 suffix 를 주게 되어 더 이상 이전처럼 값을 return 할 수 없는 상황이 됩니다. 

		return "abcd";
	}
	
	@RequestMapping("/abcd2")
	public @ResponseBody String abcd2() throws Exception{
		// 정상동작 :http://localhost:8080/abcd2
		// 데이터 형태로 return 받고 싶다면 @ResponseBody 를 반드시 명시해야함
		return "abcd2";
	}
	
	@RequestMapping("/mav")
	public ModelAndView mav() throws Exception{
		//5. Model And View 로 이용하기
		ModelAndView mav = new ModelAndView("mavSample");
		
		mav.addObject( "key","fruits" );
		
		List<String> fruitList = new ArrayList<String>();
		fruitList.add("apple");
		fruitList.add("orange");
		fruitList.add("apple");
		
		mav.addObject("value", fruitList);
		
		return mav;
	}
}
