package com.spring.springmvc.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	@RequestMapping(value="/index/index.do")
//	1. return type을 String으로 지정 반환되는 값으로 view를 찾음
//	전송하고 싶은 데이터는 Model 객체에 저장해서 보낼 수 있다.
//	리다이렉트는 헤더만보내는것임
//	'redirect:/' 후에 경로를 작성하면 리다이렉트 요청을 보낸다.
//	2. ModelAndView.setViewName()을 사용해서 view를 지정
//	3. 반환타입이 void라면, request를 분석해서 경로를 지정
	public ModelAndView index() {
		ModelAndView mav = new ModelAndView("index/index");
		mav.setViewName("index/index");
		
//		반환형을 String으로 변경한후
//		return "redirect:/index/index.do";
//		인덱스페이지가 깜빡하게 됩니다.
		return mav;
	}
	
	
}
