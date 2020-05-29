package test05;

import org.springframework.stereotype.Component;

@Component
public class Woman implements Person{

	public String classWork() {
		System.out.println("컴퓨터를 켜서 오라클을 한다.");
		return "AOP";
	}
}
