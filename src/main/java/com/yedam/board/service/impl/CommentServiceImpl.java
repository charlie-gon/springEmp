package com.yedam.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.board.service.CommentService;
import com.yedam.emp.CommentsVO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired CommentsMapper dao;

	@Override
	public int insertComments(CommentsVO vo) {
		return dao.insertComments(vo);
	}

	@Override
	public int deleteComments(CommentsVO vo) {
		return dao.deleteComments(vo);
	}

	@Override
	public CommentsVO getComments(CommentsVO vo) {
		return dao.getComments(vo);
	}

	@Override
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return dao.getSearchComments(vo);
	}

}
