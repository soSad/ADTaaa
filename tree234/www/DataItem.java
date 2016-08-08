package com.tree234.www;

public class DataItem {
	public long Data;
	
	public DataItem(long value){
		Data = value;
	}
	public DataItem(){
		super();
	}
	public void displayItem(){
		System.out.println("/"+Data);
	}
}
