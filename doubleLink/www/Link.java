package com.doubleLink.www;

public class Link {
	public long Data;
	public Link previos;
	public Link next;
	
	public Link(long d){
		Data = d;
	}
	public void displayLink(){
		System.out.println("data:"+Data);
	}
}
