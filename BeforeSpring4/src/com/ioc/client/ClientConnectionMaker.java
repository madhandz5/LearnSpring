package com.ioc.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.ioc.library.dao.ConnectionMaker;

public class ClientConnectionMaker implements ConnectionMaker {

	@Override
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "bm", "test11");

		return connection;
	}

}
