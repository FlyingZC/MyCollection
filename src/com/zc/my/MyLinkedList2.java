package com.zc.my;

public class MyLinkedList2<E>
{
    private Node<E> first;

    private Node<E> last;

    private int size;

    //**********add**********
    public boolean add(E e)
    {
        linkLast(e);
        return true;
    }

    private void linkLast(E e)
    {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (first == null)
        {
            first = newNode;
        }
        else
        {
            l.next = newNode;
        }
        size++;
    }

    //************add(int index,E e)
    public void add(int index, E e)
    {
        checkPositionIndex(index);
        if (index == size)//插在尾结点后面
            linkLast(e);
        else
            linkBefore(e, node(index));//要插入元素e,和当前index位置处的原始结点
    }

    //插入在尾结点前面(包括尾结点位置)的情况
    private void linkBefore(E e, Node<E> oldNode)
    {//要插入的元素e,要插入位置的原始结点oldNode
        Node<E> prev = oldNode.prev;
        Node<E> newNode = new Node<E>(prev, e, oldNode);
        oldNode.prev = newNode;
        if (prev == null)
        {//list中没有元素
            first = newNode;
        }
        else
        {
            prev.next = newNode;
        }
        size++;
    }

    private void checkPositionIndex(int index)
    {
        if (!isPositionIndex(index))
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    //是否是可插入下标
    private boolean isPositionIndex(int index)
    {
        return index >= 0 && index <= size;
    }

    //*************remove**********
    public E remove(int index)
    {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private E unlink(Node<E> x)
    {
        //先把node相关信息保存起来
        E element = x.item;
        Node<E> prev = x.prev;
        Node<E> next = x.next;
        //判断要删除的结点是否是头结点
        if (prev == null)
        {
            x.next = first;
        }
        else
        {
            prev.next = next;
            x.prev = null;//清空要删除节点的信息
        }

        //判断要删除的结点是否是尾结点
        if (next == null)
        {
            x.prev = last;
        }
        else
        {
            x.next.prev = prev;
            x.next = null;//
        }
        x.item = null;
        size--;//
        return element;
    }

    private void checkElementIndex(int index)
    {
        if (!isElementIndex(index))
        {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private boolean isElementIndex(int index)
    {
        return index >= 0 || index < size;
    }

    private String outOfBoundsMsg(int index)
    {
        return "index:" + index + ",size:" + size;
    }

    private Node<E> node(int index)
    {
        if (index < (size >> 1))
        {//大概一半位置
            Node<E> x = first;
            for (int i = 0; i < index; i++)
            {
                //i=0,x=x.next返回下标1处结点
                //i=index-1,返回index处结点
                x = x.next;
            }
            return x;
        }
        else
        {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
            {
                //i=size-1,x=size-2位置结点(last的前一个结点,last下标为size-1)
                //i=index+1,x=index位置结点
                x = x.prev;
            }
            return x;
        }
    }

    //*****************clear***************
    public void clear()
    {
        for (Node<E> x = first; x.next != null;)
        {
            Node<E> nextNode = x.next;//先保存下一个结点,再删除当前节点,放置找不到下一个结点
            x.prev = null;
            x.item = null;
            x.next = null;
            x = nextNode;//指向下一个结点
        }
        first = last = null;
        size = 0;
    }

    //*************set************
    public E set(int index, E e)
    {
        checkElementIndex(index);
        E oldValue = node(index).item;
        node(index).item = e;
        return oldValue;
    }

    //*****************get**************
    public E get(int index)
    {
        checkElementIndex(index);

        return node(index).item;
    }

    //*****************indexOf***********
    public int indexOf(E e)
    {
        int index = 0;
        if (e == null)
        {
            for (Node<E> x = first; x.next != null;)
            {
                x = x.next;
                if (x.item == null)
                {
                }
            }
        }
        return 0;
    }

    private static class Node<E>
    {
        private Node<E> prev;

        private E item;

        private Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next)
        {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }
}
