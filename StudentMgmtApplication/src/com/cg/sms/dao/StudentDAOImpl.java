package com.cg.sms.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.sms.dto.Student;
import com.cg.sms.exception.StudentException;

public class StudentDAOImpl implements StudentDAO {
	
	Map<Integer, Student> studentMap;
	public StudentDAOImpl() {
		// TODO Auto-generated constructor stub
		studentMap = DataStore.createCollection();
	}
	
	@Override
	public int addStudent(Student student) throws StudentException{
		// TODO Auto-generated method stub
		int rollno = (int) (1000 * Math.random());
		student.setRollno(rollno);
		studentMap.put(rollno, student);
		return rollno;
	}
	
	@Override
	public Student getStudent(int rn) throws StudentException{
		// TODO Auto-generated method stub
		Student stud = studentMap.get(rn); 
		return stud;
	}
	
	@Override
	public Student updateStudent(Student student) throws StudentException {
		// TODO Auto-generated method stub
		studentMap.put(student.getRollno(), student);
		return student;
	}
	
	@Override
	public ArrayList<Student> getStudentList(String coursename) throws StudentException{
		// TODO Auto-generated method stub
		Collection <Student> studList = studentMap.values();
		ArrayList <Student> students = new ArrayList<Student>();
		Iterator<Student> itr = studList.iterator();
		while(itr.hasNext())
		{
			Student s = itr.next();
			if(s.getCourseName().equals(coursename))
			{
				students.add(s);
			}
		}
		return students;
	}
	
	@Override
	public Student removeStudent(int rn) throws StudentException{
		// TODO Auto-generated method stub
		Student s = studentMap.remove(rn);
		return s;
	}

	@Override
	public boolean validateName(String name) throws StudentException{
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[A-Z][a-z]{3,}");
		Matcher mat = pat.matcher(name);
		return mat.matches();
	}

	@Override
	public boolean validatePhone(String phone) throws StudentException{
		// TODO Auto-generated method stub
		Pattern pat = Pattern.compile("[7-9][0-9]{9}");
		Matcher mat = pat.matcher(phone);
		return mat.matches();
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