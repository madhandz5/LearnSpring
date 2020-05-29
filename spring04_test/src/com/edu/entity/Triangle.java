package com.edu.entity;

public class Triangle extends Shape{

	
	public Triangle() {
		// TODO Auto-generated constructor stub
	}

	public Triangle(String title, int width, int height) {
		super(title, width, height);
		// TODO Auto-generated constructor stub
	
	}

	@Override
	public void viewSize() {
		
		System.out.println(getTitle() +"의 넓이: "+ (getHeight()*getWidth())/2);
	
	}

}
