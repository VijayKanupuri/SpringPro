package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextHandler implements ApplicationContextAware {

	public static ApplicationContext applicationContext;
	@SuppressWarnings("static-access")
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public  static <T> T getBean(String name,Class<T> aClass){
        return applicationContext.getBean(name,aClass);
    }
	
	public static ApplicationContext getContext() {
		return applicationContext;
	}

}