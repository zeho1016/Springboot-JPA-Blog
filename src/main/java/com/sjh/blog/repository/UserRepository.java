package com.sjh.blog.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;

import com.sjh.blog.model.User;

// DAO
// 자동으로 Bean등록 가능
//@Repository 생략가능
public interface UserRepository extends JpaRepository<User, Integer> {

	// SELECT * FROMuser WHERE username=1?;
	Optional<User> findByUsername(String username);
}
	// JPA Naming전략
	// select * from user where username = ? and password = ?
	//User findByUsernameAndPassword(String username, String password);
	
	// 위와 같음 
	//@Query(value="SELECT * FROM user WHERE username=?1 AND 	password=?2", nativeQuery= true)
	//User login(String username, String password);
	
