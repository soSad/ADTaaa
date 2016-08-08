package com.sort.www;

public class ArrayInsert {
	
	private long[] a;
	private int nElems;
	
	public ArrayInsert(int max){
		a = new long[max];
		nElems = 0;
	}
	public void Insert(long value){
		a[nElems] = value;
		nElems++;
	}
	public void Display(){
		for(int i = 0; i < nElems; i++){
			System.out.println(i+":"+a[i]);
		}
		System.out.println();
	}
	public void InsertSort(){
		int in,out;
		for(out=1;out<nElems;out++){
			long temp = a[out];
			in = out;
			while(in>0 && a[in-1]>=temp){  //>就是从小到大，<从大到小
				a[in] = a[in-1];
				in--;
			}
			a[in] = temp;
		}
	}
}
