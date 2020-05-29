package com.spring.springmvc.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.springmvc.member.model.vo.Member;

import common.JDBCTemplate;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate session;
	
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public String idCheck(String id){
		return session.selectOne("Member.selectId",id);
	}

	public int insertMember(Map<String, Object> commandMap){
	
		
		return session.insert("Member.insertMember", commandMap);
	}

	public Member logIn(String id, String pw) {
		Map<String,String> userinfo = new HashMap<String, String>();
		userinfo.put("id",id);
		userinfo.put("pw",pw);
		
		return session.selectOne("Member.selectMember",userinfo);
	}

}