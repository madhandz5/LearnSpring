package com.test05prac;

public class LGTV implements TV {

	public LGTV() {
		System.out.println("LG TV 생성");
	}

	@Override
	public void powerOn() {
		System.out.println("LG TV Power On");

	}

	@Override
	public void powerOff() {
		System.out.println("LG TV Power Off");

	}

	@Override
	public void volumeUp() {
		System.out.println("LG TV Volume Up");

	}

	@Override
	public void volumeDown() {
		System.out.println("LG TV Volume Down");

	}

}
