package com.ioc.client;

import java.sql.SQLException;

import com.ioc.library.dao.ConnectionMaker;
import com.ioc.library.dao.MemberDao;

public class DaoFactory {
	
	public MemberDao createMemberDao() throws ClassNotFoundException,SQLException{
		MemberDao mDao = new MemberDao(getConnectionMaker());
		return mDao;
	}
	
	public ConnectionMaker getConnectionMaker() throws SQLException,ClassNotFoundException{
		ConnectionMaker connectionMaker = new ClientConnectionMaker();
		
		return connectionMaker; 
	}

}
