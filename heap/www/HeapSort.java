package com.heap.www;
/**
 * 堆排序
 * @author 23176
 *
 */
public class HeapSort {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public HeapSort(int size){
		maxSize = size;
		heapArray = new Node[maxSize];
		currentSize = 0;
	}
	public Node remove(){
		Node root = heapArray[0];
		heapArray[0] = heapArray[--currentSize];
		trickDown(0);
		return root;
	}
	public void trickDown(int i) {
		int largeChild;
		Node top = heapArray[i];
		while(i<currentSize/2){
			int left = i*2+1;
			int right = left+1;
			if(right<currentSize && 		//不是小于等于，会发生数组越界错误
					heapArray[left].getKey()<heapArray[right].getKey()){
				largeChild = right;
			}
			else{
				largeChild = left;
			}
			if(top.getKey()>=heapArray[largeChild].getKey()){
				break;
			}
			heapArray[i] = heapArray[largeChild];
			i = largeChild;
		}
		heapArray[i] = top;
	}
	public void displayArray(){
		for(int i = 0;i<maxSize;i++){
			System.out.println(heapArray[i].getKey());
		}
	}
	public void insertAt(int index,Node newNode){
		heapArray[index] = newNode;
	}
	public void increametSize(){
		currentSize++;
	}
}
