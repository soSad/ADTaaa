package com.doubleLink.www;

public class DoubleLinkedList {
	private Link first;
	private Link last;
	public DoubleLinkedList(){
		first = null;
		last = null;
	}
	public boolean isEmpty(){
		return first==null;
	}
	public void insetFirst(long value){
		Link newLink = new Link(value);
		if(isEmpty())
			last = newLink;
		else {
			first.previos = newLink;
			newLink.next = first;
			first = newLink;
		}
		
	}
	public void insertLast(long value){
		Link newLink = new Link(value);
		if(isEmpty())
			first = newLink;
		else {
			last.next = newLink;
			newLink.previos = last;
		}
		last = newLink;
	}
	public Link deleteFirst(){
		Link temp = first;
		if(first.next == null)
			last = null;
		else
			first.next.previos = null;
		first = first.next;
		return temp;
		
	}
	public Link deleteLast(){
		Link temp = last;
		if(first.next == null)
			first = null;
		else {
			last.previos.next = null;
		}
		last = last.previos;
		return temp;
	}
	public boolean insertAfter(long key,long data){
		Link current = first;
		while(current.Data!=key){
			current = current.next;
			if(current == null)
				return false;
		}
		Link newLink = new Link(data);
		if(current == last){
			newLink.next = null;
			last = newLink;
		}
		else{
			newLink.next = current.next;
			current.next.previos = newLink;
		}
		newLink.previos = current;
		current.next = newLink;
		return true;
	}
	public Link deleteKey(long key){
		Link current = first;
		while(current.Data!=key){
			current = current.next;
			if(current==null)
				return null;
		}
		if(current==first)
			first = current.next;
		else
			current.previos.next = current.next;
		if(current==last)
			last = current.previos;
		else
			current.next.previos = current.previos;
		return current;
	}
	public void displayForward(){
		System.out.println("list");
		Link current = first;
		while(current!=null){
			current.displayLink();
			current = current.next;
		}
	}
}		
