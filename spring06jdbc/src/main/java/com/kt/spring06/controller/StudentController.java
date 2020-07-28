package com.kt.spring06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student")
public class StudentController {
  @Autowired JdbcTemplate jdbpTemplate; 
	
	
	@GetMapping("/regist")
  public String regist() {
	return "student/regist";
	}
	
	@PostMapping("/regist")
	public String regist2(
			@RequestParam String name,
			@RequestParam int age,
			@RequestParam int score
		){
	String sql="insert into student values(?,?,?,sysdate)";
	Object[] param = {name,age,score};
	jdbpTemplate.update(sql,param);
		
		
		return "redirect:regist_result";
	}
	
	@GetMapping("/regist_result")
	public String regist_result() {
	  return "student/regist_result";
	}
		
	
	
	
	  
	  }
	
	
	
	

