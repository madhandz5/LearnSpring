package com.test04;

import java.util.Calendar;
import java.util.GregorianCalendar;

public abstract class AbstractTest {
	public abstract String dayInfo();

	public static AbstractTest getInstance() {
		
		GregorianCalendar cal = new GregorianCalendar();
		
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch (day) {
		case 1:
			return new Sunday();
		case 2:
			return new Monday();
		case 3:
			return new Tuesday();
		case 4:
			return new Wednesday();
		case 5:
			return new Thursday();
		case 6:
			return new Friday();
		case 7:
			return new Saturday();

		}

		return null;
	}
	
	public static void output() {
		System.out.println("이 메서드는 호출되지만, 호출되고 나면 BeanNotOfRequiredTypeException이 발생한다.");
	}

}
