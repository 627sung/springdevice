package com.kh.spring25.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	@GetMapping("/join")
	public String join() {
		return "student/join";
	}

	@GetMapping("/join2")
	public String join2() {
		return "student/join2";
	}
	
	
	
	@GetMapping("/list")
	public String list() {
		return "student/list";
	}
	
	@GetMapping("/list2")
	public String list2() {
		return "student/list2";
	}
	
	
	
	@GetMapping("/search")
	public String search() {
		return "student/search";
	}
	
	
	
	
	
}
