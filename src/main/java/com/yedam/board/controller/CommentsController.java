package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.CommentService;
import com.yedam.emp.CommentsVO;

@RestController
public class CommentsController {
	
	@Autowired CommentService commentsService;
	
	// 등록처리
	@PostMapping("/insertComments")
	public CommentsVO insertCommentsProc(CommentsVO vo) {
		commentsService.insertComments(vo);
		return commentsService.getComments(vo);
	}
	
	// 삭제
	@RequestMapping("/deleteComments")
	public Map<String, Integer> deleteCommentsProc(CommentsVO vo) {
		int r = commentsService.deleteComments(vo);
		//return r; // 삭제 유무에 따라 1,0 반환
		return Collections.singletonMap("cnt", r); // Map으로 리턴
	}
	
	// 해당 게시글 댓글 조회
	@RequestMapping("/getSearchComments")
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentsService.getSearchComments(vo);
	}
	
	// 단건 조회
	@RequestMapping("/getComments")
	public CommentsVO getComments(CommentsVO vo) {
		return commentsService.getComments(vo);
	}
}
