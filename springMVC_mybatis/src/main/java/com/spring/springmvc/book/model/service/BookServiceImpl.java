package com.spring.springmvc.book.model.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.springmvc.book.model.dao.BookDao;
import com.spring.springmvc.book.model.vo.Book;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bdao;
	
	@Override
	public List<Book> selectBookList(Map<String,Object> commandMap) {
		return bdao.selectBookList(commandMap);
	}

	@Override
	public List<Book> selectInnerBookSearchList(Map<String,Object> commandMap) {
		return bdao.selectInnerBookSearchList(commandMap);
	}

	@Override
	public Book selectBook(Map<String,Object> commandMap) {
		return bdao.selectBook(commandMap);
	}

}
