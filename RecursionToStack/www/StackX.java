package com.RecursionToStack.www;

public class StackX {
	private int maxSize;
	private Params[] stackArray;
	private int top;
	
	public StackX(int max){
		maxSize = max;
		stackArray = new Params[maxSize];
		top = -1;
	}
	public void push(Params p){
		stackArray[++top] = p;
	}
	public Params pop(){
		return stackArray[top--];
	}
	/**
	 * 简单的来说，++i 和 i++,在单独使用时，就是 i=i+1。
		而 a = ++i，相当于 i=i+1; a = i;
		而 a = i++，相当于 a = i; i=i+1;
	 */
	public Params peek(){
		return stackArray[top];
	}
}
