160916
(1)类的声明
public class LinkedList<E>
    extends AbstractSequentialList<E>
    implements List<E>, Deque<E>, Cloneable, java.io.Serializable
{...}

(2)内部类
private static class Node<E> {
    E item;//数据域
    Node<E> next;//后继结点
    Node<E> prev;//前驱结点

    Node(Node<E> prev, E element, Node<E> next) {
        this.item = element;
        this.next = next;
        this.prev = prev;
    }
}


(3)属性
//transient序列化时不会被序列化
transient int size = 0;//实际元素个数
transient Node<E> first;//头结点
transient Node<E> last;//尾结点

(4)构造方法
public LinkedList() {
}

public LinkedList(Collection<? extends E> c) {
    this();
    addAll(c);
}

(5)add
first和last属性只会在add时初始化,因为此时会出现添加第一个元素的现象
 void linkLast(E e) {
    final Node<E> l = last;
    final Node<E> newNode = new Node<>(l, e, null);
    last = newNode;//!!!将newNode设为last
    if (l == null)//如果l==null,代表list为空
        first = newNode;
    else
        l.next = newNode;
    size++;
    modCount++;
}

list.add(5);
newNode=(null,5,null)	last=(null,5,null)	first=(null,5,null)
list.add(6)
newNode=()




	
















