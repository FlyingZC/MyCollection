package com.zc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

/**
 * @author Flyin
 * Collections工具类
 */
public class T01Collections
{
    //Collections是操作集合的工具类.与Collection接口区别
    //Collections不仅可以操作Collection(即List或Set).还可以操作Map
    /**
     reverse(List):反转List,在list的size小于18时,采用swap实现.在大于等于18时
     shuffle(List):对List随机排序,SHUFFLE_THRESHOLD=5
     sort(List):自然顺序升序排序
     swap(List,int,int):交换list中的元素位置,底层使用list.set()方法实现
     max(List);
     
     addAll()
               同步控制synchronizedXxx():将集合包装成.解决线程安全问题
     
     Enumeration接口是Iterator迭代器的古老版本
      */

    @Test
    public void testCollection1()
    {
        List<String> list = new ArrayList<String>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        System.out.println("原始"+list);

        Collections.reverse(list);
        System.out.println("reverse"+list);
        
        Collections.shuffle(list);
        System.out.println("shuffle"+list);
        
        Collections.shuffle(list);
        System.out.println("shuffle"+list);
        
        Collections.sort(list);
        System.out.println("sort"+list);
        //调用compareTo实现    
        System.out.println(Collections.max(list));
    }
    
    /**
     * public static <T> boolean addAll(Collection<? super T> c,T... elements)
     * 将所有指定元素添加到指定 collection 中。可以分别指定要添加的元素(使用可变参数)，或者将它们指定为一个数组。
     */
    @Test
    public void testAddAll()
    {
        List<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,3,4));
        Integer[] array=new Integer[]{5,6,7};
        Collections.addAll(list, array);
        Collections.addAll(list, 8,9,10);
        
        //继承自Collection类的非静态addAll方法
        list.addAll(list);
        System.out.println(list);
    }
    
    @Test
    public void testEnumeration()
    {

    }

}
