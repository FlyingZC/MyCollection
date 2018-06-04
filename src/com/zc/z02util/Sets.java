package com.zc.z02util;

import java.util.*;

/** Set相关的工具类
 * thinking in java :p641
 * @author Flyin
 *
 */
public class Sets
{
    /**
     * 合并
     * @param a
     * @param b
     * @return
     */
    public static <T> Set<T> union(Set<T> a, Set<T> b)
    {
        Set<T> result = new HashSet<T>(a);
        result.addAll(b);
        return result;
    }

    /**
     * 共有,交集
     * @param a
     * @param b
     * @return
     */
    public static <T> Set<T> intersection(Set<T> a, Set<T> b)
    {
        Set<T> result = new HashSet<T>(a);
        result.retainAll(b);
        return result;
    }

    /**
     * 从superset中移除subset包含的元素
     * @param superset
     * @param subset
     * @return
     */
    public static <T> Set<T> difference(Set<T> superset, Set<T> subset)
    {
        Set<T> result = new HashSet<T>(superset);
        result.removeAll(subset);
        return result;
    }

    /**
     * 除去交集外 的其他所有元素
     * @param a
     * @param b
     * @return
     */
    public static <T> Set<T> complement(Set<T> a, Set<T> b)
    {
        return difference(union(a, b), intersection(a, b));
    }
} ///:~
