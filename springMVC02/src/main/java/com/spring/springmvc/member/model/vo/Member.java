package com.spring.springmvc.member.model.vo;

import java.io.Serializable;
import java.util.Date;

public class Member implements Serializable{

	
	private static final long serialVersionUID = -4455665129570759670L;
	private String m_id;
	private String m_password;
	private String m_email;
	private String m_grade;
	private String m_tell;
	private Date m_reg_date;
	private Date m_rentable_date;
	
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_password() {
		return m_password;
	}
	public void setM_password(String m_password) {
		this.m_password = m_password;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_grade() {
		return m_grade;
	}
	public void setM_grade(String m_grade) {
		this.m_grade = m_grade;
	}
	public String getM_tell() {
		return m_tell;
	}
	public void setM_tell(String m_tell) {
		this.m_tell = m_tell;
	}
	public Date getM_reg_date() {
		return m_reg_date;
	}
	public void setM_reg_date(Date m_reg_date) {
		this.m_reg_date = m_reg_date;
	}
	public Date getM_rentable_date() {
		return m_rentable_date;
	}
	public void setM_rentable_date(Date m_rentable_date) {
		this.m_rentable_date = m_rentable_date;
	}
	@Override
	public String toString() {
		return "Member [m_id=" + m_id + ", m_password=" + m_password + ", m_email=" + m_email + ", m_grade=" + m_grade
				+ ", m_tell=" + m_tell + ", m_reg_date=" + m_reg_date + ", m_rentable_date=" + m_rentable_date + "]";
	}

	
	
}
