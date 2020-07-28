package com.kh.spring10home.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10home.entity.MemberDto;

@Controller
@RequestMapping("/member")
public class MemberController {
   @Autowired SqlSession sqlSession;
	
	@GetMapping("/join")
   public String join() {
	  return "member/join"; 
	   
   }
	
   @PostMapping("/join")
   public String join(@ModelAttribute MemberDto memberDto) {
	   
	   MemberDto find =sqlSession.selectOne("member.get", memberDto.getMember_id());
	   
	   if(find ==null) {
	   sqlSession.insert("member.join",memberDto );
	   
	   return "redirect:join_finish";
	   }else {
		 return "redirect:join?error";

	   }
	   
   }
	   
	 @GetMapping("/join_finish")
	 public String join_finish() {
		return "member/join_finish";
		
	 }
	   
	   
	   
   
   
   @GetMapping("/list")
   public String list(Model model) {
	
	  List<MemberDto> list = sqlSession.selectList("member.select");
	  model.addAttribute("list",list);
	   
	  
	   return "member/list";
	   
	   
	   
	   
   }
   
   
   
   
}
