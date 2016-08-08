package com.sort.www;

public class ArrayBub {
	private long[] a;
	private int index;

	public ArrayBub(int max) {
		a = new long[max];
		index = 0;
	}

	public void insert(long value) {
		a[index] = value;
		index++;
	}

	public void display() {
		for (int i = 0; i < index; i++) {
			System.out.println(i + ":" + a[i]);
		}
		System.out.println();
	}

	public void bubbleSort(){
		System.out.println(index);
		for(int j = 0; j < index; j++){
			
		for(int i = 0; i < index-j-1; i++){
			if(a[i] > a[i+1]){
				swap(i,i+1);	//不能用swap(a[],a[]),交换的是副本，而不是本体，我猜的
				System.out.println(a[0]);
			}
		}
		}
	}

	private void swap(int l, int m) {
		// TODO Auto-generated method stub
		long temp = a[l];
		a[l] = a[m];
		a[m] = temp;
	}
}
