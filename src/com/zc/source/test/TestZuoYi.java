package com.zc.source.test;

public class TestZuoYi
{
    public static void main(String[] args)
    {//左移
        System.out.println(1 << 30);//1073741824
        //0100 0000,0000 0000,0000 0000,0000 0000
        System.out.println(Integer.toBinaryString(new Integer(1 << 30)));
        //0111,1111 1111,1111 1111,1111 1111,1111 总共三十二为，第一位为符号位，再加以就以1开头就表示负数了
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));
    }
}
