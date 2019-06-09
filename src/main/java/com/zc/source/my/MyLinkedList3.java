package com.zc.source.my;

public class MyLinkedList3<E>
{
    private int size;

    private Node<E> first;

    private Node<E> last;

    private class Node<E>
    {
        E elem;

        Node<E> prev;

        Node<E> next;

        public Node(Node<E> prev, E elem, Node<E> next)
        {
            this.elem = elem;
            this.prev = prev;
            this.next = next;
        }
    }

    public boolean add(E e)
    {
        linkLast(e);
        return true;
    }

    private void linkLast(E e)
    {
        Node<E> l = last;
        Node<E> newNode = new Node<E>(l, e, null);//新结点的前驱后继已经维护好了
        last = newNode;//设为尾结点
        if (first == null)
        {
            first = newNode;
        }
        else
        {
            //维护新结点的前驱结点
            l.next = newNode;
        }
    }

    public boolean contains(E e)
    {
        return indexOf(e) != -1;
    }

    //只有Object类型的参数
    private int indexOf(Object o)
    {
        int index = 0;
        if (o == null)
        {
            for (Node<E> x = first; x != null; x = x.next)
            {
                if (x.elem == null)
                    return index;//如果得到下标直接返回
                index++;//!!
            }
        }
        else
        {
            for (Node<E> x = first; x != null; x = x.next)
            {
                if (x.elem.equals(o))
                    return index;
                index++;
            }
        }
        return -1;
    }

    public E remove(int index)
    {
        checkElementIndex(index);
        return unlink(node(index));
    }

    private E unlink(Node<E> node)
    {
        E data = node.elem;
        Node<E> prev = node.prev;
        Node<E> next = node.next;
        //解除一个结点,可能为尾结点，也可能为头结点
        if (prev == null)
        {//如果是头结点
            first = next;
        }
        else
        {
            node.prev = null;
            prev.next = next;
        }
        if (next == null)
        {
            last = prev;
        }
        else
        {
            node.next = null;
            next.prev = prev;
        }
        node.elem = null;
        size--;
        return data;
    }

    private Node<E> node(int index)
    {
        if (index < (size >> 1))
        {//小于1/2
            Node<E> x = first;
            for (int i = 0; i < index; i++)
            {
                x = x.next;
            }
            return x;
        }
        else
        {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
            {
                x = x.prev;
            }
            return x;
        }
    }

    private void checkElementIndex(int index)
    {
        if (index < 0 || index > size)
            throw new IllegalArgumentException("下标越界");
    }

    public void clear()
    {
        for (Node<E> x = first; x != null;)
        {
            Node<E> nextNode = x.next;//先保存下一个结点，因为清空该结点后找不到下一个结点
            x.prev = null;
            x.elem = null;
            x.next = null;
            x = nextNode;
        }
        first = last = null;
        size = 0;
    }

    public E get(int index)
    {
        checkElementIndex(index);
        return node(index).elem;
    }

    public E set(int index, E data)
    {
        checkElementIndex(index);
        Node<E> x = node(index);
        E oldVal = x.elem;
        x.elem = data;
        return oldVal;
    }

    public boolean add(int index, E data)
    {
        checkPositionIndex(index);
        if (index == size)
        {
            linkLast(data);
        }
        else
        {
            linkBefore(data, node(index));
        }
        return true;
    }

    private void linkBefore(E data, Node<E> node)
    {
        Node<E> prev = node.prev;
        Node<E> newNode = new Node(prev, data, node);
        node.prev = newNode;//维护新结点与后继结点之间的关系
        if (prev == null)
        {
            first = node;
        }
        else
        {
            prev.next = newNode;
        }
    }

    private void checkPositionIndex(int index)
    {
        if (index < 0 || index > size)
        {
            throw new IllegalArgumentException("插入下标有问题");
        }
    }

}
