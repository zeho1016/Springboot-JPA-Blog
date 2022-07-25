package com.sjh.blog.controller.api;


import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjh.blog.dto.ResponseDto;
import com.sjh.blog.model.User;
import com.sjh.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private AuthenticationManager authenticationManager; 
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { 
			System.out.println("UserApiController: save호출됨");
			userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); // 자바오브젝트를 JSON으로 변환해서 return
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update (@RequestBody User user){
		userService.회원수정(user);
		// 트랜잭션이 종료되기 때문에 DB에 값은 변경이 됨
		// but 세션값은 변경되지 않은 상태, 직접 세션값을 변경해줌
		//세션 등록
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); // 자바오브젝트를 JSON으로 변환해서 return
	}
	
}
