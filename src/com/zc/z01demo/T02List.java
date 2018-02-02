package com.zc.z01demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

/**
 * List相关api
 * thingkingInJava.holding.ListFeatures中包含list中的所有常用方法
 * @author flyingzc
 */
public class T02List
{
    @Test
    public void test01()
    {
        // 集合初始化时,尽量指定集合初始元素大小
    }
    
    @Test
    public void testCommonMethod()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        //isEmpty():return size == 0;
        if(list1 !=null && !list1.isEmpty())
        {
            //size():return size;
            list1.size();
            //clear():for(int i=0; i<size;i++){elementData[i] = null;} size=0; 
            list1.clear();
            //contains(Object o):return indexOf(o)>=0;
            list1.contains(1);
            //
            list1.containsAll(new ArrayList<Integer>());
            //若indexOf(null)则返回第一个null的下标.
            list1.indexOf(1);
            list1.lastIndexOf(1);
            list1.retainAll(new ArrayList<Integer>());
            
            // ArrayList的subList()方法返回的结果不可强转为ArrayList,会抛ClassCastException
            // 异常:java.util.RandomAccessSubList cannot be cast to java.util.ArrayList
            // 原因:subList()方法返回的是ArrayList的内部类SubList,并不是ArrayList,它是ArraList的一个视图
            // 对于SubList子列表的所有操作最终都会反映到原列表上
            // 在subList使用中,对 原集合元素个数的修改,会导致子列表的遍历,增加,删除均会产生ConcurrentModifyException
            list1.subList(0, 0);
        }
    }
    
    /**
     * 遍历list
     */
    @Test
    public void testTrace()
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        //add(int index, Integer element)
        list.add(0, 0);
        //(1)使用for循环遍历List
        System.out.println("(1)使用for循环遍历List");
        for (int i = 0; i < list.size(); i++)
        {
            System.out.println(list.get(i));
        }

        //(2)使用增强for循环遍历List
        System.out.println("(2)使用增强for循环遍历List");
        for (Integer i : list)
        {
            System.out.print(i);
            //不要使用这种方式判断该元素在list中的下标,因为list中放置的是可重复元素
            System.out.println(",下标" + list.indexOf(i));
        }

        //(3)使用迭代器遍历List
        System.out.println("(3)使用迭代器遍历List");
        Iterator<Integer> it = list.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
    }

    /**
     * T[] list.toArray(T[] array)
     * 作用:集合转数组,该方法不维护 对返回的数组的引用,即调用者可以自由的修改返回的数组.
     */
    @Test
    public void testToArray()
    {
        // 1.若不使用泛型(不传入参数),只能返回Object[]数组,不能对其强转
        List<String> list1 = Arrays.asList("1", "2", "3", "4", "5");//list1[1,2,3,4,5]
        Object[] arr1 = list1.toArray();
        System.out.println("arr1" + Arrays.toString(arr1));// arr1[1, 2, 3, 4, 5]
        
        // 2.若传入泛型数组,最好传入大小和list相同的数组
        // 2.1传入相同大小的数组
        String[] arr2 = list1.toArray(new String[list1.size()]);
        System.out.println("arr2" + Arrays.toString(arr2));// arr2[1, 2, 3, 4, 5]
        
        // 2.2入参分配的数组空间不够大时,toArray方法内部会重新分配内存,并返回新数组地址!!!.不会截取,数组元素个数和原list相同
        String[] arr3 = list1.toArray(new String[list1.size() - 1]);
        System.out.println("arr3" + Arrays.toString(arr3));// arr3[1, 2, 3, 4, 5]
        
        // 2.3若入参的数组元素大于实际所需,下标为[list.size()]出的元素被置为null,之前的被list覆盖,后面的数组元素保持原值
        String[] arr4 = list1.toArray(new String[] {"11", "22", "33", "44", "55", "66", "77", "88"});// 传入一个自定义的数组
        System.out.println("arr4" + Arrays.toString(arr4));// arr4[1, 2, 3, 4, 5, null, 77, 88]
        
        // 2.4若传入一个和list不匹配的T[]类型
        //Integer[] arr5 = list1.toArray(new Integer[list1.size()]);
        //System.out.println("arr5" + Arrays.toString(arr5));//ArrayStoreException
        
    }

    @Test
    public void testHugeCapacity()
    {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < Integer.MAX_VALUE; i++)
        {
            list.add(i);
        }
        System.out.println(list.size());
    }

    //-----------------------
    //测试remove()
    //-----------------------
    @Test
    public void testRemove()
    {
        ArrayList<Integer> list1 = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        //E remove(index):按下标移除,返回被删除的元素
        System.out.println(list1.remove(5));
        System.out.println(list1);
        //boolean remove(Object o):移除Object类型的具体的元素,返回boolean值.如果传入null,则只移除第一个null元素
        list1.remove((Object) 4);
        System.out.println(list1);
        
        list1 = new ArrayList<Integer>(Arrays.<Integer> asList(1, 2, 3, 4, 5, 6, 7));
        //从传入的集合中移除未包含在指定集合中的所有元素.返回的是并集
        list1.retainAll(Arrays.<Integer>asList(1,2,3,4,10,11,12));
        System.out.println(list1);
    }

    /**
     * 可以remove干净
     * !!!!:需要从后往前遍历才能清除干净,因为size()在改变
     */
    @Test
    public void testCanRemove1()
    {
        List<String> list1 = new ArrayList<String>();
        list1.add("呵呵1");
        list1.add("呵呵2");
        list1.add("呵呵3");
        list1.add("呵呵4");
        // size()每次循环remove()都会减少1
        for (int i = list1.size() - 1; i >= 0; i--)
        {
            list1.remove(i);
        }
        System.out.println(list1);
    }

    /**
     * 可以remove干净
     */
    @Test
    public void testCanRemove2()
    {
        List<String> list1 = new ArrayList<String>();
        list1.add("呵呵1");
        list1.add("呵呵2");
        list1.add("呵呵3");
        list1.add("呵呵4");
        // 先保留原始大小
        int orginalSize = list1.size();
        // 再每次都移除第0个元素即可,或者每次都移除最后一个元素
        for (int i = 0; i < orginalSize; i++)
        {
            list1.remove(0);
            //list1.remove(list1.size()-1);
        }
        System.out.println(list1);
    }

    /*remove不干净*/
    @Test
    public void testNotRemove()
    {
        List<String> list1 = new ArrayList<String>();
        list1.add("呵呵1");
        list1.add("呵呵2");
        list1.add("呵呵3");
        list1.add("呵呵4");
        //由于每次remove,会将之后的元素向前移动
        /*
         * i=0;size=4;remove(0);hhe2,heh3,heh4
         * i=1;size=3;remove(1);heh2,heh4
         * i=2;size=2;i<size不成立,循环结束,所以剩余heh2,heh4
         * */
        for (int i = 0; i < list1.size(); i++)
        {
            System.out.println(i);
            list1.remove(i);
        }
        System.out.println(list1);

    }

    @Test
    public void testNotRemove2()
    {//一样无法清除
        List<String> list1 = new LinkedList<String>();
        list1.add("呵呵1");
        list1.add("呵呵2");
        list1.add("呵呵3");
        list1.add("呵呵4");
        for (int i = 0; i < list1.size(); i++)
        {
            list1.remove(i);
        }
        System.out.println(list1);
    }

    /**
     * Arrays.asList()
     * public static <T> List<T> asList(T... a)
     * 返回一个受指定数组支持的固定大小的列表。（对返回列表的更改会“直接写”到数组。）此方法同 Collection.toArray() 一起，
     * 充当了基于数组的 API 与基于 collection 的 API 之间的桥梁。返回的列表是可序列化的，并且实现了 RandomAccess。 
     * 
     * 该方法返回的List底层表示的是不可变长度的数组,不能调整尺寸.若试图用add()或delete()添加或删除元素(试图改变数组尺寸),报
     * "Unsupported Operation"不支持的操作  错误
     * 
     * !!该方法返回的具体类型为Arrays.ArrayList类型,而不是平时见的ArrayList类型,底层是不可变长度的数组
     * 详细参见note_myCollection 1.1asList实现
     */
    @Test
    public void testAsList()
    {
        //注意,Arrays.asList()方法生成的list,不能改变长度.会报UnsupportedOperationException
        List<? extends Object> list1 = Arrays.asList(1, "2");
        List<String> list2 = Arrays.asList("a", "b");
        List<Integer> list3 = Arrays.asList(1, 2);
        List<? extends Number> list4 = Arrays.asList(1.0, 2);

        //UnsupportedOperationException
        //list2.addAll(Arrays.asList("c","d"));
        //UnsupportedOperationException
        //Collections.addAll(list2, "c","d","e");

        //List构造器接收 asList形成的list做参数
        List<String> list5 = new ArrayList<String>(list2);
        //此时可以修改这个list的长度
        list5.addAll(Arrays.asList("c", "d"));
        System.out.println(list5);

        /*ArrayList<Integer> list6=(ArrayList<Integer>) Arrays.asList(1,2);
        System.out.println(list6);*/
        //编译 运行通过
        List<Super> superList1 = Arrays.asList(new Sub1(), new Sub2());
        //编译不通过,说明只能识别到子类型,识别不到子子类型.
        //因为后面传入的最高只有Sub1类型,因此Arrays.asList会创建List<Sub1>类型,而List<Sub1>与List<Super>类型无任何关联
        //List<Super> superList2=Arrays.asList(new Subsub(),new Sub1());
        //自己指定泛型类型,显式类型参数说明
        List<Super> superList3 = Arrays.<Super> asList(new Subsub());
        //而Collections.addAll(Collection<? super T> c,T... elements)方法不会存在该问题,因为该方法接收的第一个参数就是目标集合,它可以从中获取泛型信息
    }
    
    @Test
    public void testExtends() 
    {
        // 泛型通配符<? extends T>来接收返回的数据,此写法的泛型集合不能使用add方法
        List<? extends Super> list1 = new ArrayList<Sub1>();
        // list1虽然实际存储的是Sub1,但是仍然不能添加Sub1对象
        // list1.add(new Sub1());
    }

}

class Super
{

}

class Sub1 extends Super
{

}

class Sub2 extends Super
{

}

class Subsub extends Sub1
{

}
