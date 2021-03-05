package com.yedam.board.service;

import java.util.List;

import com.yedam.emp.CommentsVO;

public interface CommentService {
	// 삽입
	public int insertComments(CommentsVO vo);

	// 삭제
	public int deleteComments(CommentsVO vo);

	// 단건 조회
	public CommentsVO getComments(CommentsVO vo);

	// 전체 조회
	public List<CommentsVO> getSearchComments(CommentsVO vo);
}
