package com.kh.spring18.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
@RequestMapping("/cookie")
public class CookieController {

	@GetMapping("/create")
	public String create(HttpServletResponse response) {
		// 쿠키는 객체를 생성한 다음 응답정보(HttpServletResponse response)에 첨부해야 완전히 생성된다.
		// - name, value는 필수 expire 등은 선택
		// -쿠키는 name과 value가 모두 문자열만 가능(아스키코드만)

		Cookie ck = new Cookie("test", "khacademy");
		ck.setMaxAge(1 * 24 * 60 * 60); // 하루 만료시간 설정
		// ck.setMaxAge(10); //만료시간 설정

		response.addCookie(ck);
		return "cookie/create";

	}

	@GetMapping("/delete")
	public String delete(HttpServletResponse response) {
		// 쿠키 삭제는 명령이 따로 없다.. ck.setMaxAge(0) 0초로 설정후 덮어쓰기한다 .
		Cookie ck = new Cookie("test", "khacademy");
		ck.setMaxAge(0);
		response.addCookie(ck);
		return "cookie/delete";

	}

	@GetMapping("/list1")
	public String list1() {
		return "cookie/list1";
	}
	  //@CookieValue는 쿠키를 찾아주는 어노테이션 
	// 기본값이 필수 이므로 필수가 아닌 경우는 따로 옵션을 설정 
	@GetMapping("/list2")
	@ResponseBody //return의 글자를 반환해서 보여주겠다 
	public String list2(
			@CookieValue(required = false) Cookie test
			) {
		if(test != null) {
		log.debug(test.getValue());		// test라는 이름의 쿠키의 밸류를 찍어보자

		} else {
			log.debug("쿠키없음");
		}
		return "list2";
	}

}
