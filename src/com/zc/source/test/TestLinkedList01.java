package com.zc.source.test;

import java.util.LinkedList;

public class TestLinkedList01
{
    public static void main(String[] args)
    {
        LinkedList<Integer> l = new LinkedList<Integer>();
        l.add(1);
        l.add(2);
        l.contains(3);
        l.remove(1);
        System.out.println(l);
    }
}
