package com.kh.practice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.practice.entity.ItemDto;
import com.kh.practice.repository.ItemDao;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	ItemDao itemDao;

//등록페이지 이동
	@GetMapping("/add")
	public String add() {
		return "item/add";

	}

//등록페이지 (form 데이터받아옴 )
	@PostMapping("/add")
	public String add(@ModelAttribute ItemDto itemDto) {
		itemDao.insert(itemDto);

		return "redirect:add";
	}

	// 리스트를 뽑아줘요
	@GetMapping("/list")
	public String list(Model model) {
		List<ItemDto> list = itemDao.getlist();
		model.addAttribute("list", list);
		return "item/list";

	}

}
