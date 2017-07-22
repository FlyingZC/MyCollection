package com.zc.testnull;

import java.util.ArrayList;
import java.util.List;

public class TestNull {
	public static void main(String[] args) {
		List<String> s=new ArrayList<String>();
		//集合起初为null,但不包含"null" 任何引用类型均可赋值为null
		System.out.println(s.contains(null));//false.期初不包含null值
		s.add(null);//添加null值(即 空值)
		System.out.println(s.contains(null));//true
		
		List<Object> list2=new ArrayList<Object>();
		System.out.println(list2.contains(null));//false
		list2.add(null);
		System.out.println(list2.contains(null));//true
		
		List<Integer> list3=new ArrayList<Integer>();
		System.out.println(list3.contains(null));//false
		list3.add(null);
		System.out.println(list3.contains(null));//true
	}
}
