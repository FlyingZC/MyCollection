package com.zc.test;

public class Node<E> {
	Node<E> prev;
	E element;
	Node<E> next;
	public Node(){
		
	}
	public Node(Node<E> prev,E element,Node<E> next){
		this.prev=prev;
		this.element=element;
		this.next=next;
	}
	public Node<E> getPrev() {
		return prev;
	}
	public void setPrev(Node<E> prev) {
		this.prev = prev;
	}
	public Object getElement() {
		return element;
	}
	public void setElement(E element) {
		this.element = element;
	}
	public Node<E> getNext() {
		return next;
	}
	public void setNext(Node<E> next) {
		this.next = next;
	}
}
