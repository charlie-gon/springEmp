package com.yedam.board.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.board.service.CommentService;
import com.yedam.emp.CommentsVO;

@RestController
public class CommentsController {
	
	@Autowired CommentService commentsService;
	
	// 등록처리
	@PostMapping("/comments")
	public CommentsVO insertCommentsProc(@RequestBody CommentsVO vo) {
		commentsService.insertComments(vo);
		if(vo.getId().equals("0")) {
			return vo;
		}else {
			return commentsService.getComments(vo);
		}
	}
	
	// 삭제
	@DeleteMapping(value = "/comments")
	public Map deleteCommentsProc(@RequestBody CommentsVO vo) {
		int r = commentsService.deleteComments(vo);
		System.out.println("==========================?" + r + "건 삭제");
		return Collections.singletonMap("cnt", r); // Map으로 리턴
	}
	
	// 해당 게시글 댓글 조회
	@GetMapping("/comments")
	public List<CommentsVO> getSearchComments(CommentsVO vo) {
		return commentsService.getSearchComments(vo);
	}
	
	// 단건 조회
	@GetMapping("/comments/{id}")
	public CommentsVO getComments(CommentsVO vo, @PathVariable String id) {
		vo.setId(id);
		return commentsService.getComments(vo);
	}
	
	// 수정
	@PutMapping("/comments")
	public CommentsVO updateCommentsProc(@RequestBody CommentsVO vo) {
		System.out.println("수정 확인 //// "+vo);
		return vo;
	}
}
