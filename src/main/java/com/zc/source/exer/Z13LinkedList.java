package com.zc.source.exer;

//自己实现单链表
public class Z13LinkedList<E>
{
    private Node<E> first;

    private int size;

    public void add(E data)
    {
        Node<E> newNode = new Node<E>(data, null);
        if (first == null)
        {
            first = newNode;
        }
        else
        {
            Node<E> last = node(size - 1);
            last.next = newNode;
        }
        size++;
    }

    public void add(E data, int index)
    {
        checkForAdd(index);
        if (index == size)
        {
            add(data);
            return;
        }
        if (index == 0)
        {
            linkFirst(data);
            return;
        }
        linkBefore(data, node(index - 1));
    }

    //添加在开头
    private void linkFirst(E data)
    {
        //如果头结点为null
        if (first == null)
        {
            first = new Node<E>(data, null);
            return;
        }
        //头结点不为null
        Node<E> succ = first;
        Node<E> newNode = new Node<E>(data, succ);
        first = newNode;
        size++;
    }

    private void linkBefore(E data, Node<E> prev)
    {//succ为原先
        Node<E> succ = prev.next;
        Node<E> newNode = new Node<E>(data, succ);
        prev.next = newNode;
        size++;
    }

    private void checkForAdd(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IllegalArgumentException("下标越界");
        }
    }

    public Node<E> node(int index)
    {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
        {
            x = x.next;
        }
        return x;
    }

    //删
    public boolean remove(int index)
    {
        checkElementIndex(index);
        if (index == 0)
        {//若移除的为第一个
            if (first.next != null)
            {
                first = first.next;
                size--;
                return true;
            }
            if (first.next == null)
            {
                size--;
                first = null;
            }
        }
        //以下为下标不为0
        Node<E> prev = node(index - 1);
        Node<E> succ = prev.next;//要移除的元素
        if (index == size - 1)
        {//移除最后一个.上面已经排除已经排除只有一个元素的情况
            prev.next = null;
            succ = null;
            size--;
            return true;
        }
        //以下为 下标不为0且不为最后一个元素
        Node<E> next = succ.next;
        prev.next = next;
        succ = null;
        size--;
        return true;
    }

    //改
    public boolean set(int index, E element)
    {
        checkElementIndex(index);
        Node<E> node = node(index);
        node.item = element;
        return true;
    }

    //查
    public E get(int index)
    {
        checkElementIndex(index);
        return node(index).item;
    }

    private void checkElementIndex(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IllegalArgumentException("下标越界");
        }
    }

    public int size()
    {
        return size;
    }

    @Override
    public String toString()
    {
        Node<E> x = first;
        StringBuilder sb = new StringBuilder("[" + x.item.toString());
        for (int i = 0; i < size - 1; i++)
        {
            x = x.next;
            sb.append(" " + x.item.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    class Node<E>
    {
        private E item;

        private Node<E> next;

        public Node(E item, Node<E> next)
        {
            this.item = item;
            this.next = next;
        }
    }
}
