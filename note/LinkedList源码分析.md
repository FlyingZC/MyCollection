(1)类的声明
LinkedList实现List接口,Deque接口(双端队列)
LinkedList是双向链表

public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{}

(2)属性
transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
     //第一一个结点
    transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
     //最后一个结点
    transient Node<E> last;

(3)内部类Node:代表一个结点,一个结点由三个部分组成:前一个结点(地址),当前结点存储的内容,下一个结点(地址)
 private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

(4)构造方法
创建一个空的LinkedList
public LinkedList() {
    }

public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);//[1]
}

[1]处
public boolean addAll(Collection<? extends E> c) {
    return addAll(size, c);//[2]
}

[2]处
public boolean addAll(int index, Collection<? extends E> c) {
        checkPositionIndex(index);//[3]

        Object[] a = c.toArray();
        int numNew = a.length;
        if (numNew == 0)
            return false;

        Node<E> pred, succ;
        if (index == size) {
            succ = null;
            pred = last;
        } else {
            succ = node(index);
            pred = succ.prev;
        }

        for (Object o : a) {
            @SuppressWarnings("unchecked") E e = (E) o;
            Node<E> newNode = new Node<>(pred, e, null);
            if (pred == null)
                first = newNode;
            else
                pred.next = newNode;
            pred = newNode;
        }

        if (succ == null) {
            last = pred;
        } else {
            pred.next = succ;
            succ.prev = pred;
        }

        size += numNew;
        modCount++;
        return true;
    }

(5)add
public boolean add(E e) {
    linkLast(e);//[5.1]
    return true;
}

5.1处
//Links e as last element.
使e成为最后一个结点 
void linkLast(E e) {
	//用结点l保存当前最后一个结点(l和last指向同一个对象)
    final Node<E> l = last;
    //生成新结点,这个新结点的前一个元素为l,存储的元素为e,下一个结点为null
    final Node<E> newNode = new Node<>(l, e, null);
    //将newNode设置为最后一个结点
    last = newNode;
    //如果此时最后一个结点为null,说明此时LinkedList为null,里面还没有任何结点
    //newNode即是第一个结点
    if (l == null)
        first = newNode;
    else
    	//不然的话,将l和newNode连起来
        l.next = newNode;
    //链表长度加1    
    size++;
    modCount++;
}


add(int index,E element):该方法用于在指定下标处插入一个元素
public void add(int index, E element) {
    checkPositionIndex(index);//[5.2]
	//index和size相等,插在当前链表尾结点的后面(相当于add(E e)方法)
    if (index == size)
        linkLast(element);
    else
        linkBefore(element, node(index));//[5.4]
}

[5.2]处,检测插入下标.如果下标不合法,抛异常
private void checkPositionIndex(int index) {
    if (!isPositionIndex(index))//[5.3]
        throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
}

[5.3]处 下标>=0且<=size均合法,当等于size时,即插在末尾
private boolean isPositionIndex(int index) {
    return index >= 0 && index <= size;
}

[5.4]处,linkBefore(element, node(index));首先调用node方法,返回一个结点
Node<E> node(int index) {
    // assert isElementIndex(index);

    if (index < (size >> 1)) {
        Node<E> x = first;
        for (int i = 0; i < index; i++)
            x = x.next;
        return x;
    } else {
        Node<E> x = last;
        for (int i = size - 1; i > index; i--)
            x = x.prev;
        return x;
    }
}


[5.4]处
void linkBefore(E e, Node<E> succ) {succ为后继
    // assert succ != null;
    //获取要插入位置的
    final Node<E> pred = succ.prev;
    final Node<E> newNode = new Node<>(pred, e, succ);
    succ.prev = newNode;
    if (pred == null)
        first = newNode;
    else
        pred.next = newNode;
    size++;
    modCount++;
}

     