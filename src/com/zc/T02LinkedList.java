package com.zc;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

/**
 * @author Flyingzc
 * LinkedList api
 */
public class T02LinkedList
{
    @Test
    public void test()
    {
        LinkedList<Integer> list=new LinkedList<Integer>(Arrays.<Integer>asList(1,2,3,4,5));
        list.add(6);
        //add(index,elem)
        list.add(6, 7);
        System.out.println(list);
        //java.lang.IndexOutOfBoundsException
        //list.add(8, 8);
        //System.out.println(list);
    }
    
    /**
     * 队列,先进先出
     */
    @Test
    public void testQueue()
    {
        
    }
    
}
