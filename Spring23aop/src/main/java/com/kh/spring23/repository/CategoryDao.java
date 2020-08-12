package com.kh.spring23.repository;

import java.util.List;

import com.kh.spring23.entity.CategoryDto;

public interface CategoryDao {
 void add(CategoryDto categoryDto);
 List<CategoryDto> getlist();
	
	
}
