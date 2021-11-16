package deque;

import java.util.NoSuchElementException;

public class ArrayDeque <T> implements Deque<T>{
 //   private Object[] elem;
    //容器capacity最小值，也是2的次幂（数组初始容量保证都时2的次幂，方便使用位运算）
    private static final int MIN_INITIAL_CAPACITY = 8;

    //存放数据数组，长度和capacity一致，并且总是2的次幂
    transient Object[] elements;

    //标记队首元素所在的位置
    transient int head;

    //标记队尾元素所在的位置
    transient int tail;
    public ArrayDeque(){
        elements = new Object[16];
    }
    private void allocateElements(int numElements) {
        int initialCapacity = MIN_INITIAL_CAPACITY;
        if (numElements >= initialCapacity) {
            initialCapacity = numElements;
            initialCapacity |= (initialCapacity >>>  1);
            initialCapacity |= (initialCapacity >>>  2);
            initialCapacity |= (initialCapacity >>>  4);
            initialCapacity |= (initialCapacity >>>  8);
            initialCapacity |= (initialCapacity >>> 16);
            initialCapacity++;

            if (initialCapacity < 0)   // Too many elements, must back off
                initialCapacity >>>= 1;// Good luck allocating 2 ^ 30 elements
        }
        elements = (T[]) new Object[initialCapacity];
    }
    public void addFirst(T item){
        if(item ==null)
            throw new NullPointerException();
        elements[head = (head - 1) & (elements.length - 1)] = item;
        if (head == tail)
            doubleCapacity();
    }

    /** 在队尾添加元素 **/
    public void addLast(T e) {
        if (e == null)
            throw new NullPointerException();
        elements[tail] = e;
        if ( (tail = (tail + 1) & (elements.length - 1)) == head)
            doubleCapacity();
    }
    public boolean isEmpty(){
        return head == tail;
    }
    public int size(){
        return sub(tail, head, elements.length);
    }
    public void printDeque(){}
    public T removeFirst(){
        int h = head;
        @SuppressWarnings("unchecked")
        T result = (T) elements[h];
        if (result == null)
            return null;
        elements[h] = null;
        head = (h + 1) & (elements.length - 1);
        return result;
    }
    static final int sub(int i, int j, int modulus) {
        if ((i -= j) < 0) i += modulus;
        return i;
    }
    public T removeLast(){
        int t = (tail - 1) & (elements.length - 1);
        @SuppressWarnings("unchecked")
        T result = (T) elements[t];
        if (result == null)
            return null;
        elements[t] = null;
        tail = t;
        return result;
    }

    @Override
    public T get(int index) {
        return null;
    }

    private void doubleCapacity() {
        //只有head==tail时才可以扩容
        assert head == tail;
        int p = head;
        int n = elements.length;
        //在head之后，还有多少元素
        int r = n - p; // number of elements to the right of p
        //直接翻倍，因为capacity初始化时就已经是2的倍数了，这里无需再考虑
        int newCapacity = n << 1;
        if (newCapacity < 0)
            throw new IllegalStateException("Sorry, deque too big");
        Object[] a = new Object[newCapacity];
        //左侧数据拷贝
        System.arraycopy(elements, p, a, 0, r);
        //右侧数据拷贝
        System.arraycopy(elements, 0, a, r, p);
        elements = a;
        head = 0;
        tail = n;
    }
    public T getFirst() {
        @SuppressWarnings("unchecked")
        T result = (T) elements[head];
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }

    /**
     * @throws NoSuchElementException {@inheritDoc}
     */
    public T getLast() {
        @SuppressWarnings("unchecked")
        T result = (T) elements[(tail - 1) & (elements.length - 1)];
        if (result == null)
            throw new NoSuchElementException();
        return result;
    }
 //   public T get(int index){}
}
