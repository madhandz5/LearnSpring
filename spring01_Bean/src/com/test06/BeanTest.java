package com.test06;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanTest {

	private MyClass myClass;

	public BeanTest() {
		System.out.println("기본 생성자");
	}

	public BeanTest(Date date) {
		System.out.println("날짜 생성자(date : " + date + " ) ");
	}

	public void setMyClass(MyClass myClass) {
		this.myClass = myClass;
		System.out.println("setMyClass()호출 : " + myClass);
	}

	public void setNumber(int num) {
		System.out.println("setNumber : " + num);

	}

	public void setArray(String[] arr) {
		System.out.println("setArray 호출");
		for (String str : arr) {
			System.out.println(str);
		}
	}

	public void setList(List<String> list) {
		System.out.println("setList 호출");
		for (String str : list) {
			System.out.println(str);
		}
	}

	public void setSet(Set<String> set) {
		System.out.println("setSet호출");
	}

	public void setMap(Map<String, String> map) {
		System.out.println("setMap 호출");
		Collection<String> values = map.values();
		for (String str : values) {
			System.out.println(str);

		}
	}

}
