package com.zc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * List遍历
 * @author zc
 */
public class TestList {
	@Test
	public void testList1()
	{
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		//(1)使用for循环遍历List
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i));
		}
		//(2)使用增强for循环遍历List
		for(Integer i:list){
			System.out.println(i);
		}
		//(3)使用迭代器遍历List
		Iterator<Integer> it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	@Test
	public void testToArray(){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<5;i++){
			list.add(i);
		}
		Integer[] arr=list.toArray(new Integer[]{11,22,33,44,55,66,77,88});
		System.out.println(Arrays.toString(arr));//[0, 1, 2, 3, 4, null, 77, 88]
	}
	
	@Test
	public void testHugeCapacity(){
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<Integer.MAX_VALUE;i++){
			list.add(i);
		}
		System.out.println(list.size());
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
	
	@Test
	public void test04(){//一样无法清除
		List<String> list1=new LinkedList<String>();
		list1.add("呵呵1");
		list1.add("呵呵2");
		list1.add("呵呵3");
		list1.add("呵呵4");
		for(int i=0;i<list1.size();i++){
			list1.remove(i);
		}
		System.out.println(list1);
	}
	
}
