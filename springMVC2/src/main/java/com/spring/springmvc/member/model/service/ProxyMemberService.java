package com.spring.springmvc.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import com.spring.springmvc.member.model.vo.Member;

import common.JDBCTemplate;

// Proxy Pettern
// 1. 가상 프록시 (Virtual Proxy)
// - 타겟객체(ex. MemberService)의 주 기능 외에 부가적인 기능을 처리해주는 객체, 주 기능은 타겟객체에게 요청을 하여 처리한다.
// 2. 보호 프록시
// - 타겟 객체에게 접근할 권한 제어 기능을 하는 객체
public class ProxyMemberService implements MemberService {

	JDBCTemplate jdt = JDBCTemplate.getInstance();
	
	@Override
	public String idCheck(String id) throws SQLException {

		Connection conn = jdt.getConnection();
		String res = "";
		try {
			res = new MemberServiceImpl(conn).idCheck(id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return res;
	}

	@Override
	public int insertMember(Map<String, Object> commandMap) {
		Connection conn = jdt.getConnection();
		int res = 0;

		try {
			res = new MemberServiceImpl(conn).insertMember(commandMap);
			jdt.commit(conn);
		} catch (Exception e) {
			jdt.rollback(conn);
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return res;
	}

	@Override
	public Member loginImple(String id, String pw) {
		Connection conn = jdt.getConnection();
		Member member = null;
		try {
			member = new MemberServiceImpl(conn).loginImple(id, pw);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			jdt.close(conn);
		}
		return member;
	}

	@Override
	public void mailSending(Map<String, Object> commandMap) {

		new MemberServiceImpl().mailSending(commandMap);

	}

}
