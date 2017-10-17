package com.zc.test;

import com.zc.my.MyLinkedList2;

public class TestMyLinkedList2
{
    public static void main(String[] args)
    {
        MyLinkedList2<Integer> list = new MyLinkedList2<>();
        list.add(0);
        list.add(1);
        list.remove(0);
    }
}
