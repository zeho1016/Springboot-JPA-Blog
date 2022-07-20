package com.sjh.blog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sjh.blog.dto.ResponseDto;
import com.sjh.blog.model.User;
import com.sjh.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { 
			System.out.println("UserApiController: save호출됨");
			userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); // 자바오브젝트를 JSON으로 변환해서 return
	}
	
	/* CTRL + shift + /  한번에 주석처리
	 * @PostMapping("/api/user/login") public ResponseDto<Integer>
	 * login(@RequestBody User user, HttpSession session) {
	 * System.out.println("UserApiController: login호출됨"); User principal =
	 * userService.로그인(user); //principal = 접근주체
	 * 
	 * if(principal != null) { session.setAttribute("principal", principal); }
	 * 
	 * System.out.println("session"+principal); return new
	 * ResponseDto<Integer>(HttpStatus.OK.value() , 1); // 자바오브젝트를 JSON으로 변환해서
	 * return }
	 */
	
	
}
