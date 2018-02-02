package com.zc.z01demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

/**
 * @author Flyin
 * 迭代器
 */
public class T06Iterator
{
    @Test
    public void testIterator()
    {
        //对了,Arrays.asList产生的list不能变更长度,UnsupportedOperationException
        //List<Integer> list=Arrays.<Integer>asList(1,2,3,4,5,6,7);
        List<Integer> list = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        Iterator<Integer> it = list.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
            //若要remove(),必须先next()
            it.remove();
        }
        System.out.println(list);
    }

    /**
     * 采用for的iterator,采用for的好处是,不会用错迭代器 
     */
    @Test
    public void testIterator2()
    {
        List<Integer> list = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        //此时it的作用域仅限于for内,不会使用错误
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); it.next(), it.remove())
        {

        }
        System.out.println(list);

        List<Integer> list2 = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        for (Iterator<Integer> it = list2.iterator(); it.hasNext();)
        {
            it.next();
            it.remove();
        }
        System.out.println(list2);
    }

    @Test
    public void testListIterator()
    {
        List<Integer> list = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        ListIterator<Integer> it = list.listIterator();
        for (; it.hasNext();)
        {
            /*
            1:1
            2:2
            3:3
            4:4
            5:5
            6:6
            7:7
            */
            System.out.println(it.next() + ":" + it.nextIndex());
        }
        //????注意输出结果,可能会令人困惑.但是没问题
        for (; it.hasPrevious();)
        {
            /*
            7:5 
            6:4
            5:3
            4:2
            3:1
            2:0
            1:-1
            */
            System.out.println(it.previous() + ":" + it.previousIndex());
        }

        //迭代器从头开始遍历,所以it.hasPrevious()为false,以下不输出
        for (ListIterator<Integer> it2 = list.listIterator(); it.hasPrevious();)
        {
            System.out.println(it2.previous() + ":" + it2.previousIndex());
        }

    }
    
    @Test
    public void testForEach()
    {
        // 不要再foreach循环里进行元素的remove/add操作.remove元素请使用Iterator方式,
        // 若并发操作,需要对Iterator对象加锁
        ArrayList<String> list1 = new ArrayList<String>(Arrays.<String>asList("1", "2"));
        for (String elem : list1) 
        { //??? "1"可以正确移除,但是"2"则会抛ConcurrentModificationException
            if("1".equals(elem))
            {
                list1.remove(elem);
            }
        }
        System.out.println(list1);
        
        // 可以使用Iterator遍历移除元素
        ArrayList<String> list2 = new ArrayList<String>(Arrays.<String>asList("1", "2"));
        Iterator<String> it = list2.iterator();
        while (it.hasNext())
        {
            it.next();// !!!一定要先next,再remove
            it.remove();
        }
        System.out.println(list2);
    }
}
