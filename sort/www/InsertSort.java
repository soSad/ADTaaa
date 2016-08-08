package com.sort.www;

public class InsertSort {
	public static void main(String[] args){
		int max = 10;
		ArrayInsert array = new ArrayInsert(max);
		
		array.Insert(11);
		array.Insert(10);
		array.Insert(33);
		array.Insert(88);
		array.Insert(22);
		array.Insert(0);
		array.InsertSort();
		
		array.Display();
	}
}
