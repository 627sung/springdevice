package com.kh.spring13.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.spring13.entity.GallaryDto;
import com.kh.spring13.repository.GallaryDao;

@Controller
@RequestMapping("/gallary")
public class GallaryController {
	
	@Autowired
	private GallaryDao gallaryDao;
	
	@GetMapping("/add")
	public String add() {
//		return "/WEB-INF/views/gallary/add.jsp";
		return "gallary/add";
	}
	
	@PostMapping("/add")
	public String add(
				@RequestParam String title,
				@RequestParam String explain,
				@RequestParam MultipartFile file
			) throws IllegalStateException, IOException {
		GallaryDto gallaryDto = new GallaryDto();
		gallaryDto.setTitle(title);
		gallaryDto.setExplain(explain);
		gallaryDto.setFname(file.getOriginalFilename());
		gallaryDto.setFsize(file.getSize());
		gallaryDto.setFtype(file.getContentType());
		
		//gallaryDto를 등록 + 하드디스크에 저장
		int no = gallaryDao.add(gallaryDto);
		File target = new File("D:/upload", String.valueOf(no));
		file.transferTo(target);
		
		return "redirect:add";
	}
}







