package com.kh.quiz.controller;

import java.util.List;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.quiz.entity.ItemDto;
import com.kh.quiz.repository.ItemDao;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemDao itemDao;

//홈 설정
	@GetMapping("/")
	public String home() {
		return "item/home";

	}

//상품등록
	@GetMapping("/add")
	public String add() {
		return "item/add";
	}

//상품등록(폼에서 전송)
	@PostMapping("/add")
	public String add(@ModelAttribute ItemDto itemDto) {
		itemDao.insert(itemDto);

		return "redirect:list";
	}
//상품리스트보기
	@GetMapping("/list")
	public String getlist(Model model,
			@RequestParam (required = false, defaultValue = "no")String col,
			@RequestParam (required = false, defaultValue = "asc")String order
			) {
		//데이터 불러다가 model에 첨부 
		List<ItemDto> list = itemDao.getlist(col,order);
		model.addAttribute("list", list);

		return "item/list";
	}

	@GetMapping("/detail/{no}")
	public String detail(@PathVariable int no, Model model) {
		ItemDto itemDto = itemDao.get(no);
		model.addAttribute("itemDto", itemDto);

//		return "/WEB-INF/views/item/detail.jsp";
		return "item/detail";
	}

	@GetMapping("/delete/{no}")
	public String delete(@PathVariable int no) {
		itemDao.delete(no);
		return "redirect:item/list";
		
	}
	
	
	
	
	
	
//	@GetMapping("/edit")
//	@PostMapping("/edit")
//	@GetMapping("/delete")

}
