package com.kh.quiz.repository;

import java.util.List;

import com.kh.quiz.entity.ItemDto;

public interface ItemDao {

	void insert(ItemDto itemDto);

	List<ItemDto> getlist();

	List<ItemDto> getlist(String col, String order);

	ItemDto get(int no);

	

	void delete(int no);

	
	
}
