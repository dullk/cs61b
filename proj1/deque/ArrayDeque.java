package deque;

import java.util.*;

public class ArrayDeque<T> implements Deque<T>, Iterable<T> {
    private int size;
    private T[] items;
    private int nextFirst;
    private int nextLast;

    /** Initialize an empty ArrayDeque. */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
    }

    /** Resize the length of items[] to the target capacity, starting from 0, which means
     *  nextFirst changes to (items.length - 1). */
    private void resize(int capacity) {
        T[] newItems = (T[]) new Object[capacity];
        int first = (nextFirst + 1) % items.length;
        int last = (nextLast - 1 + items.length) % items.length;

        if (first < last) {
            System.arraycopy(items, first, newItems, 0, size);
        } else {
            System.arraycopy(items, first, newItems, 0, items.length - first);
            System.arraycopy(items, 0, newItems, items.length - first, last + 1);
        }

        items = newItems;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    /** Add item to the first of the ArrayDeque. */
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    /** Add item to the end of the ArrayDeque. */
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /** Return true if ArrayDeque is empty, else return false. */
//    @Override
//    public boolean isEmpty() {
//        return (size == 0);
//    }

    /** Return true if items[] is full. */
    private boolean isFull() {
        return (size == items.length);
    }

    /** Return true if size / items.length < 25%. */
    private boolean isNotProportional() {
        return (items.length >= 16 && (float) size / (float) items.length < 0.25);
    }

    /** Return the size of ArrayDeque. */
    @Override
    public int size() {
        return size;
    }

    /** Remove the first item of ArrayDeque.
     *  Return null if ArrayDeque is empty.
     *  Return the removed item if not empty. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            int first = (nextFirst + 1) % items.length;
            T firstItem = items[first];
            items[first] = null;
            nextFirst = first;
            size -= 1;
            if (isNotProportional()) {
                resize(items.length / 2);
            }
            return firstItem;
        }
    }

    /** Remove the last item of ArrayDeque.
     *  Return null if ArrayDeque is empty.
     *  Return the removed item if not empty. */
    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        } else {
            int last = (nextLast - 1 + items.length) % items.length;
            T lastItem = items[last];
            items[last] = null;
            nextLast = last;
            size -= 1;
            if (isNotProportional()) {
                resize(items.length / 2);
            }
            return lastItem;
        }
    }

    /** Return the index-th item of ArrayDeque iteratively.
     *  Return null if index < 0 or out of bound. */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            int indexArray = (nextFirst + 1 + index) % items.length;
            return items[indexArray];
        }
    }

    /** Print all items of ArrayDeque, divided by blank space. */
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    /** Helper class of iterator. */
    private class ArrayDequeIterator implements Iterator<T> {
        private int i;
        ArrayDequeIterator() {
            i = 0;
        }

        public boolean hasNext() {
            return i < size;
        }

        public T next() {
            T returnItem = get(i);
            i += 1;
            return returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new ArrayDequeIterator();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (!(other instanceof Deque)) {
            return false;
        }
        Deque<T> o = (Deque<T>) other;
        if (this.size() != o.size()) {
            return false;
        }
        for (int i = 0; i < size; i += 1) {
            if (!this.get(i).equals(o.get(i))) {
                return false;
            }
        }
        return true;
    }
}
