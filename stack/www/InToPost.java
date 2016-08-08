package com.stack.www;

public class InToPost {
	private StackX theStack;
	private String input;
	private String output = "";
	
	public InToPost(String in){
		input = in;
		int stackSize = in.length();
		theStack = new StackX(stackSize);
	}
	
	public String doTrans(){
		for(int i = 0;i<input.length();i++){
			char ch = input.charAt(i);
			theStack.displayStack("for"+ch);
			switch(ch){
			case'+':
			case'-':
				gotOper(ch,1);
				break;
			case'*':
			case'/':
				gotOper(ch, 2);
				break;
			case'(':
				theStack.push(ch);
				break;
			case')':
				gotParen(ch);
				break;
			default:
				output = output + ch;
				break;
			}
		}
		while(!theStack.isEmpty()){
			theStack.displayStack("while");
			output = output + theStack.pop();
		}
		theStack.displayStack("end");
		return output;
	}

	private void gotParen(char ch) {
		while(!theStack.isEmpty()){
			char chx = theStack.pop();
			if(chx == '(')
				break;
			else
				output = output+chx;
		}
		
	}

	private void gotOper(char ch, int prec1) {
		
		while(!theStack.isEmpty()){
			char opTop = theStack.pop();
			if(opTop == '('){
				theStack.push(opTop);
				break;
			}
			else
			{
				int prec2;
				if(opTop=='+'||opTop=='-')
					prec2 = 1;
				else
					prec2 = 2;
				if(prec2<prec1){
					theStack.push(opTop);
					break;
				}
				else {
					output = output+opTop;
				}
			}
		}
		theStack.push(ch);
	}
}
