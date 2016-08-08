package com.link.www;

public class Link {
	public int iData;
	public double dData;
	public Link next;
	
	public Link(int id,double d){
		iData = id;
		d = dData;
		next = null;
	}
	public void displayLink(){
		System.out.println("iData:"+iData+"dData:"+dData);
		
	}
}
