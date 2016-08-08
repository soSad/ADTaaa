package com.sort.www;

public class BubbleSort {
	
	public static void main(String[] args){
		int max = 100;
		ArrayBub array = new ArrayBub(max);
		
		array.insert(88);
		array.insert(77);
		array.insert(99);
		array.insert(22);
		array.insert(33);
		array.insert(77);
		
		array.bubbleSort();
		array.display();
	}

}
