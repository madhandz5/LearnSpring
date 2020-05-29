package test05;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
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
	@After("execution(public * test05.*.*(..))")
	public void after(JoinPoint join) {
		System.out.println("집에간다.");
	}
	
	//예외를 던지고 난 후
	@AfterThrowing("execution(public * test05.*.*(..))")
	public void throwing(JoinPoint join) {
		System.out.println("쉬는 날이었다.");
	}
	
	//만약에 리턴 값이 있다면, 리턴을 하고나서, 리턴값을 받아서 사용할 수 있다.
	@AfterReturning(pointcut="execution(public * test05.*.*(..))",returning="returnVal")
	public void returning(JoinPoint join, Object returnVal) {
		System.out.println(returnVal + " 공부 중입니다.");
	}
	
	
	
	
	
	
	
	
	
	
	

}
