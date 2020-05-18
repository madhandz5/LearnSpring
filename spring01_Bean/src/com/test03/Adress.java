package com.test03;

public class Adress {

	private String name;
	private String addr;
	private String phone;

	public Adress() {
		System.out.println("기본생성자 호출");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(name + "값이 입력되었습니다.");
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
		System.out.println(addr + "값이 입력되었습니다.");
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
		System.out.println(phone + "값이 입력되었습니다.");
	}

	@Override
	public String toString() {
		return "Adress [name=" + name + ", addr=" + addr + ", phone=" + phone + "]";
	}

}
