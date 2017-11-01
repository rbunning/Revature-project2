package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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

	@AfterReturning("within(com.revature.dao.Dao+)")
	public void adviseForAllDaoMethodsReturn(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The dao method: " + jp.getSignature().getName() + " returned successfully");
	}

	@AfterThrowing("within(com.revature.dao.Dao+)")
	public void adviseForAllDaoMethodsException(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The dao method: " + jp.getSignature().getName() + " threw an exception");
	}

	@Before("within(com.revature.service.AppService)")
	public void adviseForAllServiceMethods(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("Before the serivce method: " + jp.getSignature().getName());
	}

	@AfterReturning("within(com.revature.service.AppService)")
	public void adviseForAllServiceMethodsReturn(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The serivce method: " + jp.getSignature().getName() + " returned successfully");
	}

	@AfterThrowing("within(com.revature.service.AppService)")
	public void adviseForAllServiceMethodsException(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The serivce method: " + jp.getSignature().getName() + " threw an exception");
	}

	@Before("within(com.revature.controller.*)")
	public void adviseForAllControllerMethods(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("Before the controller method: " + jp.getSignature().getName());
	}

	@AfterReturning("within(com.revature.controller.*)")
	public void adviseForAllControllerMethodsReturn(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The controller method: " + jp.getSignature().getName() + " returned successfully");
	}

	@AfterThrowing("within(com.revature.controller.*)")
	public void adviseForAllControllerMethodsException(JoinPoint jp) {
		log = Logger.getLogger(jp.getClass().getName());
		log.info("The controller method: " + jp.getSignature().getName() + " threw an exception");
	}

}