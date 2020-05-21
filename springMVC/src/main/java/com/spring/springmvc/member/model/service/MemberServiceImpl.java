package com.spring.springmvc.member.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.spring.springmvc.member.model.dao.MemberDao;
import com.spring.springmvc.member.model.vo.Member;

import common.JDBCTemplate;

@Service
@Scope("request")
// Scope 
// - Bean의 생명주기를 결정
// 1. singleton : singleton Scope
// 2. request : request Scope
// 3. session : session Scope
public class MemberServiceImpl implements MemberService {

	MemberDao mDao = new MemberDao();

	@Autowired
	JavaMailSender mailSender;

	Connection conn = null;
	JDBCTemplate jdt = JDBCTemplate.getInstance();

	public MemberServiceImpl() {

	}

	public MemberServiceImpl(Connection conn) {
		this.conn = conn;
	}

	public String idCheck(String id) throws SQLException {

		String res = "";
		res = mDao.idCheck(conn, id);
		return res;
	}

	public int insertMember(Map<String, Object> commandMap) throws SQLException {
		int res = 0;
		res = mDao.insertMember(conn, commandMap);
		return res;
	}

	public Member loginImple(String id, String pw) throws SQLException {
		Member res = null;
		res = mDao.logInImple(conn, id, pw);
		return res;
	}

	// Template CallBack 패턴
	// 전략패턴과 동일한 용도로 사용되는 디자인 패턴 > 주입되는 객체가 내부 익명클래스 이다.
	public void mailSending(Map<String, Object> commandMap) {

		String from = "smwproject4@gmail.com";
		String toMail = (String) commandMap.get("m_email");
		String title = "가입을 환영합니다.";
		String htmlBody = "<form action='http://" + commandMap.get("urlPath")
				+ "/member/joinimple.do' method='post'><h3>회원가입을 환영합니다.</h3>" + "<input type='hidden' value='"
				+ commandMap.get("userId") + "' name='userId'>" + "<input type='hidden' value='"
				+ commandMap.get("userPwd") + "' name='userPwd'>" + "<input type='hidden' value='"
				+ commandMap.get("m_email") + "' name='m_email'>" + "<input type='hidden' value='"
				+ commandMap.get("m_tell") + "' name='m_tell'>" + "<button type='submit'>가입하기</form>";

		mailSender.send(new MimeMessagePreparator() {
			public void prepare(MimeMessage mimeMessage) throws MessagingException {
				MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				message.setFrom(from);
				message.setTo(toMail);
				message.setSubject(title);
				message.setText(htmlBody, true);
				// message.addInline("myLogo", new ClassPathResource("img/mylogo.gif"));
				// message.addAttachment("myDocument.pdf", new
				// ClassPathResource("doc/myDocument.pdf"));
			}
		});
	}
}
