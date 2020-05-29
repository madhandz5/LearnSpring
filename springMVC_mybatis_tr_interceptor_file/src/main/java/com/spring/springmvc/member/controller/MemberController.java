package com.spring.springmvc.member.controller;

import java.sql.SQLException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.springmvc.member.model.service.MemberService;
import com.spring.springmvc.member.model.vo.Member;

@Controller
public class MemberController {
	
	@Autowired
    public MemberService ms;
	
	@RequestMapping("/member/join.do")
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/memberJoin");
		return mav;
	}
	
	@RequestMapping(value = "/member/idcheck.do"
			,produces="application/text; charset=utf-8") 
	@ResponseBody
//	메서드에서 리턴되는 값이 HTTP Response의 Body(HTTP Message)에 써진다.
	
//	@RequestParam
//	HTTP Request의 파라미터와 메서드의 매개변수를 바인딩하기 위해 사용되는 어노테이션
//	1. HttpServletRequset/Response, HttpSession
//	2. util.Map, Model
//	Jackson 라이브러리
//	우리가 만든 vo에 저장할때 쓰인다.
	public String idCheck(String userId) throws SQLException {
		String id = ms.idCheck(userId);
		return id;
	}
	@RequestMapping("/member/joinemailCheck.do")
	public ModelAndView joinEmailCheck(@RequestParam Map<String, Object> commandMap, HttpServletRequest request) throws SQLException {
		ModelAndView mav = new ModelAndView();
		String path = request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		commandMap.put("urlPath",path);
		ms.mailSending(commandMap);
		mav.addObject("alertMsg","이메일로 인증번호가 발송되었습니다.");
		mav.addObject("url", request.getContextPath() + "/index/index.do");
		mav.setViewName("common/result");
		
		return mav;
	}
	
	
	@RequestMapping(value = "/member/joinimple.do"
			,produces="application/text; charset=utf-8")
//	public ModelAndView joinImple(String userId, String userPwd, String m_email, String m_tell) {
	public ModelAndView joinImple(@RequestParam Map<String,Object> commandMap) throws SQLException {
		
//		Member m = new Member();
//		m.setM_id(userId);
//		m.setM_password(userPwd);
//		m.setM_email(m_email);
//		m.setM_tell(m_tell);
		
		
		int res = ms.insertMember(commandMap);
		
		ModelAndView mav = new ModelAndView();
		if(res >= 1) {
			mav.setViewName("member/joinComplete");
		} else {
			mav.setViewName("common/result");
			mav.addObject("alertMsg", "회원가입에 실패하셨습니다.");
			mav.addObject("back","back");
		}
		
		return mav;
	}
	
	@RequestMapping("/member/login.do")
	public String logIn() {
		return "member/login";
	}
	
	@RequestMapping("/member/loginimple.do")
	public ModelAndView logInImple(String id, String pw, HttpSession session) throws SQLException {
		ModelAndView mav = new ModelAndView();
		
		Member res = ms.login(id, pw);
		if(res == null) {
			mav.addObject("reCheck","true");
			mav.addObject("msg","true");
			mav.setViewName("member/login");
		} else {
			session.setAttribute("logInInfo", res);
			mav.setViewName("index/index");
		}
		
		return mav;
	}
	@RequestMapping("/member/logout.do")
	public ModelAndView logOut(HttpSession session) {
		ModelAndView mav = new ModelAndView();
		
		if(session != null) {
			session.removeAttribute("logInInfo");
		}
		
		mav.setViewName("index/index");
		return mav;
	}
	
	
}
