package com.miniprojectcalculatorcorejava;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Calculator c = new Calculator();
		
		int choice;
		
		while(true)
		{
			System.out.println("\n===== SIMPLE CALCULATOR ===== ");
			System.out.println("1. Add two numbers ");
			System.out.println("2. Add three numbers ");
			System.out.println("3. Subtract ");
			System.out.println("4. Multiply ");
			System.out.println("5. Divide ");
			System.out.println("6. Remainder ");
			System.out.println("7. Power ");
			System.out.println("8. Square ");
			System.out.println("9. Show last result and operation count ");
			System.out.println("0. Exit ");
			
			System.out.println("Enter your choice:");
			choice = sc.nextInt();
			
			switch(choice)
			{
			case 1:
				System.out.println("Enter your First Number:");
				int a = sc.nextInt();
				
				System.out.println("Enter your Second Number:");
				int b = sc.nextInt();
				
				System.out.println("Result = "+c.add(a, b));
				break;
				
			case 2:
				System.out.println("Enter your First Number:");
				double p = sc.nextDouble();
				
				System.out.println("Enter your Second Number:");
				double q = sc.nextDouble();
				
				System.out.println("Result = "+c.add(p, q));
				break;
				
			case 3:
				System.out.println("Enter your First Number:");
				int x = sc.nextInt();
				
				System.out.println("Enter your Second Number:");
				int y = sc.nextInt();
				
				System.out.println("Enter your Third Number:");
				int z = sc.nextInt(); 
				
				System.out.println("Result = "+c.add(x, y, z));
				break;
				
			case 4:
				System.out.println("Enter your First Number:");
				double d = sc.nextDouble();
				
				System.out.println("Enter your Second Number:");
				double e = sc.nextDouble();
				
				System.out.println("Result = "+c.subtract(d, e));
				break;
				
			case 5:
				System.out.println("Enter your First Number:");
				double f = sc.nextDouble();
				
				System.out.println("Enter your Second Number:");
				double g = sc.nextDouble();
				
				System.out.println("Result = "+c.multiply(f, g));
				break;
				
			case 6:
				System.out.println("Enter your First Number:");
				double h = sc.nextDouble();
				
				System.out.println("Enter your Second Number:");
				double i = sc.nextDouble();
				
				System.out.println("Result = "+c.divide(h, i));
				break;
				
			case 7:
				System.out.println("Enter First Whole Number:");
				int j = sc.nextInt();
				
				System.out.println("Enter Second Whole Number:");
				int k = sc.nextInt();
				
				System.out.println("Result = "+c.reminder(j, k));
				break;
				
			case 8:
				System.out.println("Enter Base:");
				int base = sc.nextInt();
				
				System.out.println("Enter Exponent:");
				int exponent = sc.nextInt();
				
				System.out.println("Result = "+c.power(base, exponent));
				break;
				
			case 9:
				System.out.println("Enter your Number:");
				double number = sc.nextDouble();
				
				System.out.println("Result = "+c.square(number));
				break;
				
			case 10:
				System.out.println("LastResult :"+c.getLastResult());
				System.out.println("OparationCount:"+c.getOperationCount());
				break;
				
			case 0:
				System.out.println("Thank you for using Calculator!");
				sc.close();
				return;
				
			default:
				System.out.println("Invalid Choice");
			}
			
		}
	}
}
