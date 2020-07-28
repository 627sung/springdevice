package com.kh.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/multi")
public class multiController {
  
	@GetMapping("/test")
	public String test() {
		return "/multi/test";
	}
	
	@PostMapping("/test")
	public String test(@RequestParam String[] fruit) {
		 for(String f : fruit ) {
			 System.out.println("f="+f);
		 }
		
		
		return "redirect:test";
	}
	
	
	
	
}
