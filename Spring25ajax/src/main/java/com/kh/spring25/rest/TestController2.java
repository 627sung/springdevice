package com.kh.spring25.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/exam")
public class TestController2 {

	@GetMapping("/test")
	public String test1() {
		return "they cant shot korean~";
		
	}
	
	@GetMapping("/herolist")
		public List<String> array() {
			List<String> hero = new ArrayList<>();
			hero.add("아이언맨");
			hero.add("토르");
			hero.add("블랙위도우");
			return hero;
	}
	
	@GetMapping("/menulist")
	public Map<String, Object> menulist(){
		Map<String, Object> menu = new HashMap<>();
		menu.put("name", "치킨");
		menu.put("price", "10000");
		return menu;

		
		
	}
	
	
	
	
	
}
