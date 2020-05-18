package com.test05prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MTest {
	
	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext("com/test05prac/beans.xml");
		
		
		TV lgTv = (TV)factory.getBean("lg");
		lgTv.powerOn();
		lgTv.volumeDown();
		lgTv.volumeUp();
		lgTv.powerOff();
		System.out.println("===================");
		TV samsungTv = (TV) factory.getBean("samsung");
		samsungTv.powerOn();
		samsungTv.volumeDown();
		samsungTv.volumeUp();
		samsungTv.powerOff();
		
	
	}

}
