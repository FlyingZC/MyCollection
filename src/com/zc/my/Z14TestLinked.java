package com.zc.my;

public class Z14TestLinked {
	public static void main(String[] args) {
		Z13LinkedList<Integer> list=new Z13LinkedList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(2);
		System.out.println(list);
		list.add(100,0);
		System.out.println(list);
		list.add(111,1);
		System.out.println(list);
		
		System.out.println("remove");
		list.remove(0);
		System.out.println(list);
		list.remove(list.size()-1);
		System.out.println(list);
		list.remove(1);
		System.out.println(list);
		
		
	}
}
