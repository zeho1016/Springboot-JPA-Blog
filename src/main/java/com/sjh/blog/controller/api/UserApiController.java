package com.sjh.blog.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	private UserService userService;
	
	@PostMapping("/auth/joinProc")
	public ResponseDto<Integer> save(@RequestBody User user) { 
			System.out.println("UserApiController: save호출됨");
			userService.회원가입(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); // 자바오브젝트를 JSON으로 변환해서 return
	}
	
	@PutMapping("/user")
	public ResponseDto<Integer> update (@RequestBody User user ){
		userService.회원수정(user);
		return new ResponseDto<Integer>(HttpStatus.OK.value() , 1); // 자바오브젝트를 JSON으로 변환해서 return
	}
	
}
