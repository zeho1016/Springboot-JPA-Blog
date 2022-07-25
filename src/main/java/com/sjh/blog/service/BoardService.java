package com.sjh.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.blog.model.Board;
import com.sjh.blog.model.User;
import com.sjh.blog.repository.BoardRepository;

// 스프링이 컴포넌트스캔을 통해 Bean에 등록해줌. IoC
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;
	
	@Transactional  
	public void 글수정(int id, Board requestBoard ) {
		 Board board = boardRepository.findById(id) 
				 .orElseThrow(()->{
						return new IllegalArgumentException("글 상세보기 : 아이디를 찾을 수 없습니다.");
					}); // 영속화
		 board.setTitle(requestBoard.getTitle());
		 board.setContent(requestBoard.getContent());
		 // 해당 함수 종료시 트랜잭션이 종료, 더티채킹- 자동 업데이트 됨. flush
	}
	
	@Transactional  
	public void 글쓰기(Board board, User user) {
		board.setCount(0);
		board.setUser(user);
		boardRepository.save(board);
	}
	
	@Transactional(readOnly=true)
	public Page<Board> 글목록(Pageable pageable){
		return boardRepository.findAll(pageable);	
	}
	
	public Board 글상세보기(int id) {
		return boardRepository.findById(id)
				.orElseThrow(()->{
					return new IllegalArgumentException("글 상세보기 : 아이디를 찾을 수 없습니다.");
				});
	}
	
	@Transactional
	public void 글삭제(int id) {
		boardRepository.deleteById(id);
	}
	
}
