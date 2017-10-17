package com.zc.my;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author 自己实现的ArrayList
 *
 */
public class MyArrayList<T> implements List<T>
{
    private Object[] elementData;

    private int size;

    public MyArrayList()
    {
        //调用有参构造方法,默认长度
        this(10);
    }

    public MyArrayList(int initialCapacity)
    {
        if (initialCapacity < 0)
        {
            try
            {
                throw new RuntimeException("数组大小不能小于0");
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        //根据传入的List大小创建数组
        this.elementData = new Object[initialCapacity];
    }

    public static void main(String[] args)
    {
        ArrayList list = new ArrayList();
    }

    @Override
    public int size()
    {
        /*if(elementData[0]==null){
        	size=0;
        }
        for(int i=elementData.length-1;i>=0;i--){
        	if(elementData[i]!=null){
        		size=i+1;
        	}
        }*/
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size == 0;
    }

    @Override
    public Iterator iterator()
    {
        return null;
    }

    @Override
    public Object[] toArray()
    {
        return null;
    }

    @Override
    public boolean remove(Object o)
    {
        for (int i = 0; i < elementData.length; i++)
        {
            if (elementData[i].equals(o))
            {
                for (int j = i; j < elementData.length - 1; j++)
                {
                    elementData[j] = elementData[j + 1];
                }
                elementData = Arrays.copyOf(elementData, elementData.length - 1);
            }
            return true;
        }
        return false;
    }

    @Override
    public void clear()
    {
        elementData = new Object[10];
    }

    @Override
    public <T> T[] toArray(T[] a)
    {
        return null;
    }

    @Override
    public boolean add(T e)
    {
        if (size == elementData.length)
        {
            elementData = Arrays.copyOf(elementData, elementData.length + 10);
        }
        if (elementData[0] == null)
        {
            elementData[0] = e;
        }
        else
        {
            for (int i = elementData.length - 1; i >= 0; i--)
            {
                if (elementData[i] != null)
                {
                    elementData[i + 1] = e;
                    System.out.println("添加" + e);
                    break;
                }
            }
        }
        size++;

        //Object[] newArr=new Object[elementData.length+1];
        /*for(int i=0;i<elementData.length;i++){
        	newArr[i]=elementData[i];
        }
        newArr[newArr.length-1]=e;
        elementData=newArr;*/
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public T get(int index)
    {
        return (T) elementData[index];
    }

    @Override
    public T set(int index, T element)
    {
        if (index < 0 || index > elementData.length - 1)
        {
            return null;
        }
        T oldElem = (T) elementData[index];
        elementData[index] = element;
        System.out.println("set...." + elementData[index]);
        return oldElem;
    }

    @Override
    public void add(int index, T element)
    {
        if (index < 0 || index > elementData.length - 1)
        {
            throw new RuntimeException("下标越界");
        }
        Object[] newArr = new Object[elementData.length + 1];
        for (int i = elementData.length - 1; i > index; i--)
        {
            newArr[i + 1] = elementData[i];
        }
        newArr[index] = element;
        elementData = newArr;
    }

    @Override
    public T remove(int index)
    {
        if (index < 0 || index > elementData.length - 1)
        {
            return null;
        }
        T oldElem = (T) (elementData[index]);
        for (int i = index; i < elementData.length - 1; i++)
        {
            elementData[i] = elementData[i + 1];
        }
        elementData = Arrays.copyOf(elementData, elementData.length - 1);
        return oldElem;
    }

    @Override
    public int indexOf(Object o)
    {
        for (int i = 0; i < elementData.length; i++)
        {
            if (elementData[i].equals(o))
            {
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object o)
    {
        for (int i = elementData.length - 1; i > 0; i--)
        {
            if (elementData[i].equals(o))
            {
                return i;
            }
        }
        return 0;
    }

    @Override
    public ListIterator<T> listIterator()
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        return null;
    }

    @Override
    public boolean contains(Object o)
    {
        for (int i = 0; i < elementData.length; i++)
        {
            if (elementData[i] == o)
                return true;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return Arrays.toString(elementData);
    }
}
