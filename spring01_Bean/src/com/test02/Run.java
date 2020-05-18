package com.test02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test02/beans.xml");
		MessageBean banana = (MessageBean) factory.getBean("banana");
		System.out.println(banana);
		MessageBean apple = (MessageBean) factory.getBean("apple");
		System.out.println(apple);

		MessageBean mango = (MessageBean) factory.getBean("mango");
		System.out.println(banana);

	}

}
