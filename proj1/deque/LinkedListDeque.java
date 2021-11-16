package deque;

import java.util.LinkedList;

public class LinkedListDeque <E> implements Deque<E> {
    transient int size = 0;

    /**
     * Pointer to first node.
     */
    transient Node<E> first;

    /**
     * Pointer to last node.
     */
    transient Node<E> last;
    public LinkedListDeque(){

    }
    private static class Node<E> {
        E item;
       Node<E> next;
       Node<E> prev;

        Node(Node<E> prev, E element,Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    @Override
    public void addFirst(E item) {
        Node<E> e = first;
        Node<E> newNode = new Node<>(null,item,e);
        first = newNode;
        if(e==null)
            last = newNode;
        else
            e.prev = newNode;
        size++;
    }

    @Override
    public void addLast(E item) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l,item,null);
        last = newNode;
        if(l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {

    }


    @Override
    public E removeFirst() {


        size--;
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E get(int index) {
        return null;
    }


    @Override
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;
    }
}
