package com.tree.www;

public class Node implements Comparable<Node>{
	public int iData;
	public double dData;
	public String type = "";
	public char cData;
	public Node leftChild;
	public Node rightChild;
	
	public Node(int n) {
		iData = n;
	}
	public Node(){
		
	}

	public void displayNode(){
		System.out.println(dData);
	}
	@Override
	public int compareTo(Node in) {
		// TODO Auto-generated method stub
		return iData - in.iData;
	}
}
