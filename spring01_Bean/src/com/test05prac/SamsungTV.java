package com.test05prac;

public class SamsungTV implements TV {

	public SamsungTV() {
		System.out.println("Samsung TV 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("Samsung TV On");

	}

	@Override
	public void powerOff() {
		System.out.println("Samsung TV Off");

	}

	@Override
	public void volumeUp() {
		System.out.println("Samsung TV Volume up");

	}

	@Override
	public void volumeDown() {
		System.out.println("Samsung Tv Volume Down");

	}

}
