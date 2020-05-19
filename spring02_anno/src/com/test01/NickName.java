package com.test01;

import org.springframework.stereotype.Component;

// Spring Annotation
// bean 과 관련된 정보를 설정할 수 있다.

// 설정 방법
// 1. CommonAnnotationBeanPostProcessor 클래스를 설정파일에 bean으로 등록
// 2. <context:annotation-config>태그를 사용
// @Autowired, @Required, @Resource, @PostConstructor
// @PreDestroy 등의 annotation을 자동 등록

// <context:component-scan base-package=""/>
// @Component, @Controller, @Service, @Repository 등

// <mvc:annotation-driven/>
// @RequestMapping, @Valid 등 Spring MVC와 관련된 Annotation을 자동등록

// @Component : 클래스 위에 선언, 해당 클래스를 자동으로 bean으로 등록
// @Controller : Spring MVC에서 컨트롤러로 인식이 된다. 작성할 경우 자동으로 bean으로 등록
// @Service : 역할 부여가 없기 때문에, 비지니스 클래스(Service)에 사
// @Repository : dao에 사용된다. Exception을 DataAccessException으로 전환
// 				Checked Exception -> runtime Exception

// @Autowired
// @Autowired annotation은 spring에서 의존관계를 자동으로설정할 때 사용
// 생성자, 필드, 메서드 세 곳에서 적용이 가능하다.
// 타입을 사용해서 매핑이 이루어진다. 따라서 해당 타입의 빈 객체가 없거나, 2개 이상이라면 예외가 발생한다.

// @Qualifier("name")
//Qualifier : 매핑이 type이 아니라 name으로 이루어지게 된다.
// by Type ->> by Name으로 전환된다.

@Component
public class NickName {

	public String toString() {
		return "teacher";
	}

}
