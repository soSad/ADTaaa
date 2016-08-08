package com.stack.www;

import java.util.Scanner;

public class BracketsApp {
	public static void main(String[] args){
		String input;
		while(true){
			System.out.println("enter string containing delimiters");
			System.out.flush();
			Scanner in = new Scanner(System.in);
			input = in.nextLine();
			if(input.equals(""))
				break;
			
			BrackerChecker theChecker = new BrackerChecker(input);
			theChecker.check();
		}
	}
	

}
