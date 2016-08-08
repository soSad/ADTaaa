package com.tree.www;

public class Tree {
	private Node root;
	
	public Node find(int key){
		Node current = root;
		while(current.iData!=key){
			if(current.iData<key){
				current = current.leftChild;
			}
			else{
				current = current.rightChild;
			}
			if(current == null)
				return null;
		}
		return current;
	}
	public void insert(int id,double value){
		Node newNode = new Node();
		newNode.iData = id;
		newNode.dData = value;
		if(root == null)
			root = newNode;
		else{
			Node current = root;
			Node parent;
			while(true){
				parent = current;
				if(id<current.iData){
					current = current.leftChild;
					if(current == null){
						parent.leftChild = newNode;
						return;
					}
				}
				else{
					current = current.rightChild;
					if(current == null){
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	
	}
	public void inOrder(Node localRoot){
		if(localRoot!=null){
			inOrder(localRoot.leftChild);
			System.out.println(localRoot.iData+"");
			inOrder(localRoot.rightChild);
		}
	}
	public Node minimum(){
		Node current,last;
		current = root;
		last = root;
		while(current != null){
			last = current;
			current = current.leftChild;
		}
		return last;
		
	}
	public boolean delete(int key){
		Node current = root;
		Node parent = root;
		boolean isLeftChild = true;
		
		while(current.iData!=key){
			parent = current;
			if(key<current.iData){
				isLeftChild = true;
				current = current.leftChild;
			}
			else{
				isLeftChild = false;
				current = current.rightChild;
			}
			if(current == null)
				return false;
		}
		if(current.leftChild==null && current.rightChild==null){
			if(current == root)
				root = null;
			else if(isLeftChild){
				parent.leftChild = null;
			}
			else
				parent.rightChild = null;
		}
		else if(current.leftChild == null){
			if(current == root)
				root = current.rightChild;
			else if(isLeftChild)
				parent.leftChild = current.rightChild;
			else
				parent.rightChild = current.rightChild;
		}
		else if(current.rightChild == null){
			if(current == root)
				root = current.leftChild;
			else if(isLeftChild)
				parent.leftChild = current.leftChild;
			else
				parent.rightChild = current.leftChild;
		}
		else{
			Node successor = getSuccessor(current);
			if(current == root)
				root = successor;
			else if(isLeftChild)
				parent.leftChild = successor;
			else
				parent.rightChild = successor;
			successor.leftChild = current.leftChild;
		}
		return true;
	}
	private Node getSuccessor(Node delNode) {
		Node successorParent = delNode;
		Node successor = delNode;
		Node current = delNode.rightChild;
		while(current!=null){
			successorParent = successor;
			successor = current;
			current = current.leftChild;
		}
		//if successor not right child,make connections
		if(successor != delNode.rightChild){
			successorParent.leftChild = successor.rightChild;
			successor.rightChild = delNode.rightChild;
		}
		return successor;
	}
}
