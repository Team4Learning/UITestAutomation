package com.javapractice;

import java.util.Scanner;

public class SumOfTwoNumbersUsingScanner {
	
	public static void main(String[] args) {
		
		int num1,num2,sum;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter first number :");
		
		num1=sc.nextInt();
		
		System.out.println("Enter second number :");
		
		num2 =sc.nextInt();
		
		sc.close();
		
		sum=num1+num2;
		
		System.out.println("Sum of two numbers : " +sum);
		
		
	}

}
