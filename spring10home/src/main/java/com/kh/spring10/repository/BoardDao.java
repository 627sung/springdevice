package com.kh.spring10.repository;

import com.kh.spring10.entity.BoardDto;

public interface BoardDao {
	//글 등록 기능
	// - 필요데이터 : BoardDto
	// - 결과데이터 : 게시글 번호(int)
	public int write(BoardDto boardDto);
	


	BoardDto get(int board_no);
	BoardDto read(int board_no);
}
