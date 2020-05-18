package com.test01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test01/beans.xml");

		MessageBeanEn beanEn = (MessageBeanEn) factory.getBean("english");
		MessageBeanKo beanKo = (MessageBeanKo) factory.getBean("korean");

		beanEn.sayHello("Ryan");
		System.out.println(System.identityHashCode(beanEn));

		beanKo.sayHello("창영");
		System.out.println(System.identityHashCode(beanKo));

		MessageBeanEn beanEn2 = (MessageBeanEn) factory.getBean("english");
		MessageBeanKo beanKo2 = (MessageBeanKo) factory.getBean("korean");

		beanEn2.sayHello("오렌지");
		System.out.println(System.identityHashCode(beanEn2));

		beanKo2.sayHello("쥬스");
		System.out.println(System.identityHashCode(beanKo2));

	}

}
