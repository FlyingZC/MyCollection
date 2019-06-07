package com.zc.z01demo;

import java.util.*;

import org.junit.Test;

/**
 * @author flyingzc
 * Collections工具类
 */
public class T01Collections
{
    //Collections是操作集合的工具类.与Collection接口区别
    //Collections不仅可以操作Collection(即List或Set).还可以操作Map
    /**
     reverse(List):反转List,在list的size小于18时,采用swap实现.在大于等于18时
     shuffle(List):对List随机排序,SHUFFLE_THRESHOLD=5
     void rotate(List list, int distance) : 旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面。
     sort(List):自然顺序升序排序
     swap(List,int,int):交换list中的元素位置,底层使用list.set()方法实现
     max(List);
     
     addAll()
               同步控制synchronizedXxx():将集合包装成.解决线程安全问题
     
     Enumeration接口是Iterator迭代器的古老版本
      */
    @Test
    public void testCollection1()
    {
        List<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(3);
        list.add(3);
        list.add(-5);
        list.add(7);
        list.add(4);
        list.add(-9);
        list.add(-7);
        System.out.println("原始" + list);

        Collections.reverse(list);
        System.out.println("reverse" + list);

        Collections.shuffle(list);
        System.out.println("shuffle" + list);

        Collections.shuffle(list);
        System.out.println("shuffle" + list);

        Collections.sort(list);
        System.out.println("sort" + list);
        //调用compareTo实现    
        System.out.println(Collections.max(list));

        Collections.rotate(list, 4);
        System.out.println("Collections.rotate(list, 4):");
        System.out.println(list);

        // void sort(List list),按自然排序的升序排序
        Collections.sort(list);
        System.out.println("Collections.sort(list):");
        System.out.println(list);

        // void shuffle(List list),随机排序
        Collections.shuffle(list);
        System.out.println("Collections.shuffle(list):");
        System.out.println(list);

        // void swap(List list, int i , int j),交换两个索引位置的元素
        Collections.swap(list, 2, 5);
        System.out.println("Collections.swap(list, 2, 5):");
        System.out.println(list);

        // 定制排序的用法
        Collections.sort(list, new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println("定制排序后：");
        System.out.println(list);
    }

    /**
     * 查找,替换操作
     * int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序的
     *
     * int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
     *
     * int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
     *
     * void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素。
     *
     * int frequency(Collection c, Object o)//统计元素出现次数
     *
     * int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
     *
     * boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素
     */
    @Test
    public void test2() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        list.add(3);
        list.add(3);
        list.add(-5);
        list.add(7);
        list.add(4);
        list.add(-9);
        list.add(-7);
        ArrayList<Integer> arrayList2 = new ArrayList<Integer>();
        arrayList2.add(-3);
        arrayList2.add(-5);
        arrayList2.add(7);
        System.out.println("原始数组:");
        System.out.println(list);

        System.out.println("Collections.max(list):");
        System.out.println(Collections.max(list));

        System.out.println("Collections.min(list):");
        System.out.println(Collections.min(list));

        System.out.println("Collections.replaceAll(list, 3, -3):");
        Collections.replaceAll(list, 3, -3);
        System.out.println(list);

        System.out.println("Collections.frequency(list, -3):");
        System.out.println(Collections.frequency(list, -3));

        System.out.println("Collections.indexOfSubList(list, arrayList2):");
        System.out.println(Collections.indexOfSubList(list, arrayList2));

        System.out.println("Collections.binarySearch(list, 7):");
        // 对List进行二分查找，返回索引，List必须是有序的
        Collections.sort(list);
        System.out.println(Collections.binarySearch(list, 7));
    }

    /**
     * emptyXxx(): 返回一个空的、不可变的集合对象，此处的集合既可以是List，也可以是Set，还可以是Map。
     *
     * singletonXxx(): 返回一个只包含指定对象（只有一个或一个元素）的不可变的集合对象，此处的集合可以是：List，Set，Map。
     *
     * unmodifiableXxx(): 返回指定集合对象的不可变视图，此处的集合可以是：List，Set，Map。
     *
     * 上面三类方法的参数是原有的集合对象，返回值是该集合的”只读“版本。
     */
    @Test
    public void test3() {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(-1);
        arrayList.add(3);
        arrayList.add(3);
        arrayList.add(-5);
        arrayList.add(7);
        arrayList.add(4);
        arrayList.add(-9);
        arrayList.add(-7);

        HashSet<Integer> integers1 = new HashSet<>();
        integers1.add(1);
        integers1.add(3);
        integers1.add(2);

        Map scores = new HashMap();
        scores.put("语文" , 80);
        scores.put("Java" , 82);

        // Collections.emptyXXX();创建一个空的、不可改变的XXX对象
        List<Object> list = Collections.emptyList();
        System.out.println(list);//[]

        Set<Object> objects = Collections.emptySet();
        System.out.println(objects);//[]

        Map<Object, Object> objectObjectMap = Collections.emptyMap();
        System.out.println(objectObjectMap);//{}

        // Collections.singletonXXX();
        List<ArrayList<Integer>> arrayLists = Collections.singletonList(arrayList);
        System.out.println(arrayLists);//[[-1, 3, 3, -5, 7, 4, -9, -7]]

        // 创建一个只有一个元素，且不可改变的Set对象
        Set<ArrayList<Integer>> singleton = Collections.singleton(arrayList);
        System.out.println(singleton);//[[-1, 3, 3, -5, 7, 4, -9, -7]]

        Map<String, String> nihao = Collections.singletonMap("1", "nihao");
        System.out.println(nihao);//{1=nihao}

        // unmodifiableXXX();创建普通XXX对象对应的不可变版本
        List<Integer> integers = Collections.unmodifiableList(arrayList);
        System.out.println(integers);//[-1, 3, 3, -5, 7, 4, -9, -7]

        Set<Integer> integers2 = Collections.unmodifiableSet(integers1);
        System.out.println(integers2);//[1, 2, 3]

        Map<Object, Object> objectObjectMap2 = Collections.unmodifiableMap(scores);
        System.out.println(objectObjectMap2);//{Java=82, 语文=80}

        // 添加出现异常：java.lang.UnsupportedOperationException
        // list.add(1);
        // arrayLists.add(arrayList);
        // integers.add(1);
    }

    /**
     * public static <T> boolean addAll(Collection<? super T> c,T... elements)
     * 将所有指定元素添加到指定 collection 中。可以分别指定要添加的元素(使用可变参数)，或者将它们指定为一个数组。
     */
    @Test
    public void testAddAll()
    {
        List<Integer> list = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Integer[] array = new Integer[] {5, 6, 7};
        Collections.addAll(list, array);
        Collections.addAll(list, 8, 9, 10);

        //继承自Collection类的非静态addAll方法
        list.addAll(list);
        System.out.println(list);
    }

    @Test
    public void testEnumeration()
    {

    }
    
    /**
     * sort的几种方式 
     */
    @Test
    public void testSort()
    {
        String[] s1 = new String[10];
        Arrays.sort(s1);//对Object[]类型 进行排序

        List<String> list1 = new ArrayList<String>();
        Collections.sort(list1);

        int[] a = new int[10];
        Arrays.sort(a);
    }

    /**
     * ArrayList有关null的测试
     */
    @Test
    public void testNull()
    {
        List<String> s = new ArrayList<String>();
        //集合起初为null,但不包含"null" 任何引用类型均可赋值为null
        System.out.println(s.contains(null));//false.期初不包含null值
        s.add(null);//添加null值(即 空值)
        System.out.println(s.contains(null));//true

        List<Object> list2 = new ArrayList<Object>();
        System.out.println(list2.contains(null));//false
        list2.add(null);
        System.out.println(list2.contains(null));//true

        List<Integer> list3 = new ArrayList<Integer>();
        System.out.println(list3.contains(null));//false
        list3.add(null);
        System.out.println(list3.contains(null));//true
    }
}
