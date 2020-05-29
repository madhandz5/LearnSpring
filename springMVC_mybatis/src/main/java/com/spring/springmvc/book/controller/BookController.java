package com.spring.springmvc.book.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springmvc.book.model.service.BookService;
import com.spring.springmvc.book.model.vo.Book;

@Controller
public class BookController {

	@Autowired
	BookService bs;
	
	@RequestMapping("/book/search.do")
	public ModelAndView selectBookList(ModelAndView mav, @RequestParam Map<String,Object> commandMap) {
		System.out.println(System.identityHashCode(mav));
		System.out.println(commandMap.get("b_title")+"selectBookList");
		List<Book> bList = bs.selectBookList(commandMap);
		if(!bList.isEmpty()) {
			mav.addObject("booklist", bList);
			mav.setViewName("book/booksearch");
		} else {
			mav.setViewName("common/result");
			mav.addObject("alertMsg","해당 도서가 존재하지 않습니다.");
			mav.addObject("back","back");
		}
		
		return mav;
	}
	
	@RequestMapping("/book/innersearch.do")
	public ModelAndView selectInnerBookSearchList(ModelAndView mav, @RequestParam Map<String,Object> commandMap) {
		System.out.println(System.identityHashCode(mav));
		System.out.println(commandMap.get("title")+"selectInnerBookSearchList");
		System.out.println(commandMap.get("orderBy")+"selectInnerBookSearchList");
		List<Book> bList = bs.selectBookList(commandMap);
		
		if(!bList.isEmpty()) {
			mav.addObject("selectBookList", bList);
			mav.setViewName("book/booksearch");
		} else {
			mav.setViewName("common/result");
			mav.addObject("alertMsg","해당 도서가 존재하지 않습니다.");
			mav.addObject("back","back");
		}
		
		return mav;
	}
	@RequestMapping("/book/detail.do")
	public ModelAndView selectBook(ModelAndView mav, HttpServletRequest request) {
		Map<String,Object> commandMap = new HashMap<String, Object>();
		commandMap.put("b_bno", request.getParameter("b_bno"));
		System.out.println(commandMap.get("b_bno")+"selectBook");
		
		Book book = bs.selectBook(commandMap);
		if(book != null) {
			mav.addObject("book", book);
			mav.setViewName("book/bookDetail");
		} else {
			mav.setViewName("common/result");
			mav.addObject("alertMsg","해당 도서의 정보를 불러올 수 없습니다.");
			mav.addObject("back","back");
		}
		
		return mav;
	}
	
}
