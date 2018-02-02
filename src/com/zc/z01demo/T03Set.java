package com.zc.z01demo;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import com.zc.Person;

/**
 * @author flyingzc
 * Set可快速对一个集合进行去重操作
 */
public class T03Set
{
    @Test
    public void testHashSet()
    {//Set底层存储无序	
        Set<Object> set1 = new HashSet<Object>();
        //add(Object类型)
        set1.add("heh");
        //相同的元素只能放进去一个.其他的放不进去
        //遍历出来的顺序和存放的先后顺序无关.但是每次都固定
        set1.add("heh");
        set1.add(1);
        //Person这种类要重写equals()和hashCode()方法.才能保证相同的元素也放不进去
        set1.add(new Person("zz", 1));
        set1.add(new Person("zz", 1));
        System.out.println(set1.size());
        System.out.println(set1);

        //遍历
        Iterator<Object> iterator = set1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testLinkedHashSet()
    {
        //测试LinkedHashSet() 遍历按照输入的先后顺序输出
        Set<Object> set1 = new LinkedHashSet<Object>();
        //add(Object类型)
        set1.add("heh");
        //相同的元素只能放进去一个.其他的放不进去
        //遍历出来的顺序和存放的先后顺序无关.但是每次都固定
        set1.add("heh");
        set1.add(1);
        //Person这种类要重写equals()和hashCode()方法.才能保证相同的元素也放不进去
        set1.add(new Person("zz", 1));
        set1.add(new Person("zz", 1));
        System.out.println(set1.size());
        System.out.println(set1);

        //遍历
        System.out.println("遍历");
        Iterator iterator = set1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    @Test
    public void testTreeSet()
    {
        //Person类需实现Comparable接口.才能使用TreeSet
        //TreeSet按照字母大小排序输出(字典顺序)...	
        //测试LinkedHashSet() 遍历按照输入的先后顺序输出
        //TreeSet里只能放一种类型的数据.当然如果使用泛型Set<Object> set=new TreeSet() 就能放所有Object类型的了
        Set<Object> set1 = new TreeSet<Object>();
        //add(Object类型)
        set1.add("heh");
        //相同的元素只能放进去一个.其他的放不进去
        //遍历出来的顺序和存放的先后顺序无关.但是每次都固定
        set1.add("heh");
        set1.add(1);
        //Person这种类要重写equals()和hashCode()方法.才能保证相同的元素也放不进去
        set1.add(new Person("zz", 1));
        set1.add(new Person("zz", 1));
        System.out.println(set1.size());
        System.out.println(set1);
        //遍历
        System.out.println("遍历");
        Iterator<Object> iterator = set1.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    /**
     * 遍历HashSet
     * @author zc
     */
    @Test
    public void testTraceSet()
    {
        Set<String> set = new HashSet<String>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("e");

        for (String s : set)
        {
            System.out.println(s);
        }

        Iterator<String> it = set.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

}
