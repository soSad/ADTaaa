package com.heap.www;
/**
 * 基于数组的堆
 * @author 23176
 *
 */
public class Heap {
	private Node[] heapArray;
	private int maxSize;
	private int currentSize;
	
	public Heap(int size){
		maxSize = size;
		heapArray = new Node[maxSize];
		currentSize = 0;
	}
	
	public boolean isEmpty(){
		return currentSize==0;
	}
	
	public boolean insert(int key){
		if(currentSize==maxSize){
			return false;
		}
		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++);
		return true;
	}

	private void trickleUp(int index) {
		int parent = (index-1)/2;
		Node temp = heapArray[index];
		while(index>0 && heapArray[parent].getKey()<temp.getKey()){
			heapArray[index] = heapArray[parent];
			index = parent;
			parent = (parent-1)/2;
		}
		heapArray[index] = temp;
	}
	
	public Node remove(){
		Node root = heapArray[0];
		heapArray[0] = heapArray[currentSize];
		currentSize--;
		trickleDown(0);
		return root;
	}

	private void trickleDown(int index) {
		int largerChild;
		Node top = heapArray[index];
		//while node has at least one child
		while(index<currentSize/2){
			int left = index*2+1;
			int right = left+1;
			
			if(right<currentSize && 
					heapArray[left].getKey()<heapArray[right].getKey()){
				largerChild = right;
			}
			else{
				largerChild = left;
			}
			if(top.getKey()>=heapArray[largerChild].getKey()){
				break;
			}
			
			heapArray[index] = heapArray[largerChild];
			index = largerChild;
		}
		heapArray[index] = top;
	}
	
	public boolean change(int index,int newValue){
		if(index<0 || index>currentSize){
			return false;
		}
		int oldValue = heapArray[index].getKey();
		heapArray[index].setKey(newValue);
		if(oldValue<newValue){
			trickleUp(index);
		}
		else{
			trickleDown(index);
		}
		return true;
	}
}
