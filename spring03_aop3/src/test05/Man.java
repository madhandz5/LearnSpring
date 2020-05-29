package test05;
import org.springframework.stereotype.Component;

@Component
public class Man implements Person{

	public String classWork() {
		System.out.println("컴퓨터를 켜서 자바를 한다.");
		return "스프링";
	}
}

