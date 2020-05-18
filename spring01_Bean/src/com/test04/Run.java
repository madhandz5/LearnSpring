package com.test04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test04/beans.xml");
		AbstractTest today = factory.getBean("factoryMethod",AbstractTest.class);
		System.out.println(today.dayInfo());
		
	}

}
