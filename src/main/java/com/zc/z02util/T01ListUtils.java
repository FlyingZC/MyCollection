package com.zc.z02util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

/**
 * @author flyingzc
 * List相关的工具方法
 */
public class T01ListUtils
{
    @Test
    public void testNull()
    {
        //会报空指针
        List<String> a = Arrays.asList(null);
    }
    
    @Test
    public void testDiff()
    {
        List<String> a = Arrays.asList("a","b","c","d","g");
        List<String> b = Arrays.asList("a","b","c","e","f");
        System.out.println(getDiffrent5(a, b));
    }
    
    /**
     * 比较两个 list中的差异元素
     * 我们的需求是找出两个List中的不同元素,那么我可以这样考虑：用一个map存放lsit的所有元素，其中的key为lsit1的各个元素，
     * value为该元素出现的次数,接着把list2的所有元素也放到map里，
     * 如果已经存在则value加1，最后我们只要取出map里value为1的元素即可，这样我们只需循环m+n次，大大减少了循环的次数。
     * @param list1
     * @param list2
     * @return
     */
    private static List<String> getDiffrent5(List<String> list1, List<String> list2)
    {
        long st = System.nanoTime();
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if (list2.size() > list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        Map<String, Integer> map = new HashMap<String, Integer>(maxList.size());
        for (String string : maxList)
        {
            map.put(string, 1);
        }
        for (String string : minList)
        {
            if (map.get(string) != null)
            { // 两个list中均有该元素
                map.put(string, 2);
                continue;
            }
            // list1中没有,list2中有
            diff.add(string);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            if (entry.getValue() == 1)
            {   //list1中有,list2中没有
                diff.add(entry.getKey());
            }
        }
        System.out.println("getDiffrent5 total times " + (System.nanoTime() - st));
        return diff;
    }
}
