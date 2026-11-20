package com.miniprojectcalculatorcorejava;

public class Calculator {

	private double lastResult;
	private int operationCount;
	
	Calculator()
	{
	this.lastResult = 0;
	this.operationCount = 0;
	}
	
	int add(int a,int b)
	{
		lastResult = a + b;
		operationCount ++;
		return a + b;
	}
	
	double add(double a,double b)
	{
		lastResult = a + b;
		operationCount ++;
		return a + b;
	}
	
	int add(int a,int b,int c)
	{
		lastResult = a + b + c;
		operationCount ++;
		return a + b + c;
	}
	
	double subtract(double a , double b)
	{
		lastResult = a - b;
		operationCount ++;
		return a - b;
	}
	
	double multiply(double a , double b)
	{
		lastResult = a * b;
		operationCount ++;
		return a * b;
	}
	
	double divide(double a , double b)
	{
		if(b == 0)
		{
			System.out.println("Cannot Divide By Zero");
			return lastResult ;
		}
		lastResult = a / b;
		operationCount ++;
		return a / b;
	}
	
	int reminder(int a , int b)
	{
		if(b == 0)
		{
			System.out.println("Cannot Divide By Zero");
			return (int) lastResult ;
		}
		
		lastResult = a % b;
		operationCount ++;
		return a % b;
	}
	
	 int power(int base, int exponent) 
	 {
		 if (exponent < 0)
		 {
			 System.out.println(" Exponent must be zero or more.");
			 return (int) lastResult;
		 }
		 int result = 1;
		 for(int i =  1;i<= exponent;i++)
		 {
			 result = result * base;
			 return result;
		 }
		 
		 lastResult = result;
		 operationCount ++;
		 return result;
	 }
	 
	 double square(double numbers)
	 {
		 lastResult = numbers * numbers;
		 operationCount ++;
		 return numbers * numbers;
	 }
	 
	 double getLastResult()  
	 {
		 return lastResult;
	 }
	 
	 int getOperationCount()  
	 {
		 return  operationCount;  
	 }
	 
}
