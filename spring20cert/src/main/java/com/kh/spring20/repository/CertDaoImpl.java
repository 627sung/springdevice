package com.kh.spring20.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kh.spring20.entity.CertDto;

@Repository
public class CertDaoImpl implements CertDao {

	
	@Autowired
 private SqlSession sqlSession;

	@Override
	public void insert(CertDto certDto) {
		sqlSession.insert("cert.regist",certDto);
	}

	@Override
	public boolean validate(CertDto certDto) {
		CertDto result = sqlSession.selectOne("cert.validate",certDto);
		if(result !=null)
		sqlSession.delete("cert.remove",result);
		return result !=null;//null 아니면 true리턴 그렇지안하면 false리턴 
	}

	@Override
	public void claerAll() {
		sqlSession.delete("cert.clear");
		
	}	


}
