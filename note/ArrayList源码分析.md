160913
ensureCapacityInternal:确保内部的容量
ensureExplicitCapacity:确保明确的容量
hugeCapacity:巨大的容量
grow
(1)
public class ArrayList<E> extends AbstractList<E>
	implements List<E>, RandomAccess, Cloneable, java.io.Serializable{
	...
}

(2)属性
private static final long serialVersionUID = 8683452581122892189L;

    /**默认初始化容量
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;
    
    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * The array buffer into which the elements of the ArrayList are stored.
     * The capacity of the ArrayList is the length of this array buffer. Any
     * empty ArrayList with elementData == EMPTY_ELEMENTDATA will be expanded to
     * DEFAULT_CAPACITY when the first element is added.
     */
    private transient Object[] elementData;

    /**
     * The size of the ArrayList (the number of elements it contains).
     *包含元素的数量
     * @serial
     */
    private int size;
    //数组最大容量
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

(3)构造方法
  public ArrayList(int initialCapacity) {
        super();
        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal Capacity: "+
                                               initialCapacity);
        this.elementData = new Object[initialCapacity];
    }

    public ArrayList() {
        super();
        this.elementData = EMPTY_ELEMENTDATA;//当不传入大小时,默认是一个空的数组
    }
	//根据其他集合构造List
    public ArrayList(Collection<? extends E> c) {
        elementData = c.toArray();
        size = elementData.length;
        // c.toArray might (incorrectly) not return Object[] (see 6260652)
        if (elementData.getClass() != Object[].class)//toArray返回的可能不是Object[]类型
            elementData = Arrays.copyOf(elementData, size, Object[].class);//[1]调用该方法返回Object[]数组
    }
    
    [1].Arrays类中的copyOf方法
    public static <T,U> T[] copyOf(U[] original, int newLength, Class<? extends T[]> newType) {
        T[] copy = ((Object)newType == (Object)Object[].class)
            ? (T[]) new Object[newLength]
            : (T[]) Array.newInstance(newType.getComponentType(), newLength);
        System.arraycopy(original, 0, copy, 0,
                         Math.min(original.length, newLength));
        return copy;
    }
    
(4)add方法
  public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!![2]
        elementData[size++] = e;//添加元素e,随后size+1
        return true;
    }
 
 [2]处调用ensureCapacityInternal(size+1)保证每次添加元素时数组容量够用
   private void ensureCapacityInternal(int minCapacity) {
        if (elementData == EMPTY_ELEMENTDATA) {//如果elementData是空数组
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);//最小容量是size+1或默认容量(10)中的最大值
        }
        ensureExplicitCapacity(minCapacity);//[3]
    }   
    
  [3]处调用ensureExplicitCapacity(minCapacity)方法  
   private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // overflow-conscious code
        if (minCapacity - elementData.length > 0)//如果指定的容量超出了elementData数组的现有容量,要扩容
            grow(minCapacity);//[4]
    }        
    
  [4]处调用了grow(minCapcity)实现扩容
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//新容量为旧的数组容量+旧的数组容量右移一位
        if (newCapacity - minCapacity < 0)//和minCapacity比较,至少也要能容纳新添加进来的元素
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);//[5]
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);//数组扩容
    }  
    
  [5]处调用hugeCapacity(minCapacity)
   private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow.容量超出Integer最大值(即为负数),内存溢出
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?//最大容量为Integer.MAX_VALUE或 MAX_ARRAY_SIZE
            Integer.MAX_VALUE :
            MAX_ARRAY_SIZE;
    } 
    
(5)
  public void add(int index, E element) {
        rangeCheckForAdd(index);//[6]

        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);//将数组elementData从index开始的元素均向后移动一位
        elementData[index] = element;//index处添加element
        size++;//size++;
    }
    
    //[6]处对要add位置的index进行下标检查
   private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }      
     首先判断指定位置index是否超出elementData的界限，之后调用ensureCapacity调整容量（若容量足够则不会拓展），
     调用System.arraycopy将elementData从index开始的size-index个元素复制到index+1至size+1的位置
     （即index开始的元素都向后移动一个位置），然后将index位置的值指向element。      
(6)addAll    
将要添加的集合调用toArray()转换为数组,并得到数组长度numNew.然后确保elementData的容量足够添加新的集合.
将要添加的集合中的所有元素复制到elementData从size位置往后的位置,修改size.
 public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  // Increments modCount
        System.arraycopy(a, 0, elementData, size, numNew);
        size += numNew;
        return numNew != 0;//如果要添加的元素中没有元素,返回false
    }
(7)addAll
public boolean addAll(int index, Collection<? extends E> c) {
        rangeCheckForAdd(index);//下标检查

        Object[] a = c.toArray();
        int numNew = a.length;
        ensureCapacityInternal(size + numNew);  //确保容量
		//从index及其以后的所有元素都需要移动,以便插入新的集合元素
        int numMoved = size - index;
        //如果需要移动,将index及其以后的所有元素移动到从index+numNew及其以后的位置处
        if (numMoved > 0)
            System.arraycopy(elementData, index, elementData, index + numNew,
                             numMoved);
		//将要添加的集合复制进来
        System.arraycopy(a, 0, elementData, index, numNew);
        size += numNew;
        return numNew != 0;
    }
  
(8)clear
将集合中所有元素的引用设置为null,让垃圾回收器去解决吧.别忘了把size设置为0,代表现在list中没有元素
 public void clear() {
        modCount++;
        // clear to let GC do its work
        for (int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }
  
(9)indexOf:该方法返回集合中要查询元素第一次出现的下标
 public int indexOf(Object o) {
    if (o == null) {//如果要查询的元素为null
        for (int i = 0; i < size; i++)
        //直接找到elementData中元素为null的下标并返回即可
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = 0; i < size; i++)
        //遍历集合,如果equals,则返回下标
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;//查无,则返回-1
}    

(10)contains:该方法用于判断集合中是否包含指定元素
 public boolean contains(Object o) {
 //由于indexOf方法在查询不到指定元素时返回-1,查询到时返回下标,所以通过>=0即可判断是否包含指定元素o
        return indexOf(o) >= 0;
    }
(11)lastIndexOf:该方法返回指定元素在集合中最后出现的下标
 public int lastIndexOf(Object o) {
    if (o == null) {
    //从后往前遍历
        for (int i = size-1; i >= 0; i--)
            if (elementData[i]==null)
                return i;
    } else {
        for (int i = size-1; i >= 0; i--)
            if (o.equals(elementData[i]))
                return i;
    }
    return -1;
}    
(12)get:该方法根据指定下标返回集合中的元素
 public E get(int index) {
        rangeCheck(index);//[7]
        return elementData(index);
    }
 
[7]处调用rangeCheck方法,检查下标,若下标越界,抛异常    
 private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }    
    
(13)remove:该方法根据指定下标移除元素
public E remove(int index) {
    rangeCheck(index);

    modCount++;
    E oldValue = elementData(index);
	//需要移动的元素的数量
    int numMoved = size - index - 1;
    if (numMoved > 0)//如果数量大于0,移动
    	//将从index+1以及之后的所有元素向前移动
        System.arraycopy(elementData, index+1, elementData, index,
                         numMoved);
    elementData[--size] = null; // clear to let GC do its work

    return oldValue;//返回值为移除的值
}
    
(14)remove(Object o):该方法根据指定的元素在集合中移除该元素
  public boolean remove(Object o) {
  		//如果要移除的元素为null,遍历集合找到为null的元素移除
        if (o == null) {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null) {
                    fastRemove(index);//[8]
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index])) {
                    fastRemove(index);
                    return true;
                }
        }
        return false;
    }
    
[8]处调用fastRemove,和remove(int index)方法相比,就少调用了rangeCheck(index)而已,
因为上面的remove(Object o)就是遍历下标,根据下标进行移除操作,所以不会出现下标越界情况,无需判断;
 private void fastRemove(int index) {
        modCount++;
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null; // clear to let GC do its work
    }    
    
    
(15)set(int index,E element):该方法用于在指定下标处替换原来的元素,返回原来的元素
 public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }    
    
(16)toArray()该方法将elementData从下标0开始size长度的元素(即所有存储在集合中的元素)复制并返回
  public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }
(17)public <T> T[] toArray(T[] a)
 public <T> T[] toArray(T[] a) {
        if (a.length < size)
            // Make a new array of a's runtime type, but my contents:
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size)
            a[size] = null;//a数组size下标处置为null
        return a;
    }
    