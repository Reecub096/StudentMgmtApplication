package com.cg.sms.service;

import java.util.ArrayList;

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
	public int addStudent(Student student) throws StudentException{
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
	public Student updateStudent(Student student) throws StudentException{
		// TODO Auto-generated method stub
		return dao.updateStudent(student);
	}
	
	@Override
	public ArrayList<Student> getStudentList(String coursename) throws StudentException{
		// TODO Auto-generated method stub
		return dao.getStudentList(coursename);
	}
	
	@Override
	public Student removeStudent(int rn) throws StudentException{
		// TODO Auto-generated method stub
		return dao.removeStudent(rn);
	}

	@Override
	public boolean validateName(String name) throws StudentException {
		// TODO Auto-generated method stub
		return dao.validateName(name);
	}

	@Override
	public boolean validatePhone(String phone) throws StudentException {
		// TODO Auto-generated method stub
		return dao.validatePhone(phone);
	}

	@Override
	public Student ValidateDetails(Student stud) throws StudentException {
		// TODO Auto-generated method stub
		if(validateName(stud.getName()) && validatePhone(stud.getMobileNo()))
			return stud;
		else
			return null;
	}
		
}
