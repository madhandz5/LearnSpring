package com.spring.springmvc.member.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springmvc.member.model.service.MemberService;
import com.spring.springmvc.member.model.service.ProxyMemberService;
import com.spring.springmvc.member.model.vo.Member;

@Controller
public class MemberController {
	
	public MemberService ms = new ProxyMemberService();

	@RequestMapping("/member/join.do")
	public ModelAndView join() {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberJoin");

		// 반환형을 String으로 변경한 후
		// return "redirect:/index/index.do";
		// 형식으로 지정해주면 해당 url로 redirect 요청이 들어가게 된다.
		// 인덱스페이지가 깜빡하게 됩니다.
		return mav;
	}

	@RequestMapping(value = "/member/idcheck.do", produces = "application/text; charset=utf-8")
	@ResponseBody
	// 메서드에서 리턴되는 값이 HTTP Response의 Body(HTTP Message)에 써진다.

	// @RequestParam
	// HTTP Request의 파라미터와 메서드의 매개변수를 바인딩하기 위해 사용되는 annotation
	// 컨트롤러의 매개변수로 Dispatcher서블릿이 매핑해서 넘겨주는 타입들.
	// 1. HttpServletRequest/Response, HttpSession
	// 2. util.Map, Model
	// Jackson 라이브러리
	public String idCheck(String userId) throws SQLException {

		String id = ms.idCheck(userId);
		return id;

	}

	@RequestMapping("/member/joinimple.do")
	public ModelAndView joinImple(@RequestParam Map<String, Object> commandMap) throws SQLException {
		ModelAndView mav = new ModelAndView();

		int res = ms.insertMember(commandMap);
		if (res < 1) {
			mav.setViewName("common/result");
			mav.addObject("alsertMsg", "회원가입에 실패하였습니다.");
			mav.addObject("back", "back");

		} else {
			mav.setViewName("member/joinComplete");
		}
		return mav;
	}

	@RequestMapping("/member/login.do")
	public String login() {

		return "member/login";

	}

	@RequestMapping("/member/loginimple.do")
	public ModelAndView loginImple(String id, String pw, HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();

		Member res = ms.login(id, pw);

		if (res == null) {
			mav.addObject("reCheck", "true");
			mav.addObject("msg", "true");
			mav.setViewName("member/login");
		} else {
			session.setAttribute("logInInfo", res);
			mav.setViewName("index/index");
		}

		return mav;
	}

	@RequestMapping("/member/logout.do")
	public ModelAndView logout(HttpSession session) throws SQLException{

		ModelAndView mav = new ModelAndView();

		if (session != null) {
			session.removeAttribute("logInInfo");
		}

		mav.setViewName("index/index");
		return mav;
	}

	@RequestMapping("/member/joinemailCheck.do")
	public ModelAndView joinEmailCheck(@RequestParam Map<String, Object> commandMap, HttpServletRequest request) throws SQLException{

		ModelAndView mav = new ModelAndView();
		String path = request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		commandMap.put("urlPath", path);
		ms.mailSending(commandMap);
		mav.addObject("alertMsg", "이메일로 인증번호가 발송되었습니다.");
		mav.addObject("url", request.getContextPath() + "/index/index.do");
		mav.setViewName("common/result");

		return mav;
	}

}
