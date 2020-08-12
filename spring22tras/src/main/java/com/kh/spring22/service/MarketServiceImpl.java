package com.kh.spring22.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring22.entity.CategoryDto;
import com.kh.spring22.entity.ProductDto;

@Service
public class MarketServiceImpl implements MarketService {

	@Autowired SqlSession sqlSession;
	@Transactional // 이 메소드는 단위작업으로 처리한다. 
	@Override
	public void add(CategoryDto categoryDto, ProductDto productDto) {
		
		
	}

}
