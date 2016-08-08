package com.stack.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfixApp {
	public static void main(String[] args) throws IOException{
		String input,output;
		while(true){
			System.out.println("enter infix:");
			System.out.flush();
			input = getString();
			if(input.equals("")){
				break;
			}
			InToPost theTrans = new InToPost(input);
			output = theTrans.doTrans();
			System.out.println(output);
		}
	}

	private static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader buffer = new BufferedReader(isr);
		String s = buffer.readLine();
		return s;
	}
}
