package com.controller;

import java.util.Scanner;

import com.service.CMSService;
import com.serviceimpl.CMSServiceImpl;

public class CMSAdmin {

	public static void main(String[] args) {
		
				CMSService cms=new CMSServiceImpl();
				Scanner sc=new Scanner(System.in);
				
				
				boolean flag=true;
				while(flag)
				{
					System.out.println("****************** OPTIONS ******************");
					System.out.println();
					System.out.println("|===========================================|");
					System.out.println("|              1. ADD COURSE.               |");
					System.out.println("|===========================================|");
					System.out.println("|              2. DISPLAY COURSE.           |");
					System.out.println("|===========================================|");
					System.out.println("|              3. ADD FACULTY.              |");
					System.out.println("|===========================================|");
					System.out.println("|              4. DISPLAY FACULTY.          |");
					System.out.println("|===========================================|");
					System.out.println("|              5. ADD BATCH.                |");
					System.out.println("|===========================================|");
					System.out.println("|              6. DISPLAY BATCH.            |");
					System.out.println("|===========================================|");
					System.out.println("|              7. ADD STUDENT.              |");
					System.out.println("|===========================================|");
					System.out.println("|              8. DISPLAY STUDENT.          |");
					System.out.println("|===========================================|");
					System.out.println("|              9. UPDATE DETAILS.           |");
					System.out.println("|===========================================|");
					System.out.println("|             10. EXIT.                     |");
					System.out.println("|===========================================|");
					System.out.println();
					System.out.print("Please Enter Your Choice: ");
					int choice=sc.nextInt();
					
					switch(choice)
					{
					case 1:
						cms.addCourse();
						break;
						
					case 2:
						cms.displayCourse();
						break;
						
					case 3:
						cms.addFaculty();
						break;
						
					case 4:
						cms.displayFaculty();
						break;
						
					case 5:
						cms.addBatch();
						break;
						
					case 6:
						cms.displayBatch();
						break;
						
					case 7:
						cms.addStudent();
						break;
						
					case 8:
						cms.displayStudent();
						break;
						
					case 9:
						cms.updateDetails();
						break;
						
					case 10:
						System.out.println("THANK YOU........!");
						flag=false;
						break;
						
						default:
							System.out.println("You Entered Some Wrong Input. Please Enter Valid Input.");
							System.out.println();
							break;
					}
					
				}
				sc.close();	
			}

		}
