package com.stack.www;

public class BrackerChecker {
	private String input;
	
	public BrackerChecker(String in){
		input = in;
	}
	
	public void check(){
		int stackSize = input.length();
		StackX theStack = new StackX(stackSize);
		
		for(int i=0;i<input.length();i++){
			char ch = input.charAt(i);
			switch(ch){
			case'{':
			case'[':
			case'(':
				theStack.push(ch);
			case'}':
			case']':
			case')':
				if(!theStack.isEmpty()){
					char chx = theStack.pop();
					if(ch=='}' && chx!='{' ||
						ch==']' && chx!='[' ||
						ch==')' && chx!='(')
						System.out.println("error"+ch+"at"+i);
				}
				else 
					System.out.println("error"+ch+"at"+i);
				break;
			}
		}
		if(!theStack.isEmpty())
			System.out.println("error:missing right delimiter");
	}
}
