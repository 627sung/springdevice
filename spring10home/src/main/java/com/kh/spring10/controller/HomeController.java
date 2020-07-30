package com.kh.spring10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	//메인 페이지 처리
	@RequestMapping("/")
	public String root() {
		
//		return "/WEB-INF/views/root.jsp";
		return "root";
	}
}



