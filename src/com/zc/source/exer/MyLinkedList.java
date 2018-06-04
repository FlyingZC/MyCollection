package com.zc.source.exer;

public class MyLinkedList<E>
{
    private Node<E> first;

    private Node<E> last;

    private int size;

    public MyLinkedList()
    {

    }

    //向链表尾结点后添加元素
    public void add(E e)
    {
        Node<E> newNode = new Node<E>();
        //判断链表是否为空
        if (first == null)
        {
            newNode.setPrev(null);
            newNode.setElement(e);
            newNode.setNext(null);

            first = newNode;
            last = newNode;
        }
        else
        {
            //设置newNode的属性.由于是双向链表,newNode设置prev
            //同时last也要设置next
            newNode.setPrev(last);
            newNode.setElement(e);
            newNode.setNext(null);
            //使得last的next域指向newNode	
            last.setNext(newNode);
            //将newNode设为尾结点
            last = newNode;
        }
        size++;//
    }

    public void add(int index, E e)
    {
        if (index < 0 || index > size)
        {
            throw new IllegalArgumentException("下标越界");
        }
        Node<E> newNode = new Node<E>();
        //链表中还没有任何元素
        if (first == null)
        {
            newNode.setPrev(null);
            newNode.setElement(e);
            newNode.setNext(null);
            first = newNode;
            last = newNode;
            size++;
            return;
        }
        //如果头结点的next域为null,newNode作为第二个结点(下标一),且为尾结点
        if (first.next == null)
        {
            newNode.setPrev(first);
            newNode.setNext(null);
            newNode.setElement(e);

            first.setNext(newNode);

            last = newNode;
            size++;
            return;
        }
        //如果插入在尾部
        if (index == size)
        {
            add(e);
            return;
        }

        Node<E> oldVal = node(index);
        //newNode的前驱指向oldVal的前一个结点,newNode的后继结点为oldVal的下一个结点
        newNode.setPrev(oldVal.prev);
        newNode.setNext(oldVal.next);
        //修改oldVal下一个结点的前驱节点为newNode
        oldVal.next.setPrev(newNode);
        //修改oldVal前一个结点的后继结点为newNode
        oldVal.prev.setNext(newNode);
        size++;
    }

    //返回size
    public int size()
    {
        return size;
    }

    //删
    public void remove(int index)
    {
        //
        Node temp = node(index);
    }

    //获取当前下标处的Node
    public Node<E> node(int index)
    {
        Node<E> temp = null;
        if (first != null)
        {//如果首结点不为空,遍历
            temp = first;
            for (int i = 1; i < index; i++)
            {
                temp = temp.next;
            }
        }
        return temp;
    }

    class Node<E>
    {
        private Node<E> prev;

        private E element;

        private Node<E> next;

        public Node()
        {

        }

        public Node(Node<E> prev, E element, Node<E> next)
        {
            this.prev = prev;
            this.element = element;
            this.next = next;
        }

        public Node<E> getPrev()
        {
            return prev;
        }

        public void setPrev(Node<E> prev)
        {
            this.prev = prev;
        }

        public E getElement()
        {
            return element;
        }

        public void setElement(E element)
        {
            this.element = element;
        }

        public Node<E> getNext()
        {
            return next;
        }

        public void setNext(Node<E> next)
        {
            this.next = next;
        }
    }
}
