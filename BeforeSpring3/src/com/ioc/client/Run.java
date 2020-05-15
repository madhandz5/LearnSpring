package com.ioc.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.ioc.library.dao.ClientMemberDao;
import com.ioc.library.dao.MemberDao;
import com.ioc.library.vo.Member;

public class Run {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner scanner = new Scanner(System.in);
		MemberDao mDao = new ClientMemberDao();
		Member member = new Member();

		System.out.println("아이디를 입력하세요 : ");
		member.setId(scanner.nextLine());
		System.out.println("비밀번호를 입력하세요 : ");
		member.setPassword(scanner.nextLine());
		System.out.println("이메일을 입력하세요");
		member.setEmail(scanner.nextLine());
		scanner.close();

		mDao.inserMember(member);
		Member res = mDao.selectMember(member.getId());
		System.out.println(res);

	}
}
