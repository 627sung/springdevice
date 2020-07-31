package com.kh.upload.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//VO =value object 
public class uplaodVo {
	private String uploader;
	private List<MultipartFile> f;

	public String getUploader() {
		return uploader;
	}

	public void setUploader(String uploader) {
		this.uploader = uploader;
	}

	public List<MultipartFile> getF() {
		return f;
	}

	public void setF(List<MultipartFile> f) {
		this.f = f;
	}

	// 파일 유무를 반환하는 메소드
	public boolean isFileExist() {
		if (f == null)
			return false;

		if (f.size() < 1)
			return false;

		if (f.get(0).isEmpty())
			return false;

		return true;

	}

}