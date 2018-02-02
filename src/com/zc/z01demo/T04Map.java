package com.zc.z01demo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;

public class T04Map
{
    @Test
    public void testHashMap()
    {
        Map map1 = new HashMap();
        //put(Object,Object)
        map1.put("heh", "nimei");
        
        //key不能重复.后面这个重复的key可以放进去.但是会覆盖掉之前的value
        map1.put("heh", "....");
        map1.put(2, "sf");
        map1.put("a", 1);
        
        //HashMap的key或者value均可以为null
        map1.put(null, null);
        System.out.println(map1.size());
        System.out.println(map1);
        
        //通过key删除entry对
        map1.remove("heh");
        
        //!!!通过key的值来获取value的值
        map1.get("a");
        System.out.println(map1.get("a"));
        
        //以下也是通过key获取value.不是下标get(Object key)
        map1.get(2);
        System.out.println(map1.get(2));
        
        //清空
        map1.clear();
        System.out.println("大小" + map1.size());
    }

    /**
     * 优先使用entrySet便利Map类集合KV,而不是keySet方式进行遍历.
     * 因为:keySet其实是遍历了两次,一次是转为Iterator对象,另一次是从hashMap中取出
     * key所对应的value.而entrySet只是遍历了一次就把key和value都放到了entrySet中,效率更高.
     * 若是JDK8中,使用Map.foreach方法 
     */
    @Test
    public void traceMap()
    {
        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("heh", "nisdfdnf");
        map1.put("2", "haha");
        map1.put("3", "hehe");

        //===========1.遍历key集.也就是遍历一个Set==================
        Set<String> keySet = map1.keySet();
        for (String i : keySet)
        {
            System.out.println(i);
        }

        //set无法通过普通循环遍历
        for (int i = 0; i < keySet.size(); i++)
        {
            // 因为Set无法通过下标来取值啊
        }

        //forEach遍历
        for (String s : keySet)
        {
            System.out.println(s);
        }

        //迭代器遍历
        Iterator<String> its = keySet.iterator();
        while (its.hasNext())
        {
            System.out.println(its.next());
        }

        //=============2.遍历value集.==============
        //2.1
        Collection<Object> vals = map1.values();
        System.out.println("遍历value");
        for (Object obj : vals)
        {
            System.out.println(obj);
        }

        //2.2
        Iterator<Object> iterator = vals.iterator();
        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

        //=========3.遍历entries.即遍历Map============
        System.out.println("遍历entries");
        //3.1方式一
        //获取key
        Set<String> set2 = map1.keySet();

        for (String i : set2)
        {
            System.out.println(i + "->" + map1.get(i));
        }

        //3.2迭代器遍历Map.map1.entrySet():获取Map中的多个entry对
        System.out.println("迭代器遍历");
        Iterator<Map.Entry<String, Object>> it = map1.entrySet().iterator();
        while (it.hasNext())
        {
            Map.Entry<String, Object> entry = it.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());

        }
        //for循环是迭代器,可以在for里声明ite,防止迭代其他迭代器中的数据
        for (Iterator<Entry<String, Object>> ite = map1.entrySet().iterator(); ite.hasNext();)
        {
            Entry<String, Object> entry = ite.next();
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }

        //3.3增强for循环遍历Map.推荐.尤其容量大的时候
        System.out.println("增强for循环遍历Map");
        for (Map.Entry<String, Object> i : map1.entrySet())
        {
            System.out.println(i.getKey() + "->" + i.getValue());
        }

    }

    @Test
    public void TestLinkedHashMap()
    {
        //遍历的顺序和存放进去的顺序相同.因为使用链表
        Map<String, Object> map2 = new LinkedHashMap<>();
        map2.put("hehe", "323");
        map2.put("hehahe", "323");
        map2.put("heheaffa", "323");
        for (Map.Entry<String, Object> i : map2.entrySet())
        {
            System.out.println(i.getKey() + "-->" + i.getValue());
        }
    }

    @Test
    public void TestHashtable() throws Exception
    {
        //Hashtable不允许key或vale为null.t小写
        //Properties:用来处理属性文件.Key.value都是String类型
        Properties pros = new Properties();
        //传入load(InputStream类型)
        pros.load(new FileInputStream(new File("jdbc.properties")));
        //通过属性名user获取属性值root
        String user = pros.getProperty("user");
        String psw = pros.getProperty("password");
        System.out.println(user + "-->" + psw);
    }

    /**
     * 通过Map<String,List>创建复杂映射 
     */
    @Test
    public void testMapOfList()
    {
        Map<String, List<? extends Super>> map = new HashMap<String, List<? extends Super>>();
        map.put("zc", Arrays.<Super> asList(new Super(), new Sub1(), new Sub2()));
        map.put("zx", Arrays.asList(new Subsub()));
    }
    
    /**
     * 集合类               
     * Hashtable:key不允许null,value不允许null,父类Dictionary,线程安全
     * ConcurrentHashMap,key不允许null,value不允许null,父类AbstractMap,分段锁技术
     * TreeMap,key不允许null,value允许null,父类AbstractMap,线程安全
     * HashMap,key允许null,value允许null,父类AbstractMap,线程不安全
     */
    @Test
    public void testMapNull()
    {
        
    }
}
