package com.simplify.sample.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simplify.sample.db.dto.Test;
import com.simplify.sample.db.service.TestService;

@Controller
public class TestController {
	
	@Autowired
	TestService testService;
	
	@RequestMapping("/query")
	public @ResponseBody List<Test> query() throws Exception{
		// 화면/jsp 등을 return 하는 것이 아니라면 반드시 @ResponseBody를 앞에 넣어 주어야 합니다.
		return testService.getAll();
	}

}
