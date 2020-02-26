package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
	String k="Hump";
	int i=1;
	
	public String toStr(){
		return "Notified";
	}
}

