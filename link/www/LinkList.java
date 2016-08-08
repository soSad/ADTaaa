package com.link.www;

public class LinkList {
	private Link first;
	
	public LinkList(){
		first = null;
	}
	public void insertFirst(int id,double d){
		Link newLink = new Link(id, d);
		newLink.next = first;
		first = newLink;
	}
	public Link find(int key){
		Link current = first;
		while(current.iData!=key){
			if(current.next == null)
				return null;
			else
				current = current.next;
		}
		return current;
	}
	public Link delete(int key){
		Link current = first;
		Link previous = first;
		while(current.iData!=key){
			if(current.next == null)
				return null;
			else{
			previous = current;
			current = current.next;
			}
			}
		if(current == first)
			first = first.next;
		else
			previous.next = current.next;
		return current;
	}
	public void displayList(){
		System.out.println("List:");
		Link current = first;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
	}
}
