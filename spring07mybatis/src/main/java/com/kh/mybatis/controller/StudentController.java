package com.kh.mybatis.controller;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.mybatis.entity.StudentDto;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired 
	private SqlSession sqlSession;
	
	
	@GetMapping("/regist")
	public String regist() {
		return "student/regist";
	}
	
	@PostMapping("/regist")
	public String regist(@ModelAttribute StudentDto studentDto ) {
	//데이터베이스 등록 =mybatis의 sqlsession을 활용하여 mapper 호출 및 실행 	
	//sqlSession.insert("구문이름","데이터")
	sqlSession.insert("student.regist",studentDto);
	
		
		
		return "redirect:regist";
	}
	
	
	
	
	
	
}
