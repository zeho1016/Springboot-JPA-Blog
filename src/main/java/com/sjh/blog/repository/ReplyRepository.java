package com.sjh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.blog.dto.ReplySaveRequestDto;
import com.sjh.blog.model.Reply;

public interface ReplyRepository extends JpaRepository<Reply, Integer> {

	@Modifying
	@Query(value="INSERT INTO reply(userId, boardId, content, createDate) VALUES(?1, ?2, ?3, now())", nativeQuery = true)
	int mSave(int userId, int boardId, String content); // 업데이트된 행의 개수 리턴해줌 
}
