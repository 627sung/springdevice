package com.kh.spring22;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.kh.spring22.entity.CategoryDto;
import com.kh.spring22.entity.ProductDto;
import com.kh.spring22.service.MarketService;

//여기서 하려는 테스트는 "Spring을 연동시킨" 테스트
@RunWith(SpringJUnit4ClassRunner.class) // Spring과 JUnit4를 연동
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" }) // 설정파일 위치 정보
@WebAppConfiguration // 웹과 관련된 설정을 무시
public class Test02 {

	@Autowired
	MarketService marketService;

	@Test
	public void test() {
		CategoryDto categoryDto = CategoryDto.builder().category_no(2).category_name("과자").build();

		ProductDto productDto = ProductDto.builder().product_no(2).product_name("포카칩").category_no(2).build();

		marketService.add(categoryDto, productDto);

	}

}
