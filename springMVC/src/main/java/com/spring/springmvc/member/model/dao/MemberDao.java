package com.spring.springmvc.member.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.springmvc.member.model.vo.Member;

import common.JDBCTemplate;

@Repository
public class MemberDao {

	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public String idCheck(Connection conn, String userId) throws SQLException {

		String res = "";
		String sql = "select m_id from tb_member where m_id = '" + userId + "'";
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				res = rs.getString(1);
			}
		} finally {
			jdt.close(rs, stmt);
		}
		return res;
	}

	public int insertMember(Connection conn, Map<String, Object> commandMap) throws SQLException {
		int res = 0;
		String sql = "insert into tb_member values(?,?,?,1001,?,sysdate,sysdate,'N')";
		PreparedStatement psmt = null;

		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, (String) commandMap.get("userId"));
			psmt.setString(2, (String) commandMap.get("userPwd"));
			psmt.setString(3, (String) commandMap.get("m_email"));
			psmt.setString(4, (String) commandMap.get("m_tell"));
			res = psmt.executeUpdate();
		} finally {
			jdt.close(psmt);
		}

		return res;
	}

	public Member logInImple(Connection conn, String id, String pw) throws SQLException {
		Member res = null;
		String sql = "select m_id, c_info, m_tell, m_reg_date, m_rentable_date from tb_member inner join tb_code on m_grade = c_code where m_id= ? and m_password= ? ";
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, id);
			pstm.setString(2, pw);
			rs = pstm.executeQuery();

			if (rs.next()) {
				res = new Member();
				res.setM_id(rs.getString(1));
				res.setM_grade(rs.getString(2));
				res.setM_tell(rs.getString(3));
				res.setM_reg_date(rs.getDate(4));
				res.setM_rentable_date(rs.getDate(5));
			}
		} finally {
			jdt.close(rs, pstm);
		}
		return res;

	}

}
