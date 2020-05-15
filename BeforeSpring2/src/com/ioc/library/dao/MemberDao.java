package com.ioc.library.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ioc.library.vo.Member;

public class MemberDao {

	public void inserMember(Member member) throws ClassNotFoundException, SQLException {

		// 1. DB 연결에 필요한 컨넥션 객체를 가져오기

		Connection connection = getConnection();

		// 2. 매개변수로 넘어온 값들을 활용해서 쿼리를 작성하고 쿼리를 실행하기
		// 3. 사용한 Connection 과 PreparedStatment를 닫아주기

		String sql = "insert into tb_member(m_id,m_password,m_email) values(?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, member.getId());
		preparedStatement.setString(2, member.getPassword());
		preparedStatement.setString(3, member.getEmail());

		preparedStatement.executeUpdate();

		preparedStatement.close();
		connection.close();
	}

	public Member selectMember(String id) throws ClassNotFoundException, SQLException {
		Member member = new Member();

		Connection connection = getConnection();

		String sql = "select * from tb_member where m_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, id);

		ResultSet resultSet = preparedStatement.executeQuery();

		member.setId(resultSet.getString(1));
		member.setPassword(resultSet.getString(2));
		member.setEmail(resultSet.getString(3));

		resultSet.close();
		preparedStatement.close();
		connection.close();

		return member;
	}

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe");

		return connection;

	}

}
