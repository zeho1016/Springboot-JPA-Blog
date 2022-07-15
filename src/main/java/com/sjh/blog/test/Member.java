package com.sjh.blog.test;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // getter setter
//@AllArgsConstructor // 생성자
@NoArgsConstructor //빈 생성자
public class Member {
	private  int id;   
	private  String userName; 
	private  String password;
	private  String email;
	
	@Builder  
	public Member(int id, String userName, String password, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	 
	
}
