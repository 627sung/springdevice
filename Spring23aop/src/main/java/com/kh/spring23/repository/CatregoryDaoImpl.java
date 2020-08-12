package com.kh.spring23.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring23.entity.CategoryDto;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class CatregoryDaoImpl implements CategoryDao{

	
	@Autowired private SqlSession sqlSession;

	@Override
	public void add(CategoryDto categoryDto) {
		sqlSession.insert("category.add", categoryDto);
	}

	@Override
	public List<CategoryDto> getlist() {
		
		
		return sqlSession.selectList("category.getList");
	}
}
