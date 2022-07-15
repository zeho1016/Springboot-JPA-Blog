package com.sjh.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sjh.blog.model.User;

// DAO
// 자동으로 Bean등록 가능
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

}
