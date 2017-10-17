package com.zc.test;

import java.util.LinkedList;

public class TestLinkedList
{
    public static void main(String[] args)
    {
        LinkedList<String> list = new LinkedList<String>();
        for (int i = 0; i < 5; i++)
        {
            list.add("" + i);
        }
    }
}
