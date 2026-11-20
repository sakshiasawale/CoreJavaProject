package com.aatmminiprojectforcorejava;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Account a = new Account(1001,1234,5000);
		
		System.out.println("===== ATM MACHINE =====");
		
		boolean loginSuccess = false;
		
		for (int i = 1;i<=3;i++)
		{
			System.out.println("Entered a Pin:");
			int enteredPin = sc.nextInt();
			
			if(a.verifyPin(enteredPin))
			{
				System.out.println("Login SuccessFully");
				loginSuccess = true;
				break;
			}
			else
			{
				System.out.println("Wrong Pin.");
			}
			
			if(i == 3)
			{
				System.out.println("Card Block.");
			}
		}
		
		if(!loginSuccess)
		{
			sc.close();
			return;
		}
		
		int choice;
		
		while(true)
		{
			System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Change PIN");
            System.out.println("5. Last Transaction");
            System.out.println("0. Exit");
            System.out.println("");

            System.out.println("Enter your Choice: ");
            choice= sc.nextInt();
            
            switch(choice)
            {
            case 1:
            	System.out.println("Account No:"+a.getAccountNo());
            	
            	System.out.println("Current Balance"+a.getBalance());
            	break;
            	
            case 2:
            	System.out.println("Enter Deposit Amount:");
            	double depositAmount = sc.nextDouble();
            	
            	if(a.deposit(depositAmount))
            	{
            		System.out.println("Deposite SuccessFully.");
            		System.out.println("Current Balance:"+a.getBalance());
            	}
            	break;
            	
            case 3:
            	System.out.println("Enter withdrawal amount:");
            	double withdrawAmount = sc.nextDouble();
            	
            	if(a.withdraw(withdrawAmount))
            	{
            		System.out.println("Withdrawal successfully.");
            		System.out.println("Please Collect Your Cash.");
            		System.out.println("Current Balance:"+a.getBalance());
            	}
            	break;
            	
            case 4:
            	System.out.println("Enter old Pin:");
            	int oldPin = sc.nextInt();
            	
            	System.out.println("Enter New Pin:");
            	int newPin = sc.nextInt();
            	
            	if(a.changePin(oldPin, newPin))
            	{
            		System.out.println("Pin Chnaged Successfully.");
            	}
            	break;
            	
            case 5:
            	a.showLastTransaction();
            	break;
            	
            case 0:
            	System.out.println("Thank you for using ATM");
            	sc.close();
            	return;
            	
            default:
            	System.out.println("Invalid Choice.");
            }
		}
	}
	
	
}
