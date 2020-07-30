package com.kh.spring10.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10.entity.MemberDto;
import com.kh.spring10.repository.MemberDao;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberDto> list = memberDao.getList();
		model.addAttribute("list", list);
		
//		return "/WEB-INF/views/admin/list.jsp";
		return "admin/list";
	}
	
}






