package com.recursion.www;

public class DArray {
	private long[] theArray;
	private int nElems;
	
	public DArray(int max){
		theArray = new long[max];
		nElems = 0;
	}
	public long peek(int i){
		return theArray[i];
		
	}
	public void insert(long value){
		theArray[nElems]= value;
		nElems++;
	}
	public void display(){
		for(int i = 0;i<nElems;i++){
			System.out.println(theArray[i]+" ");
		}
	}
	public void mergeSort(){
		long[] workspace = new long[nElems];
		recMergeSort(workspace,0,nElems-1);
	}
	private void recMergeSort(long[] workspace, int lowerBound, int upperBound) {
		if(lowerBound == upperBound)
			return;
		else{
			int mid = (lowerBound+upperBound)/2;
			
			recMergeSort(workspace, lowerBound, mid);
			
			recMergeSort(workspace, mid+1, upperBound);
			
			merge(workspace,lowerBound,mid+1,upperBound);
		}
		
	}
	private void merge(long[] workspace, int lowPtr, int highPtr, int upperBound) {
		
		int i = 0;
		int lowerBound = lowPtr;
		int mid = highPtr - 1;
		int  n = upperBound - lowerBound +1;
		while(lowPtr<=mid && highPtr <= upperBound){
			if(theArray[lowPtr] < theArray[highPtr]){
				workspace[i++] = theArray[lowPtr++];
			}
			else{
				workspace[i++] = theArray[highPtr++];
			}
		}
		while(lowPtr<=mid)
			workspace[i++] = theArray[lowPtr++];
		while(highPtr<=upperBound)
			workspace[i++] = theArray[highPtr++];
		for(i=0;i<n;i++){
			theArray[lowerBound+i] = workspace[i];
		}
	}
}
