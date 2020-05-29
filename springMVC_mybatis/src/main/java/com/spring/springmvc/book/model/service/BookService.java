package com.spring.springmvc.book.model.service;

import java.util.List;
import java.util.Map;

import com.spring.springmvc.book.model.vo.Book;

public interface BookService {

	public List<Book> selectBookList(Map<String,Object> commandMap);
	public List<Book> selectInnerBookSearchList(Map<String,Object> commandMap);
	public Book selectBook(Map<String,Object> commandMap);
	
}
