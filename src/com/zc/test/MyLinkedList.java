package com.zc.test;

public class MyLinkedList<E>
{
    private Node<E> first;

    private Node<E> last;

    private int size;

    public void add(E e)
    {
        Node<E> newNode = new Node<E>();
        if (first == null)
        {//没有任何元素,添加第一个元素,first,last初始化
            newNode.setPrev(null);
            newNode.setNext(null);
            newNode.setElement(e);
            //设置first,last
            first = last = newNode;
        }
        else
        {
            newNode.setPrev(last);
            newNode.setElement(e);
            newNode.setNext(null);

            last.setNext(newNode);

            last = newNode;
        }
        size++;
    }

    public int size()
    {
        return size;
    }

    public E get(int index)
    {
        rangeCheck(index);
        Node<E> myNode = node(index);
        return myNode.element;
    }

    private void rangeCheck(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IllegalArgumentException("下标越界");
        }
    }

    public E remove(int index)
    {
        rangeCheck(index);
        Node<E> myNode = node(index);

        /*Node<E> up=myNode.prev;
        Node<E> down=myNode.next;
        up.next=down;
        down.prev=up;*/
        myNode.next.prev = myNode.prev;
        myNode.prev.next = myNode.next;
        size--;//!!
        return myNode.element;
    }

    //将通过下标获取Node结点的代码抽取出来
    public Node<E> node(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IllegalArgumentException("下标越界");
        }
        Node<E> temp = first;
        for (int i = 0; i < index; i++)
        {
            temp = temp.next;
        }
        return temp;
    }

    public void add(int index, E e)
    {
        rangeCheckForAdd(index);
        Node<E> newNode = new Node<E>();
        newNode.setElement(e);
        if (index == size)
        {
            add(e);
        }
        if (index == 0)
        {
            System.out.println("zcundo");
        }
        Node<E> oldNode = node(index);
        Node<E> prevNode = oldNode.prev;
        newNode.setNext(oldNode);
        newNode.setPrev(prevNode);

        prevNode.setNext(newNode);
        oldNode.setPrev(newNode);
        size++;
    }

    private void rangeCheckForAdd(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IllegalArgumentException("插入下标越界");
        }
    }

    @Override
    public String toString()
    {
        return trace();
    }

    public String trace()
    {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++)
        {
            builder.append(get(i)).append(",");
        }
        builder.append("]");
        return builder.toString();
    }
}
