package com.test02;

import org.springframework.beans.factory.annotation.Autowired;

public class School {
	private int grade;
	private Student personStudent;
	
	@Autowired
	
	private Student student;
	public School() {
		
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Student getPersonStudent() {
		return personStudent;
	}

	public void setPersonStudent(Student personStudent) {
		this.personStudent = personStudent;
	}

	@Override
	public String toString() {
		return "School [grade=" + grade + ", personStudent=" + personStudent + "]";
	}
	
	

}
