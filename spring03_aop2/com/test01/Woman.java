package com.test01;

public class Woman {

	public void classWork() {

		System.out.println("출석카드 찍는다.");

		try {
			System.out.println("컴퓨터를 켜서 오라클을 한다.");
			String str = null;
			str.length();
		} catch (Exception e) {
			System.out.println("쉬는 날이었다.");
		} finally {
			System.out.println("집에간다.");
		}
	}
}
