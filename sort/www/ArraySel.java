package com.sort.www;

public class ArraySel {
	private long[] a;
	private int nextIndex;
	
	public ArraySel(int max){
		a = new long[max];
		nextIndex = 0;
	}
	public void Insert(long value){
		a[nextIndex] = value;
		nextIndex++;
	}
	public void display(){
		for(int i = 0; i < nextIndex; i++){
			System.out.println(i+":"+a[i]);
		}
		System.out.println();
	}
	public void selectionSort(){
		for(int i=0; i < nextIndex-1; i++){
			for(int j = 1+i; j < nextIndex; j++){
				if(a[i] > a[j]){
					swap(i,j);
				}
			}
		}
	}
	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		long temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
