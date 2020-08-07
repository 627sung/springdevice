package com.kh.spring17;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;
// 이 클래스에서 Logging을 하고 싶을 경우 다음의 어노테이션 추가 
@Slf4j // lombok이 깔려있어서 이거만써도 ㅇㅋ
public class Test02 {

	@Test
	public void test() {
		//System.out.println("hello");
		log.debug("debug");
		log.info("info");
		log.warn("warn");
		log.error("error");


	}
	
	
	
}
