package com.kh.spring10home.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10home.entity.MemberDto;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired SqlSession sqlSession;
     
	@GetMapping("/list")
	public String list(Model model) {
		List<MemberDto> list =sqlSession.selectList("member.select");
		model.addAttribute("memberlist", list);
		
		return "admin/list";
		
	} 
	
	
	
	
}
