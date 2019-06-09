package com.zc.z01demo;

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
        LinkedList<Integer> list = new LinkedList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5));
        list.add(6);
        //add(index,elem)
        list.add(6, 7);
        System.out.println(list);
        //java.lang.IndexOutOfBoundsException 若在下标不存在出添加会抛异常
        //list.add(8, 8);
        //System.out.println(list);
    }

    /**
     * 队列,先进先出
     */
    @Test
    public void testQueue()
    {
        LinkedList<Integer> list = new LinkedList<Integer>();
        // ==== Collection接口里的方法
        list.add(1);
        list.remove(1);// remove 元素
        
        // ==== Queue接口里的方法
        // offer: 将指定元素添加到此列表的末尾（最后一个元素）。
        list.offer(2);
        
        // element: 获取但不移除此列表的头（第一个元素）。
        list.element();
        // peek: 获取但不移除此列表的头（第一个元素）。
        list.peek();
        
        // poll: 获取并移除此列表的头（第一个元素）
        list.poll();
        
        // ==== Deque接口里的方法
        list.addFirst(1);
        list.addLast(2);
        list.getFirst();
        list.getLast();
        list.offer(1);
        list.offerFirst(1);
        list.offerLast(1);
        
        list.peek();
        list.peekFirst();
        list.peekLast();
        
        list.poll();
        list.pollFirst();
        list.pollLast();
        
        list.pop();
        list.push(1);
        
        list.removeFirst();
        list.removeLast();
    }

}
