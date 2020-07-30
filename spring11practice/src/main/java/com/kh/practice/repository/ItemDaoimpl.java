package com.kh.practice.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.practice.entity.ItemDto;
@Repository
public class ItemDaoimpl implements ItemDao {
@Autowired SqlSession sqlSession;
	@Override
	public void insert(ItemDto itemDto) {
		sqlSession.insert("item.add",itemDto);
	}
	
	@Override
	public List<ItemDto> getlist() {
		List<ItemDto>list=sqlSession.selectList("item.getlist");
		
		return list;
	}

	

	}
	
	
	

