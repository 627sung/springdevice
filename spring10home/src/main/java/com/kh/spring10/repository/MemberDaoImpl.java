package com.kh.spring10.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.kh.spring10.entity.MemberDto;

@Repository//영속성 작업을 처리하는 도구(DB, 파일)
public class MemberDaoImpl implements MemberDao{

	@Autowired
	private SqlSession sqlSession;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public boolean join(MemberDto memberDto) {
		//아이디에 해당하는 회원이 이미 있는지 조회
		// - 있으면 정보가 나오고 없으면 null
		MemberDto find = sqlSession.selectOne(
						"member.get", memberDto.getMember_id());
		
		if(find == null) {
			//가입 전에 비밀번호 암호화
			//encoder.encode(비밀번호) ---> 암호화된 비밀번호
			String enc = encoder.encode(memberDto.getMember_pw());
			memberDto.setMember_pw(enc);
			
			sqlSession.insert("member.join", memberDto);
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean login(MemberDto memberDto) {
//		[1] DB에서 해당 회원의 정보를 모두 불러온다
		MemberDto find = sqlSession.selectOne(
						"member.get", memberDto.getMember_id());
		if(find != null) {//아이디가 있으면
//			[2] 아이디가 있을 경우 비밀번호 비교를 수행한다(encoder 사용)
//			encoder.matches(입력 PW, DB PW) --> boolean
			boolean pass = encoder.matches(
					memberDto.getMember_pw(), find.getMember_pw());
			if(pass) {//비밀번호 일치
//				[3] 비밀번호도 맞을 경우 성공임을 반환
				return true;
			}
		}
		
		//그 외의 모든 경우는 실패임을 반환
		return false;
	}

	@Override
	public MemberDto get(String member_id) {
		MemberDto find = sqlSession.selectOne("member.get", member_id);
		return find;
	}

	@Override
	public List<MemberDto> getList() {
		List<MemberDto> list = sqlSession.selectList("member.getList");
		return list;
	}
	
}





