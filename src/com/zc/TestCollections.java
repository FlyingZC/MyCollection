package com.zc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class TestCollections {
	//Collections是操作集合的工具类.与Collection接口区别
	//Collections不仅可以操作Collection(即List或Set).还可以操作Map
	/**
	 reverse(List):反转List
	 shuffle(List):对List随机排序
	 sort(List):自然顺序升序排序
	 swap(List,int,int)
	 max(List);
	 
	 同步控制synchronizedXxx():将集合包装成.解决线程安全问题
	 
	 Enumeration接口是Iterator迭代器的古老版本
	  */
	
	@Test
	public void testCollection1()
	{
		List<String> list=new ArrayList<String>();
		list.add("heh");
		list.add("bb");
		list.add("cc");
		System.out.println(list);
		
		Collections.reverse(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.shuffle(list);
		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		
	}
	
	@Test
	public void testEnumeration()
	{

	}
	
	
}
