package com.kh.spring10.repository;

import java.util.List;

import com.kh.spring10.entity.MemberDto;

public interface MemberDao {
	//회원가입 기능 : MemberDto 이용해서 boolean을 얻어낸다
	boolean join(MemberDto memberDto);
	//로그인 기능
	boolean login(MemberDto memberDto);
	//단일조회 기능
	MemberDto get(String member_id);
	//회원목록 기능
	List<MemberDto> getList();
}
