package com.revature.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AppAspect {

	@Before("within(com.revature.dao.Dao+)")
	public void adviseForAllDaoMethods(JoinPoint jp) {
		System.out.println("before the dao method: " + jp.getSignature().getName());
	}
	
	@Before("within(com.revature.service.AppService)")
	public void adviseForAllServiceMethods(JoinPoint jp) {
		System.out.println("before the service method: " + jp.getSignature().getName());
	}
	
}
