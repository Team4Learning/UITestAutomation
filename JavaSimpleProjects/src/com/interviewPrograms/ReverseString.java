package com.interviewPrograms;

import java.util.Scanner;

public class ReverseString {

	public static void main(String args[]){
		
		String s;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a string : ");
		
		s=sc.nextLine();
		
		System.out.print("After string reverse :");
		
		for(int i=s.length();i>0;--i){
			
			System.out.print(s.charAt(i-1));
		}
		
		
	}
	
	
}
