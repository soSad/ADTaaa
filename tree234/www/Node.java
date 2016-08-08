package com.tree234.www;

public class Node {
	private static final int ORDER = 4;
	private int numItems;
	private Node parent;
	private Node[] childArray = new Node[ORDER];
	private DataItem[] itemArray = new DataItem[ORDER-1];
	
	public void connectChild(int childNum,Node child){
		childArray[childNum] = child;
		if(child!=null){
			child.parent = this;
		}
	}
	
	public Node disconnectChild(int childNum){
		Node temp = childArray[childNum];
		childArray[childNum]=null;
		return temp;
	}
	
	public Node getChild(int childNum){
		return childArray[childNum];
	}
	
	public Node getParent(){
		return this.parent;
	}
	
	public boolean isLeaf(){
		return (childArray[0]==null)?true:false;
	}
	
	public int getNumItems(){
		return numItems;
	}
	
	public DataItem getItem(int index){
		return itemArray[index];
	}
	
	public boolean isFull(){
		return (numItems == ORDER-1)?true:false;
	}
	
	public int findItem(long key){
		for(int i = 0;i<ORDER-1;i++){
			if(itemArray[i]== null)
				break;
			else if(itemArray[i].Data == key)
				return i;
		}
		return -1;
	}
	
	public int insertItem(DataItem newItem){
		//assumes node is not full
		numItems++;
		long newKye = newItem.Data;
		for(int i = ORDER-2;i>=0;i--){
			if(itemArray[i]==null){
				continue;
			}
			else{
				long itsKey = itemArray[i].Data;
				if(newKye < itsKey){
					itemArray[i+1] = itemArray[i];//shift it right
				}
				else{
					itemArray[i+1] = newItem;
					return i+1;
				}
			}
		}
		itemArray[0] = newItem;
		return 0;
	}
	//remove largest item
	public DataItem removeItem(){
		//assumes node not empty
		DataItem temp = itemArray[numItems-1];
		itemArray[numItems-1] = null;
		numItems--;
		return temp;
		
	}
	
	public void displayNode(){
		for(int i = 0;i<numItems;i++){
			itemArray[i].displayItem();
			System.out.println("/");
		}
	}
}
