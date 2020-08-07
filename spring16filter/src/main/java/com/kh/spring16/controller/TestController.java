package com.kh.spring16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.EqualsAndHashCode;

@Controller
@RequestMapping("/test")
public class TestController {

	
	//오류1 404 not found
	@GetMapping("/error1")
	public String error1() {
		return "hello";
	}
	
	//오류2 : 500 internal server error  (ex 아메리카노 시켰는데 커피머신이 터졌따.. 알바가 도망갔따 ->500에러임)
	
	@GetMapping("/error2")
	public String error2() {
		int a =10/0;   //int는 무한대 처리가 불가능 ->에러발생  500페이지 뜨면 프잘알들은 메세지보고 서버상태를 간파가능->보안이 구져짐
		return "hello";
	}
	
	
	//오류3 500에러
		@GetMapping("/error3")
		public String error3() {
			int a = Integer.parseInt("hello");// NumberFormatException
			return "hello";
		}
	
	
}




