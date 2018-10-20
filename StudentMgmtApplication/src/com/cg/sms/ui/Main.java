package com.cg.sms.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.cg.sms.dto.Student;
import com.cg.sms.service.StudentService;
import com.cg.sms.service.StudentServiceImpl;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		StudentService service = new StudentServiceImpl();
		int ch;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("1.Add Student");
		System.out.println("2. Display Student Details");
		System.out.println("3. Update details");
		System.out.println("4. Display Student List");
		System.out.println("5. Delete Student Record");
		System.out.println("6.Exit");
		do{
			System.out.println("Enter your choice");
			ch=sc.nextInt();
			switch(ch)
			{
				case 1:	
					
						System.out.println("Enter Name: ");
						String name = sc.next();
						System.out.println("Enter Course Name: ");
						String cname = sc.next();
						System.out.println("Enter Age: ");
						int age = sc.nextInt();
						System.out.println("Enter Mobile no: ");
						String mobile = sc.next();
					
						Student student = new Student();
						student.setName(name);
						student.setCourseName(cname);
						student.setAge(age);
						student.setMobileNo(mobile);
						int rn = service.addStudent(student);
						System.out.println("Student record added .. " + rn);
						break;
				
				case 2:
					System.out.println("Enter Roll no :");
					rn=sc.nextInt();
					student=service.getStudent(rn);
					if(student==null)
						System.out.println("record not found..");
					else {
							System.out.println(student.getName());
							System.out.println(student.getAge());
							System.out.println(student.getCourseName());
							System.out.println(student.getMobileNo());
							break;
					}
				
				case 3:
					System.out.println("enter roll no :");
					rn=sc.nextInt();
					student=service.getStudent(rn);
					if(student==null)
					System.out.println("record not found");
					else
					{
						System.out.println("enter new mobile number :");
						String mobno = sc.next();
						student.setMobileNo(mobno);
						student = service.updateStudent(student);
						System.out.println("Record updated");
						System.out.println(student.getName());
						System.out.println(student.getMobileNo());
						break;
					}
					
				case 4 : 
					System.out.println(" Enter Course Name : ");
					cname = sc.next();
					ArrayList<Student> list = service.getStudentList(cname);
					if(list.size() == 0)
					{
						System.out.println(" No Student Enrolled to this record ");
					}
					else 
					{
						for(Student s : list)
						{
							System.out.println(s.getName() + " " + s.getMobileNo());
						}
					}
					
				case 5 :
					System.out.println(" Enter Roll No: ");
					rn = sc.nextInt();
					student = service.removeStudent(rn);
					if (student == null)
						System.out.println(" No Record Found ");
					else 
					{
						System.out.println(" Record Deleted ");
					}
			}//end of switch
			
		}while(ch!=6); //end of do while
	
	}
	
}
	
		
	


