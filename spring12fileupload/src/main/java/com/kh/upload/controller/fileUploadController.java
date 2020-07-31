package com.kh.upload.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kh.upload.vo.uplaodVo;

@Controller
@RequestMapping("/file")
public class fileUploadController {
//방식 1 : @reqparameter 이용 파일 단 1개 수신 
	@GetMapping("/upload")
	public String upload() {
		return "file/upload";
	}
//	@PostMapping("/upload")
//	public String upload(
//			@RequestParam String uploader,
//			@RequestParam MultipartFile f) {
//		System.out.println("uploader="+uploader);
//		System.out.println("f="+f);
//		System.out.println("파일이 있나여?"+ !f.isEmpty());
//
//		
//		return "redirect:upload";
//	}
	
	
	 // @RequestMapping 을 이용하여서 파일 여러개를 수신합니다..
	
	/*
	 * @PostMapping("/upload") public String upload(
	 * 
	 * @RequestParam String uploader,
	 * 
	 * @RequestParam List<MultipartFile>f ) {
	 * System.out.println("uploader="+uploader); System.out.println("f="+f);
	 * System.out.println("파일이 있나여?"+ !f.isEmpty());
	 * System.out.println("f="+f.size());
	 * 
	 * return"redirect:upload"; }
	 */

	//방식 3 @모델어트리뷰트 사용하여 수신 
	
	@PostMapping("/upload")
	public String upload(@ModelAttribute uplaodVo uploadvo) throws IllegalStateException, IOException {
		System.out.println(uploadvo.getUploader());
		System.out.println(uploadvo.getF().size());

	//전달된 파일의 정보를 불러와서 저장
	//파일 실체는 하드디스크에 저장 정보는 db에 저장
	
	if(uploadvo.isFileExist()) {
		//정보 추출 및 저장
	}
	
		for(MultipartFile file : uploadvo.getF()) {
			System.out.println("이름"+file.getOriginalFilename());
			System.out.println("크기"+file.getSize());
			System.out.println("유형"+file.getContentType());
			
			//대상을 지정하여 내보내기(저장)
			File target  =new File("D:/upload",file.getOriginalFilename());
			file.transferTo(target);
		}
	
		return "redirect:upload";
	
}

}




