package com.kh.spring03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
  //메소드를 만들어서 요청에 대한 처리내용을 작성한다 .
	// 메소드느 무조건 public으로 구현
//반환데이터는 반드시 연결될 주소가 포함 
	//매개변수는 있어도 되고 없어도 된다.
	// 이름은 마음대로 
	@RequestMapping(value= "/home")
	public String home() {
		return "/WEB-INF/views/home.jsp";
	}
	
	@RequestMapping(value = "/test")
   public String test() {
	   return "/WEB-INF/views/test.jsp";
   }
	
	@RequestMapping(value="/jyp")
	public String jyp(){
		return "/WEB-INF/views/jyp.jsp";
	}
	
	@RequestMapping(value="/twice")
	public String twice() {
		return "/WEB-INF/views/twice.jsp";
	}
	
	
	
}
