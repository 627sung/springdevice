package com.kh.spring19.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring19.service.EmailService;

@Controller
@RequestMapping("/email")
public class EmailController {

	
	@Autowired 
	private EmailService emailService;
	
	@GetMapping("/test")
	public String test1() {
		return "email/test";
	}
	
	
	@PostMapping("/test")
		public String test1(
				@RequestParam String email,
				@RequestParam String title,
				@RequestParam String text
				) {
			emailService.sendSimpleMessage(email,title,text);
			return "redirect:test";
		}
	
	
	
	
}
