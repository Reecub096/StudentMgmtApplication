package com.cg.sms.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sms.dao.StudentDAO;
import com.cg.sms.dao.StudentDAOImpl;
import com.cg.sms.dto.Student;
import com.cg.sms.exception.StudentException;

public class StudentServiceImpl implements StudentService {
	StudentDAO dao;
	public StudentServiceImpl() {
		// TODO Auto-generated constructor stub
		dao = new StudentDAOImpl();
	}
	
	@Override
	public int addStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		int rn = dao.addStudent(student);
		return rn;
	}
	
	@Override
	public Student getStudent(int rn) throws StudentException{
		// TODO Auto-generated method stub
		return dao.getStudent(rn); 
	}
	
	@Override
	public Student updateStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		return dao.updateStudent(student);
	}
	
	@Override
	public ArrayList<Student> getStudentList(String coursename) throws StudentException{
		// TODO Auto-generated method stub
		return dao.getStudentList(coursename);
	}

	@Override
	public Student validateDetails(Student student) throws StudentException {
		// TODO Auto-generated method stub
		if(validateName(student.getName()) && validatePhoneNo(student.getMobileNo()) && validateCourse(student.getCourseName()))
			return student;
		return null;
	}

	@Override
	public boolean validateName(String name) throws StudentException {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[A-Z][a-z]{3,}");
		Matcher mat = pat.matcher(name);
		return mat.matches();
	}

	@Override
	public boolean validatePhoneNo(String mob) throws StudentException {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[7-9][0-9]{9}");
		Matcher mat = pat.matcher(mob);
		return mat.matches();
	}

	@Override
	public boolean validateCourse(String coursename) throws StudentException {
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[A-Za-z]{3,12}");
		Matcher mat = pat.matcher(coursename);
		return mat.matches();
	}
		
}
