package com.tree234.www;

public class Tree234 {
	private Node root;
	
	public int find(long key){
		Node curNode = root;
		int childNumber;
		while(true){
			if((childNumber=curNode.findItem(key))!=-1){
				return childNumber;
			}
			else if(curNode.isLeaf())
				return -1;
			else
				curNode = getNextChild(curNode,key);
		}
	}

	private Node getNextChild(Node curNode, long key) {
		int i;
		//assume node is not empty,not full,not a leaf
		int numItems = curNode.getNumItems();
		for(i = 0;i<numItems;i++){			//for each item in node
			if(key < curNode.getItem(i).Data){
				return curNode.getChild(i);	//are we less?
			}
		}
		return curNode.getChild(i);		//we are greater
										//return right child
	}
	
	public void insert(long value){
		Node curNode = root;
		DataItem temp = new DataItem(value);
		
		while(true){
			if(curNode.isFull()){
				split(curNode);
				curNode = curNode.getParent();
				//search once
				curNode = getNextChild(curNode, value);
			}
			else if(curNode.isLeaf()){
				break;	//go insert
			}
			else
				curNode = getNextChild(curNode, value);
		}
		curNode.insertItem(temp);
	}

	private void split(Node curNode) {
		//assume node is full
		DataItem itemB,itemC;
		Node parent,child2,child3;
		int itemIndex;
		
		itemC = curNode.removeItem();
		itemB = curNode.removeItem();
		child2 = curNode.disconnectChild(2);
		child3 = curNode.disconnectChild(3);
		Node newRight = new Node();
		
		if(curNode==root){
			root = new Node();
			parent = root;
			root.connectChild(0, curNode);
		}
		else
			parent = curNode.getParent();
		
		//deal with parent
		itemIndex = parent.insertItem(itemB);
		int n = parent.getNumItems();
		//move parent's connections,就是把B右边数据对应的节点右移
		//one child to the right
		for(int i = n-1;i>itemIndex;i--){
			Node temp = parent.disconnectChild(i);
			parent.connectChild(i+1, temp);
		}
		parent.connectChild(itemIndex, newRight);
		
		//deal with newRight;
		newRight.insertItem(itemC);
		newRight.connectChild(0, child2);
		newRight.connectChild(1, child3);
	}
	public void displayTree(){
		recDislayTree(root,0,0);
	}

	private void recDislayTree(Node thisNode, int level, int childNumber) {
		System.out.println("level="+level+"child="+childNumber+"");
		thisNode.displayNode();
		
		//call ourselver for each child of this node
		int numItems = thisNode.getNumItems();
		for(int i = 0;i<numItems;i++){
			Node next = thisNode.getChild(i);
			if(next!=null){
				recDislayTree(next, level+1, i);
			}
			else 
				return;
		}
	}
}
