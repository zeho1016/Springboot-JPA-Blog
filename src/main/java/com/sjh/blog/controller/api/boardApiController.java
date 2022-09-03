package com.sjh.blog.controller.api;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjh.blog.config.auth.PrincipalDetail;
import com.sjh.blog.dto.ReplySaveRequestDto;
import com.sjh.blog.dto.ResponseDto;
import com.sjh.blog.model.Board;
import com.sjh.blog.model.Reply;
import com.sjh.blog.service.BoardService;

@RestController
public class boardApiController {


	@Autowired
	private BoardService boardService;
	
	
	@PostMapping("/api/board")
	public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal) { 
		boardService.글쓰기(board, principal.getUser());
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); 
	}
	
	@DeleteMapping("/api/board/{id}")
	public ResponseDto<Integer> deleteById(@PathVariable int id) {
		boardService.글삭제(id);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); 
	}

	
	@PutMapping("/api/board/{id}")
	public ResponseDto<Integer> update(@PathVariable int id, @RequestBody Board board){
		boardService.글수정(id, board);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); 
	}

	// 데이터를 받을 때 컨트롤러에서 dto를 만들어서 받는게 좋다
	// dto 사용하지 않는 이유 
	@PostMapping("/api/board/{boardId}/reply")
	public ResponseDto<Integer> replySave(@RequestBody ReplySaveRequestDto replySaveRequestDto) { 
		
		boardService.댓글쓰기(replySaveRequestDto);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); 
	}
	
	@DeleteMapping("/api/board/{boardId}/reply/{replyId}")
	public ResponseDto<Integer> replyDelete(@PathVariable int replyId) { 
		boardService.댓글삭제(replyId);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); 
	}
}

