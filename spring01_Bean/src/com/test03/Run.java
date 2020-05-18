package com.test03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Run {
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test03/beans.xml");

		Adress lee = (Adress) factory.getBean("lee");
		Adress hong = (Adress) factory.getBean("hong");
		
	}

}
