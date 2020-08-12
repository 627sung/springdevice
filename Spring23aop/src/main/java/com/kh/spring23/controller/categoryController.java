package com.kh.spring23.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.spring23.entity.CategoryDto;
import com.kh.spring23.repository.CategoryDao;

@Controller
@RequestMapping("/category")
public class categoryController {

	@Autowired 
	private CategoryDao categoryDao;

	@GetMapping("/add")
	public String add() {
		return "category/add";
	}
	
	@RequestMapping("/add")
	public String add(@ModelAttribute CategoryDto categoryDto) {
		categoryDao.add(categoryDto);
		
		return "redirect:add";
		
	}
	
	@GetMapping("/list")
	public String list(Model model) {
		List<CategoryDto> list = categoryDao.getlist();
		model.addAttribute("list",list);
		return "category/list";
		
	}

	
	
	
	
	
	
	
	
}
