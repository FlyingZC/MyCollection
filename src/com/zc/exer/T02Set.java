package com.zc.exer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T02Set
{
    public static void main(String[] args)
    {
        Set<String> s = new HashSet<String>();
        s.add("呵呵");
        for (int i = 0; i < s.size(); i++)
        {
            //System.out.println(s.);
        }

        for (String i : s)
        {
            System.out.println(i);
        }

        Iterator<String> i = s.iterator();
        while (i.hasNext())
        {
            System.out.println(i.next());
        }

    }
}
