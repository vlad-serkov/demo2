package com.example.demo;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> first;
    private Node<T> last;
    public int size;

    public T get(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException();

        Node<T> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.value;
    }

    public T getFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.value;
    }

    public T getLast() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.value;
    }

    private T unlinkFirst(Node<T> f) {
        final T element = f.value;
        final Node<T> next = f.next;
        f.value = null;
        f.next = null;
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    private T unlinkLast(Node<T> l) {
        final T element = l.value;
        final Node<T> prev = l.prev;
        l.value = null;
        l.prev = null;
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    public T removeFirst() {
        final Node<T> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    public T removeLast() {
        final Node<T> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    public void addLast(T element) {
        final Node<T> l = last;
        final Node<T> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public void addBefore(T element) {
        final Node<T> f = first;
        final Node<T> newNode = new Node<>(null, element, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(first, 0);
    }

    private class LinkedListIterator implements Iterator<T> {

        private Node<T> node;
        private int nextIndex;

        public LinkedListIterator(Node<T> node, int nextIndex) {
            this.nextIndex = nextIndex;
            this.node = node;
        }

        @Override
        public boolean hasNext() {
            return nextIndex < size;
        }

        @Override
        public T next() {

            Node<T> lastReturn = node;
            if (hasNext()) {
                node = lastReturn.next;
                nextIndex++;
                return lastReturn.value;
            }
            throw new NoSuchElementException();
        }
    }


    private static class Node<T> {
        T value;
        Node<T> prev;
        Node<T> next;

        Node(Node<T> prev, T element, Node<T> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }
}