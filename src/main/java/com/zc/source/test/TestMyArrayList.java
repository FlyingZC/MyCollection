package com.zc.source.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zc.source.exer.MyArrayList;

public class TestMyArrayList
{
    public static void main(String[] args)
    {
        Map map = new HashMap();
        ArrayList<Integer> l = new ArrayList<Integer>();
        l.trimToSize();

        List<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        System.out.println(list.size());
        for (int i = 1; i < 8; i++)
        {
            list.add(i);
            System.out.println(list.size());
        }
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        Integer rem = list.remove(0);
        System.out.println("移除:" + rem);
        for (int i = 10; i < 16; i++)
        {
            list.remove(i);
        }

        for (int i = 12; i < 30; i++)
        {
            list.add(i);
        }
        list.set(15, 1000);
        System.out.println(list);

        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

    }
}
