package com.spring.springmvc.index.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@RequestMapping(value = "/index/index.do")

	// 1. return type �� String���� ���� ��ȯ�Ǵ� ������ view�� ã��
	// �����ϰ� ���� �����ʹ� Model ��ü�� �����ؼ� ���� �� �ִ�.
	// 'redirect:/' ��θ� �ۼ��ϸ� redirect��û�� ��.
	// 2. ModelAndView.setViewName()�� ����ؼ� view�� ������ �� ����.
	//
	// 3. ��ȯŸ���� void���, request�� �м��ؼ� ��θ� ��������.

	public ModelAndView index() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index/index");

		return mav;
	}
}
