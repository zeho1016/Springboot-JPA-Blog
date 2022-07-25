package com.sjh.blog.repository;


import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.sjh.blog.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

}
