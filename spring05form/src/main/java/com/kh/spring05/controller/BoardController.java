package com.kh.spring05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@GetMapping("/write")
	public String write() {
//		return "/WEB-INF/view/board/write.jsp";
		return "board/write";
	}
	
	@PostMapping("/write")
	public String write(
				@RequestParam(required = false, defaultValue = "자유") 
					String head,
				@RequestParam String title,
				@RequestParam String content
			) {
		System.out.println("head = " + head);
		System.out.println("title = " + title);
		System.out.println("content = " + content);
//		return "board/write_finish";
//		return "board/content";
//		return "redirect:/board/content";//절대경로로 redirect
		return "redirect:content";//상대경로로 redirect
	}
	
	@GetMapping("/content")
	public String content() {
		return "board/content";
	}
	
}



