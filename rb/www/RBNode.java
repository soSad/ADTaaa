package com.rb.www;

public class RBNode<T extends Comparable<T>>{
	boolean color;
	T key;
	RBNode<T> left;
	RBNode<T> right;
	RBNode<T> parent;
	
	public RBNode(T key,boolean color,RBNode<T> parent,RBNode<T> left,RBNode<T> right){
		this.key = key;
		this.color = color;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}
	public T getKey(){
		return key;
	}
	public String toString(){
		return " "+key+(this.color == false?"R":"B");
	}
	
}
