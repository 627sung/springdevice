package com.kh.spring14lombok;

import org.junit.Test;

import com.kh.spring14lombok.entity.MenuDto;
import com.kh.spring14lombok.entity.StudentDto;
import com.kh.spring14lombok.entity.StudentDto.StudentDtoBuilder;

public class Test02 {

	
	@Test
	public void test() {
		//빌더패턴

		StudentDto s = StudentDto.builder()
				.name("손오공").age(40).score(20).when("2020-12-31").build();
		
	System.out.println(s);	
		System.out.println("--------------------------");
	
		
		
	StudentDto sd = new StudentDto("유재석",40,80,"2020-08-03");
	System.out.println(sd);

	
	
	
	
	
	
		
	}
	
	
}
