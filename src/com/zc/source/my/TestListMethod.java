package com.zc.source.my;

import java.util.ArrayList;
import java.util.List;

public class TestListMethod
{
    public static void main(String[] args)
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            System.out.println(i);
            list.add(i);
        }
        System.out.println(list.size());
    }
}
