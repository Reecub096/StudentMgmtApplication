package com.cg.sms.dao;

import java.util.ArrayList;



import com.cg.sms.dto.Student;
import com.cg.sms.exception.StudentException;

public interface StudentDAO {
	
	public int addStudent(Student student) throws StudentException;
	public Student getStudent(int rn) throws StudentException;
	public Student updateStudent(Student student) throws StudentException;
	public ArrayList<Student> getStudentList(String coursename) throws StudentException;
	public Student removeStudent(int rn) throws StudentException;
	public boolean validateName(String name) throws StudentException;
	public boolean validatePhone(String phone) throws StudentException;
	public Student ValidateDetails(Student stud)throws StudentException;
	
}
