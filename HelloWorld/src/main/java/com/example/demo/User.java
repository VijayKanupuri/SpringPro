package com.example.demo;

import javax.annotation.PostConstruct;

public class User {
		String name;

//		public User(String name) {
//			this.name=name;
//		}
		
		
		public void setUser(String name) {
			this.name=name;
		}
		
		public String getUser() {
			return name;
		}
		
		
		@PostConstruct
		public void pCon() {
			System.out.println("Post constrruct called");
			}
		
		public void preDes() {
			System.out.println("Prre Destroy called");
		}
	}
