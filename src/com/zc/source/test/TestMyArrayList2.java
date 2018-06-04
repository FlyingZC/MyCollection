package com.zc.source.test;

import com.zc.source.my.MyArrayList2;

public class TestMyArrayList2
{
    public static void main(String[] args)
    {
        MyArrayList2 list = new MyArrayList2();
        list.add(1);
        list.add(3);
        list.add(3);
        list.add(3);
        System.out.println(list.get(2));
        list.set(2, 100);
        list.add(2, 222222);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }
    }
}
