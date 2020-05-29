package com.spring.springmvc.book.model.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.springmvc.book.model.vo.Book;

@Repository
public class BookDao {

	@Autowired
	SqlSessionTemplate session;

	public List<Book> selectBookList(Map<String, Object> commandMap) {
		return session.selectList("Book.selectBookList", commandMap);
	}

	public List<Book> selectInnerBookSearchList(Map<String, Object> commandMap) {
		return session.selectList("Book.selectInnerBookSearchList", commandMap);
	}

	public Book selectBook(Map<String, Object> commandMap) {
		int bno = Integer.parseInt((String) commandMap.get("b_bno"));

		return session.selectOne("Book.selectBook", bno);
	}

}
