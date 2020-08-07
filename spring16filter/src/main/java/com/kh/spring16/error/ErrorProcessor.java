package com.kh.spring16.error;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

//오류 통합 처리 도구 
//@ControllerAdvice(basePackages = {"com.kh.spring16.controller"})
@ControllerAdvice(annotations = Controller.class)
public class ErrorProcessor {

	

	//@ExceptionHandler(ArithmeticException.class)
	public String handler1() {
		return "error/handler1";
	}
	
	//@ExceptionHandler(NumberFormatException.class)
	public String handler2() {
		return "error/handler2";
	}
	
	
	/*
	 * RuntimeException 실행중발생
	 *  IOException 파일전송 오류 통신오류
	 *   SQLException db오류 
	 *   위의 3개를 모아서 Exception처리
	 */
	
	
	@ExceptionHandler(Exception.class) 
	public String handler3(Exception ex) {
		ex.printStackTrace(); //ex를 찍어본다 
		return "error/handler2";
	}
	
	
	
}
