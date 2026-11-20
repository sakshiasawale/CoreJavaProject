package com.aatmminiprojectforcorejava;

public class Account {

	private int accountNo;
	private int pin;
	private double balance;
	private double withdrawnToday;
	private int lastTxnType;
	private double lastTxnAmount;
	
	Account(int accountNo, int pin, double balance)
	{ 
		this.accountNo=accountNo;
		this.pin = pin;
		this.balance= balance;
		this.withdrawnToday=0;
		this.lastTxnType=0;
		this.lastTxnAmount=0;
	}
	
	boolean verifyPin(int enteredPin) 
	{
		return pin == enteredPin;
	}
	
	boolean deposit(double amount)  
	{
		if(amount <0)
		{
			System.out.println("Amount must be greater than zero.");
			return false;
		}
		balance = balance + amount;
		
		lastTxnType = 1;
		lastTxnAmount = amount;
		
		return true;
	}
	
	boolean withdraw(double amount)
	{
		if(amount <0)
		{
			System.out.println("Amount must be greater than zero.");
			return false;
		}
		
		if(amount % 100!= 0)
		{
			System.out.println(" Amount must be a multiple of 100 ");
			return false;
		}
		
		if(amount > 10000)
		{
			System.out.println("Maximum withdrawal per transaction is 10000.");
			return false;
		}
		
		if(amount > 20000)
		{
			System.out.println("Daily withdrawal limit is 20000.");
			return false;
		}
		if(balance - amount < 500)
		{
			System.out.println("Minimum balance of 500 must be maintained.");
			return false;
		}
		
		balance = balance - amount;
		withdrawnToday = withdrawnToday + amount;
		
		lastTxnType = 2;
		lastTxnAmount = amount;
		
		return true;
	}
	
	boolean  changePin(int oldPin, int newPin) 
	{
		if(pin != oldPin)
		{
			System.out.println("Old PIN is incorrect.");
			return false;
		}
		
		if(newPin < 1000 || newPin > 999 )
		{
			System.out.println("New Pin must be 4 digit");
			return false;
		}
		
		pin = newPin;
		return true;
	}
	
	double  getBalance()  
	{
		return balance;
	}
	
	int getAccountNo()
	{
		return accountNo;
	}
	
	void showLastTransaction()  
	{
		switch(lastTxnType)
		{
		case 0:
			System.out.println("Not transaction yet.");
			break;
			
		case 1:
			System.out.println("Last Transaction :Deposite of"+lastTxnAmount);
			break;
			
		default:
			System.out.println("Invalid Transaction.");
		}
	}
}
