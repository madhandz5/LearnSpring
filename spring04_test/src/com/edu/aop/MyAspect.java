package com.edu.aop;

import org.aspectj.lang.JoinPoint;


public class MyAspect {

	public void before(JoinPoint join) {
		
		System.out.println("도형의 넓이를 구한다.");
	}


	public void after(JoinPoint join) {
		System.out.println("도형의 넓이를 출력한다.");
	}


}
