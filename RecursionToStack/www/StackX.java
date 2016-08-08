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
	 * �򵥵���˵��++i �� i++,�ڵ���ʹ��ʱ������ i=i+1��
		�� a = ++i���൱�� i=i+1; a = i;
		�� a = i++���൱�� a = i; i=i+1;
	 */
	public Params peek(){
		return stackArray[top];
	}
}
