********************
一.包说明
160912
0.com.zc.z01demo:所有demo

1.com.zc.my自己实现
MyArrayList.java有点乱

2.com.zc.test测试包
TestMyArrayList



*****************************
160815
set没有get(index)方法.(无序?)

2.
public interface Comparable<T>此接口强行对实现它的每个类的对象进行整体排序。
这种排序被称为类的自然排序，类的 compareTo 方法被称为它的自然比较方法。
实现此接口的对象列表（和数组）可以通过 Collections.sort（和 Arrays.sort）进行自动排序。
实现此接口的对象可以用作有序映射中的键或有序集合中的元素，无需指定比较器。

对于类 C 的每一个 e1 和 e2 来说，
当且仅当 e1.compareTo(e2) == 0 与 e1.equals(e2) 具有相同的 boolean 值时，
类 C 的自然排序才叫做与 equals 一致。
注意，null 不是任何类的实例，即使 e.equals(null) 返回 false，
e.compareTo(null) 也将抛出 NullPointerException。

建议（虽然不是必需的）最好使自然排序与 equals 一致。
这是因为在使用自然排序与 equals 不一致的元素（或键）时，没有显式比较器的有序集合（和有序映射表）行为表现“怪异”。
尤其是，这样的有序集合（或有序映射表）违背了根据 equals 方法定义的集合（或映射表）的常规协定。

例如，如果将两个键 a 和 b 添加到没有使用显式比较器的有序集合中，
使 (!a.equals(b) && a.compareTo(b) == 0)，
那么第二个 add 操作将返回 false（有序集合的大小没有增加），因为从有序集合的角度来看，a 和 b 是相等的。

实际上，所有实现 Comparable 的 Java 核心类都具有与 equals 一致的自然排序。
java.math.BigDecimal 是个例外，
它的自然排序将值相等但精确度不同的 BigDecimal 对象（比如 4.0 和 4.00）视为相等。

从数学上讲，定义给定类 C 上自然排序的关系式 如下：

      {(x, y)|x.compareTo(y) <= 0}。
整体排序的商 是：
      {(x, y)|x.compareTo(y) == 0}。
它直接遵循 compareTo 的协定，商是 C 的等价关系，自然排序是 C 的整体排序。
当说到类的自然排序与 equals 一致 时，是指自然排序的商是由类的 equals(Object) 方法定义的等价关系。
    {(x, y)|x.equals(y)}。此接口是 Java Collections Framework 的成员。 


3.sort in jdk
String[] s1=new String[10];
Arrays.sort(s1);//对Object[]类型 进行排序

jdk
  public static void sort(Object[] a) {
        if (LegacyMergeSort.userRequested)
            legacyMergeSort(a);
        else
            ComparableTimSort.sort(a);
    }
    
  
    private static void legacyMergeSort(Object[] a) {
        Object[] aux = a.clone();
        mergeSort(aux, a, 0, a.length, 0);
    }
    


 private static void mergeSort(Object[] src,
                                  Object[] dest,
                                  int low,
                                  int high,
                                  int off) {
        int length = high - low;

        // Insertion sort on smallest arrays
        if (length < INSERTIONSORT_THRESHOLD) {
            for (int i=low; i<high; i++)
                for (int j=i; j>low &&
                         ((Comparable) dest[j-1]).compareTo(dest[j])>0; j--)
                    swap(dest, j, j-1);
            return;
        }

        // Recursively sort halves of dest into src
        int destLow  = low;
        int destHigh = high;
        low  += off;
        high += off;
        int mid = (low + high) >>> 1;
        mergeSort(dest, src, low, mid, -off);
        mergeSort(dest, src, mid, high, -off);

        // If list is already sorted, just copy from src to dest.  This is an
        // optimization that results in faster sorts for nearly ordered lists.
        if (((Comparable)src[mid-1]).compareTo(src[mid]) <= 0) {
            System.arraycopy(src, low, dest, destLow, length);
            return;
        }

        // Merge sorted halves (now in src) into dest
        for(int i = destLow, p = low, q = mid; i < destHigh; i++) {
            if (q >= high || p < mid && ((Comparable)src[p]).compareTo(src[q])<=0)
                dest[i] = src[p++];
            else
                dest[i] = src[q++];
        }
    }
      

***************1.1 asList实现****************
 @SafeVarargs
public static <T> List<T> asList(T... a) {
    return new ArrayList<>(a);
}

注意,产生的ArrayList不是平时见的ArrayList,而是Arrays中的一个静态内部类ArrayList
 private static class ArrayList<E> extends AbstractList<E>
        implements RandomAccess, java.io.Serializable
ArrayList(E[] array) {
    if (array==null)
        throw new NullPointerException();
    a = array;
}

由于该类 实现了AbstractList接口,所以在调用add()方法时,由于该类没有覆盖,则调用了AbstractList中
的add()方法
该方法如下
public void add(int index, E element) {
    throw new UnsupportedOperationException();
}


**************  Set ***********************
HashSet:输出无序,因为使用散列
TreeSet:使用红黑树实现
LinkedHashSet:使用散列加速查询,使用链表维护元素的插入顺序


**************ContainerMethods************
thinkingInJava-ContainerMethods:不同集合类中方法区分


