package com.kh.spring10.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring10.entity.MemberDto;
import com.kh.spring10.repository.MemberDao;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("/join")
	public String join() {
		
//		return "/WEB-INF/views/member/join.jsp";
		return "member/join";
	}
	
	@PostMapping("/join")
	public String join(@ModelAttribute MemberDto memberDto) {
		boolean result = memberDao.join(memberDto);
		if(result) {
			return "redirect:join_finish";
		}
		else {
			return "redirect:join?error";
		}
	}
	
	@GetMapping("/join_finish")
	public String joinFinish() {
		return "member/join_finish";
	}
	
	@GetMapping("/login")
	public String login() {
//		return "/WEB-INF/views/member/login.jsp";
		return "member/login";
	}
	
	@PostMapping("/login")
	public String login(
			@ModelAttribute MemberDto memberDto,
			HttpSession session) {

		if(memberDao.login(memberDto)) {
			MemberDto find = memberDao.get(memberDto.getMember_id());
			session.setAttribute("userinfo", find);
			return "redirect:/";
		}
		//그 외의 모든 경우는 오류로 간주
		else {
			return "redirect:login?error";
		}
	}
}








