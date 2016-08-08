package com.stack.www;

public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;
	
	public StackX(int max){
		maxSize = max;
		stackArray = new char[maxSize];
		top = -1;
	}
	public void push(char value){
		top++;
		stackArray[top] = value;
	}
	public char pop(){
		return stackArray[top--];
	}
	public char peek(){
		return stackArray[top];
	}
	
	public boolean isEmpty(){
		return top == -1?true:false;
	}
	public boolean isFull(){
		return(top == maxSize-1);
	}
	public void displayStack(String s){
		System.out.println(s);
		System.out.println("statck{bottom-->top}:");
		for(int i = 0;i<size();i++){
			System.out.println(peekN(i));
		}
	}
	private char peekN(int i) {
		// TODO Auto-generated method stub
		return stackArray[i];
	}
	private int size() {
		// TODO Auto-generated method stub
		return top+1;
	}
}
