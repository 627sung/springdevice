package com.kh.quiz.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.quiz.entity.ItemDto;

@Repository
public class ItemDaoimpl implements ItemDao {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void insert(ItemDto itemDto) {
		sqlSession.insert("item.add", itemDto);

	}

	@Override
	public List<ItemDto> getlist() {
		//List<ItemDto> list = sqlSession.selectList("item.getlist");
		//return list;
		return sqlSession.selectList("item.getlist");

	}

	@Override
	public List<ItemDto> getlist(String col, String order) {
	Map<String, Object> map =new HashMap<>();
	map.put("col", col);
	map.put("order", order);
	
	List<ItemDto> list = sqlSession.selectList("item.getlist2", map);	
		
		return list;
	}

	@Override
	public ItemDto get(int no) {
		return sqlSession.selectOne("item.get", no);
		
	}

	@Override
	public void delete(int no) {
       		sqlSession.delete("item.del",no);
	}
	
	
	
	
	
	

}
