package com.test04;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect{

	//메서드 실행 전
	@Before("execution(public * *(..))")
	public void before(JoinPoint join) {
		System.out.println(join.getTarget().getClass());
		System.out.println(join.getSignature().getName());
		System.out.println("출석카드를 찍는다.");
	}

	//After
	@After("execution(public * test04.*.*(..))")
	public void after(JoinPoint join) {
		System.out.println("집에간다.");
	}
	
	
	
	
	
	
	

}
