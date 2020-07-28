package com.kh.spring09.controller;

import java.awt.Menu;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring09.entity.MenuDto;

@Controller
@RequestMapping("/menu")
public class MenuController {
@Autowired SqlSession sqlSession;
@RequestMapping("/list")
public String getlist(Model model) {
	
	List<MenuDto>list =sqlSession.selectList("menu.getlist");
	model.addAttribute("getlist", list);
	
	return "menu/list";
	
}
	
}
