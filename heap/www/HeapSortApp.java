package com.heap.www;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HeapSortApp {
	public static void main(String[] args) throws IOException{
		int size,j;
		System.out.println("enter number of items");
		size = getInt();
		HeapSort theHeap = new HeapSort(size);
		
		for(j=0;j<size;j++){
			int random = (int) (Math.random()*100);
			Node newNode = new Node(random);
			theHeap.insertAt(j, newNode);
			theHeap.increametSize();
		}
		for(j=size/2-1;j>=0;j--){
			theHeap.trickDown(j);
		}
		for(j=size-1;j>=0;j--){
			Node big = theHeap.remove();
			theHeap.insertAt(j, big);
		}
		theHeap.displayArray();
	}

	private static int getInt() throws IOException {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(input);
		String s = buff.readLine();
		return Integer.parseInt(s);
	}
}
