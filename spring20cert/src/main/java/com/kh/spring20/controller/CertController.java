package com.kh.spring20.controller;

import javax.print.DocFlavor.STRING;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.spring20.entity.CertDto;
import com.kh.spring20.repository.CertDao;
import com.kh.spring20.service.CertService;
import com.kh.spring20.service.EmailService;

@Controller
@RequestMapping("/cert")
public class CertController {

	@Autowired private CertDao certDao;
	@Autowired private CertService certService;
	@Autowired private EmailService emailService;
	
	@GetMapping("/input")
	public String input() {
		return "cert/input";
	}
	
	@PostMapping("/input")
	public String input(@RequestParam String email,
						HttpServletRequest request) {
		
		String ip = request.getRemoteAddr(); //ip구하기
		String secret = certService.generateCertification(ip);
		emailService.sendSimpleMessage(email, "[디지털세상으로가는 인증번호]", "인증번호:"+secret);
		return "redirect:check";
		
	}
		
		
	
	@GetMapping("/check")
	public String check() {
		return "cert/check";
	}
	
	
	@PostMapping("check")
	@ResponseBody()
	public String Check(@RequestParam String secret,
							HttpServletRequest request) {
		String ip = request.getRemoteAddr(); 
		
	boolean result =certDao.validate(CertDto.builder()
			.who(ip)
			.secret(secret)
			.build());
	return "result="+result;  //실제로는 redirect 하는 자리 
	} 
	
}
