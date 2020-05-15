package com.pattern.bulider;

public class Run {

	public static void main(String[] args) {
		Book book = new Book.BookBuilder().title("aaa").author("aaa").publisher("aaa").page(10000).build();

		System.out.println(book);
	}
 }
