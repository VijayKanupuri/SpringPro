package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
public class UserBean {

	@Bean(name="user")
	@Scope(value="prototype")
	public User user() {
		return new User();
	}
	
}
