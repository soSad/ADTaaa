package com.recursion.www;

public class MergerSort {
	public static void main(String[] args){
		int max = 100;
		DArray arr = new DArray(max);
		
		arr.insert(34);
		arr.insert(14);
		arr.insert(224);
		arr.insert(22);
		arr.insert(55);
		arr.insert(25);
		arr.insert(63);
		
		arr.mergeSort();
		arr.display();
	
	
	}
	
}
