package com.kh.spring10home.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring10home.entity.BoardDto;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	SqlSession sqlSession;

	@GetMapping("/list")
	public String getlist(Model model) {
		List<BoardDto> list = sqlSession.selectList("board.getlist");
		model.addAttribute("list", list);

		return "board/list";
	}
	
	@PostMapping("/search")
	public String search(
			@RequestParam String type,
			@RequestParam String keyword,
			Model model
			) {
		Map<String,String> param = new HashMap<>();
		param.put("type",type);
		param.put("keyword",keyword);
		List<BoardDto> list = sqlSession.selectList("board.search",param);
		model.addAttribute("list",list);
		return "board/list";
	}
	
	@RequestMapping("/union")
	public String union(
			@RequestParam(required = false) String type,
			@RequestParam(required = false) String keyword,
			Model model
			){
		
		Map<String, Object> map = new HashMap<>(); 
		
		map.put("type",type);
		map.put("keyword",keyword);
		
		List<BoardDto> list = sqlSession.selectList("board.unionList",map);
		model.addAttribute("list",list);

		
		
		
				return "board/list";
		
	}
	
}
