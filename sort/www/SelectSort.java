package com.sort.www;

public class SelectSort {
	public static void main(String[] args){
		int max = 10;
		ArraySel array  = new ArraySel(max);
		
		array.Insert(11);
		array.Insert(33);
		array.Insert(88);
		array.Insert(22);
		array.Insert(0);
		array.selectionSort();
		
		array.display();
	}
}
