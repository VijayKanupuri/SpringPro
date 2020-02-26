package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Component
public class LoginInController {
	
	
	
	NotificationService nc;
	@Autowired
	public LoginInController(NotificationService nc) {
		this.nc=nc;
	}
	
	@RequestMapping({"/home"})
	public String home() {
		String hh="vj";
		int i=2;
//		UserBean ub = new UserBean();
		User u1=ApplicationContextHandler.getBean("user",User.class);
		u1.setUser("vijay");
		User u2=ApplicationContextHandler.getBean("user",User.class);
		u2.setUser("vija");
	
		
		String res=u1.getUser()+" -- "+u2.getUser();
		
		
//		if(true) {
//			System.out.print(nc.k);
//			return  nc.k+" "+nc.toStr()+" "+nc.i;					
//		}
		
		
		return res;
		
	}
}

