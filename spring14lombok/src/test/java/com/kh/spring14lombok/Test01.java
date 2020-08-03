package com.kh.spring14lombok;

import org.junit.Test;

import com.kh.spring14lombok.entity.MenuDto;

public class Test01 {
  
	@Test //Junit이라는 도구를 사용하여 테스팅이 가능하도록 설정 
	public void test() {
		MenuDto menuDto = new MenuDto();
		menuDto.setName("아메리카노");
		menuDto.setPrice(1500);
		
		System.out.println(menuDto.getName());
		System.out.println(menuDto.getPrice());
        System.out.println("---------------------------");
		System.out.println(menuDto.toString());
		System.out.println(menuDto);
		
		
		MenuDto b = new MenuDto("양념통닭",1000);
		System.out.println(b);
	
		//builder 패턴으로 객체 생성 
	MenuDto c = MenuDto.builder()
			.name("간장치킨")
			.price(10000)
			.build();
			
		System.out.println(c);
		
	}
	
	
}
