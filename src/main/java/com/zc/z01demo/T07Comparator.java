package com.zc.z01demo;

import java.util.Comparator;

import org.junit.Test;

import com.zc.Person;

/**
 * @author flyingzc
 * JDK7版本以上,Comparator要满足 自反性,传递性,对称性.不然Arrays.sort,
 * Collections.sort会报IllegalArgumentException异常
 * 1.自反性:x,y比较结果和y,x的比较结果相反
 * 2.传递性:x>y,y>z,则x>z
 * 3.对称性:x=y,则x,z比较结果和y,z比较结果相同
 */
public class T07Comparator
{
    @Test
    public void test01()
    {
        new Comparator<Person>()
        {

            @Override
            public int compare(Person p1, Person p2)
            {
                if (p1.getAge() == p2.getAge())
                {// 相等情况要处理
                    return 0;
                }
                // 大小情况也要处理
                return p1.getAge() > p2.getAge() ? 1 : -1;
            }
            
        };
    }
}
