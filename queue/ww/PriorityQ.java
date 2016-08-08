package com.queue.ww;

public class PriorityQ {
	private int maxSize;
	private long[] queArray;
	private int nItems;
	
	public PriorityQ(int s){
		maxSize = s;
		queArray = new long[maxSize];
		nItems = 0;
	}
	
	public void Insert(long value){
		int i;
		if(nItems == 0){
			queArray[nItems] = value;
			nItems++;
			}
		else{
			for(i=nItems-1;i>=0;i--){
				if(value > queArray[i])
					queArray[i+1] = queArray[i];
				else
					break;
			}
			queArray[i+1] = value;
			nItems++;
		}
	}
	public long remove(){
		return queArray[--nItems];
	}
	public long peek(){
		return queArray[nItems-1];
	}
	public boolean isEmpty(){
		return(nItems==0);
	}
	public boolean ifFull(){
		return(nItems == maxSize);
	}
}
