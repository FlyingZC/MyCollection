package com.zc.l03sortjdk;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class T01
{
    public static void main(String[] args)
    {
        String[] s1 = new String[10];
        Arrays.sort(s1);//对Object[]类型 进行排序

        List<String> list1 = new ArrayList<String>();
        Collections.sort(list1);

        int[] a = new int[10];
        Arrays.sort(a);
    }
}
