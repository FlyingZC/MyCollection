package com.zc.exer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

public class T03Map {
	public static void main(String[] args) {
		Map<String,Object> map1=new HashMap<String,Object>();
		map1.put("heh",11);
		map1.put("ha",11);
		Iterator<Map.Entry<String,Object>> i=map1.entrySet().iterator();
		while(i.hasNext()){
			Map.Entry<String,Object> m=i.next();
			System.out.println(m.getKey()+m.getValue());
		}
	}
	
	@Test
	public void testTraceMap(){
	    //1.keys
	    Map<String,Object> map=new HashMap<String,Object>();
	    map.put("1", 1);
	    map.put("2", new Integer(1));
	    Set<String> keySet=map.keySet();
	    //set无法通过普通循环遍历
	    for(int i=0;i<keySet.size();i++){
	    }
	    //forEach遍历
	    for(String s:keySet){
	        System.out.println(s);
	    }
	    //迭代器遍历
	    Iterator<String> it=keySet.iterator();
	    while(it.hasNext()){
	        System.out.println(it.next());
	    }
	    //2.values
	    Collection<Object> values=map.values();
	    for(Object v:values){
	        System.out.println(v);
	    }
	    //3.entrySet
	    Iterator<Entry<String,Object>> iter=map.entrySet().iterator();
	    while(iter.hasNext()){
	        Entry<String,Object> entry=iter.next();
	        System.out.println(entry.getKey()+"->"+entry.getValue());
	    }
	    
	    for(Iterator<Entry<String,Object>> ite=map.entrySet().iterator();ite.hasNext();){
	        Entry<String,Object> entry=ite.next();
	        System.out.println(entry.getKey()+"->"+entry.getValue());
	    }
	    
	    //
	    for(Entry<String,Object> en:map.entrySet()){
	        System.out.println(en.getKey()+"->"+en.getValue());
	    }
	    
	}
	
}
