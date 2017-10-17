package com.zc.exer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*使用Map实现十个单词翻译*/
public class T04MapDanCi
{
    public static void main(String[] args)
    {
        Map<String, String> map1 = new HashMap<String, String>();
        map1.put("一", "one");
        map1.put("二", "two");
        map1.put("三", "three");
        System.out.println("输入");
        /*Scanner sc=new Scanner(System.in);
        String key=sc.next().toString();*/
        if (map1.containsKey("一"))
        {
            System.out.println(map1.get("一"));
        }
    }
}
