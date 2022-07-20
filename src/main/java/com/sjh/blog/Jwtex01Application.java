package com.sjh.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Jwtex01Application {


	    public static void main(String[] args) {
	        SpringApplication.run(Jwtex01Application.class, args);
	    }
}
