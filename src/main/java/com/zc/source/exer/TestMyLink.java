package com.zc.source.exer;

public class TestMyLink
{
    public static void main(String[] args)
    {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        for (int i = 0; i < 5; i++)
        {
            list.add(i, i);
        }
        System.out.println(list);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.node(i).getElement());
        }
        System.out.println("***********");
        list.add(3, 33333);
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.node(i).getElement());
        }
    }
}
