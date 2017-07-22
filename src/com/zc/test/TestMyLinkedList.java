package com.zc.test;

public class TestMyLinkedList {
	public static void main(String[] args) {
		MyLinkedList<Integer> list=new MyLinkedList<Integer>();
		list.add(0);
		list.add(1,1);
		list.add(2,2);
		list.add(3);
		System.out.println(list);
		//list.remove(0);
		System.out.println(list);
	}
}
