package com.sjh.blog.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sjh.blog.model.RoleType;
import com.sjh.blog.model.User;
import com.sjh.blog.repository.UserRepository;

// 스프링이 컴포넌트스캔을 통해 Bean에 등록해줌. IoC
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional  
	public void 회원가입(User user) {
		String rawPassword = user.getPassword();
		String encPassword = encoder.encode(rawPassword); // 해쉬
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}
	
	/*
	 * @Transactional(readOnly = true) // Select 할 때 트랜잭션 시작, 서비스 종료시 트랜잭션 종료 (정합성)
	 * public User 로그인(User user) { return
	 * userRepository.findByUsernameAndPassword(user.getUsername(),
	 * user.getPassword()); return
	 * userRepository.login(user.getUsername(),user.getPassword()); }
	 */
	@ Transactional
	public void 회원수정(User user) {
		// 수정 시 JPA 영속성 컨텍스트 User 오브젝트를 영속화시키고, 영속화된 User 오브젝트를 수정
		// select해서 User오브젝트를 DB에서 가져오는 이유 - 영속화
		// 영속화된 오브젝트를 변경하면 자동으로 update문을 전달
		User persistence = userRepository.findById(user.getId()).orElseThrow(()->{
			return new IllegalArgumentException("회원찾기 실패");
		});
		String rawPassword = user.getPassword();
		String encodePassword = encoder.encode(rawPassword);
		persistence.setPassword(encodePassword);
		persistence.setEmail(user.getEmail());
		// 회원 수정 함수 종료시 = 서비스 종료 = 트랜잭션 종료 = 자동커밋
		// 영속화된 persistence 객체의 변화가 감지되면 더티채킹이 되서 update문을 날려줌
	}
	
}
