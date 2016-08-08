package com.RecursionToStack.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StackTriangleApp {
	static int theNumber;
	static int theAnswer;
	static StackX theStack;
	static int codePart;
	static Params theseParams;
	
	public static void main(String[] args) throws IOException{
		System.out.println("enter a number");
		theNumber = getInt();
		recTriangle();
		System.out.println("triangle="+theAnswer);
	}


	private static int getInt() throws IOException {
		String s = getString();
		return Integer.parseInt(s);
	}

	private static String getString() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(input);
		String s = buffer.readLine();
		return s;
	}

	private static void recTriangle() {
		theStack = new StackX(1000);
		codePart = 1;
		while(step()==false)
			;
		
	}


	private static boolean step() {
		switch(codePart){
		case 1:
			theseParams = new Params(theNumber, 6);
			theStack.push(theseParams);
			codePart = 2;
			break;
		case 2:
			theseParams = theStack.peek();
			if(theseParams.n == 1){
				theAnswer = 1;
				codePart = 5;	//exit
			}
			else
				codePart = 3;
			break;				//recursive call
		case 3:
			Params newParams = new Params(theseParams.n-1, 4);
			theStack.push(newParams);
			codePart = 2;
			break;
		case 4:
			theseParams = theStack.peek();
			theAnswer = theseParams.n+theAnswer;
			codePart = 5;
			break;
		case 5:
			theseParams = theStack.peek();
			codePart = theseParams.returnAdd;
			theStack.pop();
			break;
		case 6:
			return true;
		
		}
		return false;
	}
}
