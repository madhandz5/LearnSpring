package com.spring.springmvc.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.spring.springmvc.member.model.vo.Member;

import common.JDBCTemplate;

// Proxy(대행자) 패턴
// 가상프록시(Virtual Proxy) : 
// 				// 타겟객체(ex. MemberService)의 주기능 외에 부가적인 기능을 처리해주는 객체
// 				// 주 기능은 타겟객체에게 요청을 하여 처리한다.

// 보호 프록시 : 타겟 객체에게 접근할 권한제어 기능을 하는 객체

public class ProxyMemberService implements MemberService {

	//java 1.2부터 제공이 되는 ThreadLocal 객체
	public static ThreadLocal<Connection> local = new ThreadLocal<Connection>();
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	@Override
	public String idCheck(String id) {

		Connection conn = jdt.getConnection();
		local.set(conn);
		String res = "";

		try {
			res = new MemberServiceImpl(conn).idCheck(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			jdt.close(conn);
		}

		return res;
	}

	@Override
	public int insertMember(Map<String, Object> commandMap) {
		Connection conn = jdt.getConnection();
		local.set(conn);
		int res = 0;
		try {
			res = new MemberServiceImpl(conn).insertMember(commandMap);
			jdt.commit(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jdt.rollback(conn);
		}finally {
			jdt.close(conn);
		}
		
		return res;
	}

	@Override
	public Member login(String id, String pw) {
		Connection conn = jdt.getConnection();
		local.set(conn);
		Member member = null;
		try {
			member = new MemberServiceImpl(conn).login(id, pw);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			jdt.close(conn);
		}
		return member;
	}

	@Override
	public void mailSending(Map<String, Object> commandMap) {

		new MemberServiceImpl().mailSending(commandMap);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
