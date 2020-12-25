package com.company;

import java.util.Arrays;
import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {

    private Node head;
    private Node tail;
    private int size = 0;
    private T[] array;


    void add(T value) {
        Node n = new Node(value);
        if (size == 0) {
            tail = head = n;

        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
        size++;
    }

    void remove(int index) {
        checkIndex(index);
        Node temp = get(index);
        if (index == 0) {
            head = head.next;
        } else if (index == size - 1) {
            tail = tail.prev;
        } else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }


        size--;
    }

    void add(int index, T value) {
        if (index == size) {
            add(value);
            return;
        }

        checkIndex(index);
        Node newNode = new Node(value);
        if (index == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else {
            Node temp = get(index);
            newNode.next = temp;
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            temp.prev = newNode;
        }
        size++;
    }

    void set(int index, T value) {
        checkIndex(index);
        Node temp = get(index);
        temp.value = value;
    }

    Node get(int index) {
        checkIndex(index);

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    int size() {
        return size;
    }


    void toArray() {
        array = (T[]) new Object[size];
        Node temp = head;

        for (int i = 0; i < size; i++) {
            array[i] = temp.value;
            temp = temp.next;
        }
    }

    @Override
    public String toString() {
        toArray();
        return Arrays.toString(array);
    }

    public Iterator<T> iteratorReverse() {
        return new MyLinkedListIteratorReverse();
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }


    private class MyLinkedListIterator implements Iterator<T> {

        Node cur = head;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T value = (T) cur.value;
            cur = cur.next;
            return value;
        }
    }

    private class MyLinkedListIteratorReverse implements Iterator<T> {

        Node cur = tail;

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public T next() {
            T value = (T) cur.value;
            cur = cur.prev;
            return value;
        }
    }

    class Node {
        T value;
        Node prev;
        Node next;

        public Node(T value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
    }
}
