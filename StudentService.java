package com.cg.sms.service;

import java.util.ArrayList;

import com.cg.sms.dto.Student;
import com.cg.sms.exception.StudentException;

public interface StudentService {
	public int addStudent(Student student) throws StudentException;
	public Student getStudent(int rn) throws StudentException;
	public Student updateStudent(Student student) throws StudentException;
	public ArrayList<Student> getStudentList(String coursename) throws StudentException;
	public Student validateDetails(Student student)throws StudentException;
	public boolean validateName(String name) throws StudentException;
	public boolean validatePhoneNo(String mob) throws StudentException;
	public boolean validateCourse(String coursename) throws StudentException;
}
