package com.zc.exer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

public class T01List {
	public static void main(String[] args) {
		List<String> a=new ArrayList<String>();
		a.add("呵呵");
		for(int i=0;i<a.size();i++){
			System.out.println(a.get(i));
		}
		
		for(String s:a){
			System.out.println(s);
		}
		
		Iterator<String> i=a.iterator();
		while(i.hasNext()){
			System.out.println(i.next());
		}
	}
	
	@Test
	public void test01(){
		List<String> a=new ArrayList<String>();
		a.add("呵呵1");
		a.add("呵呵2");
		a.add("呵呵3");
		a.add("呵呵4");
		a.remove("呵呵3");
		for(int i=0;i<a.size();i++){
			a.remove(i);
		}
		for(String s:a){
			System.out.println(s);
		}
		System.out.println(a);
	}
	
	/*!!!!:需要从后往前遍历才能清除干净*/
	@Test
	public void test02(){
		List<String> list1=new ArrayList<String>();
		list1.add("呵呵1");
		list1.add("呵呵2");
		list1.add("呵呵3");
		list1.add("呵呵4");
		for(int i=list1.size()-1;i>=0;i--){
			list1.remove(i);
		}
		System.out.println(list1);
	}
	/*remove不干净*/
	@Test
	public void test03(){
		List<String> list1=new ArrayList<String>();
		list1.add("呵呵1");
		list1.add("呵呵2");
		list1.add("呵呵3");
		list1.add("呵呵4");
		//由于每次remove,会将之后的元素向前移动
		/*
		 * i=0;size=4;remove(0);hhe2,heh3,heh4
		 * i=1;size=3;remove(1);heh2,heh4
		 * i=2;size=2;i<size不成立,循环结束,所以剩余heh2,heh4
		 * */
		for(int i=0;i<list1.size();i++){
			System.out.println(i);
			list1.remove(i);
		}
		System.out.println(list1);
		
	}
	
}
