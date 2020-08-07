package com.kh.spring17;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test01 {

	//로깅 수행도구 생성 (Logger)-LoggerFactory로 생성 
	Logger logger = LoggerFactory.getLogger(Test01.class);
	
	
	@Test
	public void test() {
		//System.out.println("hello");
		logger.debug("debug");
		logger.info("info");
		logger.warn("warn");
		logger.error("error");


	}

	
}
