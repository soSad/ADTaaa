package com.hash.www;
/**
 * ¡¥µÿ÷∑∑®
 * @author 23176
 *
 */
public class HashLink {
	private SortedList[] hashArray;
	private int arraySize;
	
	public HashLink(int size){
		arraySize = size;
		hashArray = new SortedList[arraySize];
		//fill array with list
		for(int i = 0;i<arraySize;i++){
			hashArray[i] = new SortedList();
		}
	}
	public void displayTable(){
		for(int i = 0;i<arraySize;i++){
			System.out.println(i+"/");
			hashArray[i].displayList();
		}
	}
	public int hashFunc(int key){
		return key%arraySize;
	}
	public void insert(Link theLink){
		int key = theLink.getKey();
		int hashVal = hashFunc(key);
		hashArray[hashVal].insert(theLink);
	}
	public void delete(int key){
		int hashVal = hashFunc(key);
		hashArray[hashVal].delete(key);
	}
	public Link find(int key){
		int hashVal = hashFunc(key);
		Link theLink = hashArray[hashVal].find(key);
		return theLink;
	}
}
