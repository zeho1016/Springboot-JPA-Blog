package com.sjh.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.blog.dto.ReplySaveRequestDto;
import com.sjh.blog.model.Board;
import com.sjh.blog.model.Reply;
import com.sjh.blog.model.User;
import com.sjh.blog.repository.BoardRepository;
import com.sjh.blog.repository.ReplyRepository;
import com.sjh.blog.repository.UserRepository;

// 스프링이 컴포넌트스캔을 통해 Bean에 등록해줌. IoC
@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReplyRepository replyRepository;

	@Transactional
	public void 글수정(int id, Board requestBoard) {
		Board board = boardRepository.findById(id).orElseThrow(() -> {
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

	@Transactional(readOnly = true)
	public Page<Board> 글목록(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}

	public Board 글상세보기(int id) {
		return boardRepository.findById(id).orElseThrow(() -> {
			return new IllegalArgumentException("글 상세보기 : 아이디를 찾을 수 없습니다.");
		});
	}

	@Transactional
	public void 글삭제(int id) {
		boardRepository.deleteById(id);
	}


	/*
	 * @Transactional public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
	 * 
	 * Board board = boardRepository.findById(replySaveRequestDto.getBoardId())
	 * .orElseThrow(()->{ return new
	 * IllegalArgumentException("댓글쓰기 실패 : 유저 아이디를 찾을 수 없습니다."); }); // 영속화
	 * 
	 * User user = userRepository.findById(replySaveRequestDto.getUserId())
	 * .orElseThrow(()->{ return new
	 * IllegalArgumentException("댓글쓰기 실패 : 게시글 아이디를 찾을 수 없습니다."); }); // 영속화
	 * 
	 * // 빌더패턴 Reply reply = Reply.builder() .user(user) .board(board)
	 * .content(replySaveRequestDto.getContent()) .build();
	 * 
	 * Reply reply = new Reply(); reply.update(user, board,
	 * replySaveRequestDto.getContent());
	 * 
	 * replyRepository.save(reply); }
	 */

	@Transactional
	public void 댓글쓰기(ReplySaveRequestDto replySaveRequestDto) {
		replyRepository.mSave(replySaveRequestDto.getUserId(), replySaveRequestDto.getBoardId(), replySaveRequestDto.getContent());
	}
	@Transactional
	public void 댓글삭제(int replyId) {
		replyRepository.deleteById(replyId);
		
	}
}
