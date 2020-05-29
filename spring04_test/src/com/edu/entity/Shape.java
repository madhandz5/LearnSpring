package com.edu.entity;

public abstract class Shape {

	private String title;
	private int width;
	private int height;

	public Shape() {

	}

	public Shape(String title, int width, int height) {
		super();
		this.title = title;
		this.width = width;
		this.height = height;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Shape [title=" + title + ", width=" + width + ", height=" + height + "]";
	}

	public abstract void viewSize();

}
