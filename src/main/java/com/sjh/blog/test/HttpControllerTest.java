package com.sjh.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> 응답(HTML파일)
// @Controller

// 사용자 요청 -> 응답(Data)
@RestController
public class HttpControllerTest {

	private static final String TAG = "HttpControllerTest: ";
	
	@GetMapping("/http/lombok")
	public  String lombokTest() {
		Member m =  Member.builder().userName("sar").password("1234").email("sat@naver.com").build();
		System.out.println(TAG +  "getter : " +  m.getUserName()) ;
		m.setUserName("sjh");
		System.out.println(TAG + "setter :" + m.getUserName());
		return "lombokTest 완료";
	}
	// 인터넷 브라우저 요청은 get요청밖에 할 수 없다.
	// http://localhost:8000/blog/http/get (select)
	@GetMapping("/http/get")
	public String getTest(Member m) {
		System.out.println(TAG +  "getter : " +  m.getId()) ;
		m.setId(500);
		System.out.println(TAG + "setter :" + m.getId());
		return "get요청 : " + m.getId() +  "," + m.getUserName() + "," + m.getPassword() + "," + m.getEmail() ;
	}
	
	// http://localhost:8080/http/post (insert)
	@PostMapping("/http/post") // text/plain, application/json
	public String postTest(@RequestBody Member m) { // messageConverter (스프링부트)
		return "post요청 : " + m.getId() + m.getUserName() + m.getPassword() + m.getEmail(); 
	}
	
	// http://localhost:8080/http/put (update)
	@PutMapping("/http/put")
	public String putTest(@RequestBody Member m) {
		return "put요청 : " + m.getId() + "," + m.getPassword();
	}
	
	// http://localhost:8080/http/delete (delete)
	@DeleteMapping("/http/delete")
	public String deleteTest() {
		return "delete요청";
	}
}
