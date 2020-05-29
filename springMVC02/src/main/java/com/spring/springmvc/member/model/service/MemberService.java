package com.spring.springmvc.member.model.service;


import java.sql.SQLException;
import java.util.Map;


import com.spring.springmvc.member.model.vo.Member;


public interface MemberService {

	public String idCheck(String id) throws SQLException;
	public int insertMember(Map<String, Object> commandMap) throws SQLException;
	public Member login(String id, String pw) throws SQLException;
	public void mailSending(Map<String, Object> commandMap) throws SQLException;
	
}
