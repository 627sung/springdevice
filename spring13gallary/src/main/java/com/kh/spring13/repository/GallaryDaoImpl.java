package com.kh.spring13.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring13.entity.GallaryDto;

@Repository
public class GallaryDaoImpl implements GallaryDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public int add(GallaryDto gallaryDto) {
		int no = sqlSession.selectOne("gallary.seq");
		gallaryDto.setNo(no);
		sqlSession.insert("gallary.add", gallaryDto);
		return no;
	}
	
}




