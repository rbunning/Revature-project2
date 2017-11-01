package com.revature.aspect;
 
 import org.apache.log4j.Logger;
 import org.aspectj.lang.JoinPoint;
 import org.aspectj.lang.annotation.Aspect;
 import org.aspectj.lang.annotation.Before;
 import org.springframework.context.support.StaticApplicationContext;
 import org.springframework.stereotype.Component;
 
 @Aspect
 @Component
 public class AppAspect {
 
 	static Logger log;
 	
 	@Before("within(com.revature.dao.Dao+)")
 	public void adviseForAllDaoMethods(JoinPoint jp) {
 		log = Logger.getLogger(jp.getClass().getName());
 		log.info("Before the dao method: " + jp.getSignature().getName());
 	}
 	
 	@Before("within(com.revature.service.AppService)")
 	public void adviseForAllServiceMethods(JoinPoint jp) {
 		log = Logger.getLogger(jp.getClass().getName());
 		log.info("Before the dao method: " + jp.getSignature().getName());
 	}	
 }