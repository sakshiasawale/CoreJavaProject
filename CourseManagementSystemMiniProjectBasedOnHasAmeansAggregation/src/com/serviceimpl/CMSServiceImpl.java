package com.serviceimpl;

import java.util.Scanner;

import com.model.Batch;
import com.model.Course;
import com.model.Faculty;
import com.model.Student;
import com.service.CMSService;

public class CMSServiceImpl implements CMSService {

	Scanner sc = new Scanner(System.in);
	Course course = new Course();
	Faculty faculty = new Faculty();
	Batch batch = new Batch();
	Student student = new Student();
	
	
	@Override
	public void addCourse() {
		System.out.println("Enter Course Id : ");
		course.setCid(sc.nextInt());
		
		System.out.println("Enter Course Name :");
		course.setCname(sc.next());
	}

	@Override
	public void displayCourse() {
		
	System.out.println("Couse Id :"+course.getCid());
	System.out.println("Couse Name :"+course.getCname());
	
	}

	@Override
	public void addFaculty() {
		
		System.out.println("Enter your Faculty Id : ");
		faculty.setFid(sc.nextInt());
		
		System.out.println("Enter your Faculty Name :");
		faculty.setFname(sc.next());
		
		faculty.setCourse(course);
	}

	@Override
	public void displayFaculty() {
		
		System.out.println("Faculty Id : "+faculty.getFid());
		System.out.println("Faculty Name :"+faculty.getFname());
		displayCourse();
		
	}

	@Override
	public void addBatch() {
		System.out.println("Enter Your Batch Id :");
		batch.setBid(sc.nextInt());
		
		System.out.println("Enter your Batch Name :");
		batch.setBname(sc.next());
		
		batch.setFaculty(faculty);
	}

	@Override
	public void displayBatch() {
		
		System.out.println("Batch Id : "+batch.getBid());
		System.out.println("Batch Name :"+batch.getBname());
		displayCourse();
		displayFaculty();
		
	}

	@Override
	public void addStudent() {
		
		System.out.println("Enter your student Id :");
		student.setSid(sc.nextInt());
		
		System.out.println("Enter your Student Name :");
		student.setSname(sc.next());
		
		student.setBatch(batch);
	}

	@Override
	public void displayStudent() {
		
		System.out.println("Student Id :"+student.getSid());
		System.out.println("Student Name :"+student.getSname());
		displayCourse();
		displayFaculty();
		displayBatch();
	}

	@Override
	public void updateDetails() {
		
		boolean flag=true;
		while(flag)
		{
			System.out.println("---------------Updated Menu------------------");
			System.out.println("|===========================================|");
			System.out.println("|            1. Course                      |");
			System.out.println("|===========================================|");
			System.out.println("|            2. Faculty                     |");
			System.out.println("|===========================================|");
			System.out.println("|            3. Batch                       |");
			System.out.println("|===========================================|");
			System.out.println("|            4. Student                     |");
			System.out.println("|===========================================|");
			System.out.println("|            5. Exit                        |");
			System.out.println("|===========================================|");
			System.out.println();

			
		System.out.println("Enter your Choice between 1 to 4 :");
		int ch = sc.nextInt();
		
		switch(ch)
		{
		case 1:
			boolean c = true;
			while(c)
			{
				System.out.println("------------Course Update Manu---------------");
				System.out.println("|===========================================|");
				System.out.println("|            1. Course  ID                  |");
				System.out.println("|===========================================|");
				System.out.println("|            2. Course Name                 |");
				System.out.println("|===========================================|");
				System.out.println("|            3. Exit                        |");
				System.out.println("|===========================================|");
				System.out.println();
				System.out.println();
				
				System.out.println("Enter Your Choice from 1 and 2 :");
				int c1 = sc.nextInt();
				
				switch(c1)
				{
				case 1:
					System.out.println("Enter Your Course New Id :");
					course.setCid(sc.nextInt());
					break;
					
				case 2:
					System.out.println("Enter Your Course Name :");
					course.setCname(sc.next());
					System.out.println("Sucessfully Update !!!!!");
					break;
					
				case 3:
					c = false;
					break;
					
				default:
					System.out.println("Your Choice is Wrong Please Correct Your Choice From 1 to 2");
					
				}
			
			}
			break;
		case 2:
			boolean f = true;
			while(f)
			{
				System.out.println("-----------Faculty Update Manu---------------");
				System.out.println("|===========================================|");
				System.out.println("|            1. Faculty  ID                 |");
				System.out.println("|===========================================|");
				System.out.println("|            2. Faculty Name                |");
				System.out.println("|===========================================|");
				System.out.println("|            3. Exit                        |");
				System.out.println("|===========================================|");
				System.out.println();
				
				System.out.println("Enter Your Choice from 1 and 2 :");
				int f1 = sc.nextInt();
				
				switch(f1)
				{
				case 1:
					System.out.println("Enter Your Course New Id :");
					faculty.setFid(sc.nextInt());
					break;
					
				case 2:
					System.out.println("Enter Your Course Name :");
					faculty.setFname(sc.next());
					System.out.println("Sucessfully Update !!!!!");
					break;
					
				case 3:
					f = false;
					break;
					
				default:
					System.out.println("Your Choice is Wrong Please Correct Your Choice From 1 to 2");
				}
			}
			break;
			
		case 3:
			boolean b = true;
			while(b)
			{
				System.out.println("------------Batch Update Manu----------------");
				System.out.println("|===========================================|");
				System.out.println("|            1. Batch ID                    |");
				System.out.println("|===========================================|");
				System.out.println("|            2. Batch Name                  |");
				System.out.println("|===========================================|");
				System.out.println("|            3. Exit                        |");
				System.out.println("|===========================================|");
				System.out.println();
				
				System.out.println("Enter Your Choice from 1 and 2 :");
				int b1 = sc.nextInt();
				
				switch(b1)
				{
				case 1:
					System.out.println("Enter Your Course New Id :");
					batch.setBid(sc.nextInt());
					break;
					
				case 2:
					System.out.println("Enter Your Course Name :");
					batch.setBname(sc.next());
					System.out.println("Sucessfully Update !!!!!");
					break;
					
				case 3:
					b = false;
					break;
					
				default:
					System.out.println("Your Choice is Wrong Please Correct Your Choice From 1 to 2");
				}
			}
			break;
			
		case 4 :
			boolean s = true;
			while(s)
			{
				System.out.println("------------Student Update Manu--------------");
				System.out.println("|===========================================|");
				System.out.println("|            1. Student  ID                 |");
				System.out.println("|===========================================|");
				System.out.println("|            2. Student Name                |");
				System.out.println("|===========================================|");
				System.out.println("|            3. Exit                        |");
				System.out.println("|===========================================|");
				System.out.println();
				
				System.out.println("Enter Your Choice from 1 and 2 :");
				int s1 = sc.nextInt();
				
				switch(s1)
				{
				case 1:
					System.out.println("Enter Your Course New Id :");
					student.setSid(sc.nextInt());
					break;
					
				case 2:
					System.out.println("Enter Your Course Name :");
					student.setSname(sc.next());
					System.out.println("Sucessfully Update !!!!!");
					break;
					
				case 3:
					s = false;
					break;
					
				default:
					System.out.println("Your Choice is Wrong Please Correct Your Choice From 1 to 2");
				}
			}
		break;
		case 5:
			flag =  false;
			break;
			
		default:
			System.out.println("Your Choice is Wrong Please Correct Your Choice From 1 to 2");
			break;
			
		}
		}
		
		
	}

}
