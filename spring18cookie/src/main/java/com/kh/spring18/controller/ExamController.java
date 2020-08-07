package com.kh.spring18.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam")
public class ExamController {

	
	@GetMapping("/sign-in")
	public String sign_in() {
		return "exam/sign-in";
	} 
	
	@GetMapping("/ad")
	public String adn() {
		return "exam/ad";
	}
	
}
