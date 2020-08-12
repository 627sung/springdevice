package com.kh.spring24;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//목표 : Student 객체를 문자열로 변환
public class Test01 {

	@Test
	public void test() throws JsonProcessingException {
		Student stu = new Student();
		stu.setName("홍길동");
		stu.setScore(50);
		
		//jackson의 도구를 사용하여 변환
		ObjectMapper mapper = new ObjectMapper();
		String value = mapper.writeValueAsString(stu);
		System.out.println(value);
	}
	
}

