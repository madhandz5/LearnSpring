package com.test02;

public class MessageBean {
	private String fruit;
	private int cost;

	public MessageBean() {
		this.fruit = "banana";
		this.cost = 5000;
		System.out.println("기본생성자 호출");
	}

	public MessageBean(String fruit, int cost) {
		this.fruit = fruit;
		this.cost = cost;
	}

	public String getFruit() {
		return fruit;
	}

	public void setFruit(String fruit) {
		this.fruit = fruit;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "MessageBean [fruit=" + fruit + ", cost=" + cost + "]";
	}

}