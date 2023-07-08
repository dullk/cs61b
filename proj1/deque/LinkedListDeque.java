package deque;

import java.util.*;

public class LinkedListDeque<T> implements Deque<T> {

    private int size;
    private final ListNode sentinel;

    /** Helper class of LinkedListDeque. */
    private class ListNode {
        private ListNode prev;
        private T item;
        private ListNode next;
        private ListNode() {
            prev = null;
            item = null;
            next = null;
        }
        private ListNode(T item) {
            prev = null;
            this.item = item;
            next = null;
        }

        /** Helper method of getRecursive.
         * Get the i-th item of the LinkedList recursively. */
        private T get(int index) {
            if (index == 0) {
                return item;
            } else {
                return this.next.get(index - 1);
            }
        }
    }

    /** Initialize an empty LinkedListDeque. */
    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    /** Add item to the first of the LinkedListDeque. */
    @Override
    public void addFirst(T item) {
        ListNode newItem = new ListNode(item);
        newItem.prev = sentinel;
        newItem.next = sentinel.next;
        sentinel.next.prev = newItem;
        sentinel.next = newItem;
        size += 1;
    }

    /** Add item to the end of the LinkedListDeque. */
    @Override
    public void addLast(T item) {
        ListNode newItem = new ListNode(item);
        newItem.prev = sentinel.prev;
        newItem.next = sentinel;
        sentinel.prev.next = newItem;
        sentinel.prev = newItem;
        size += 1;
    }

    /** Return true if LinkedListDeque is empty, else return false. */
//    @Override
//    public boolean isEmpty() {
//        return (size == 0);
//    }

    /** Return the size of LinkedListDeque. */
    @Override
    public int size() {
        return size;
    }

    /** Print all items of LinkedListDeque, divided by blank space. */
    @Override
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    /** Remove the first item of LinkedListDeque.
     *  Return null if LinkedListDeque is empty.
     *  Return the removed item if not empty. */
    @Override
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        } else {
            ListNode removeItem = sentinel.next;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return removeItem.item;
        }
    }

    /** Remove the last item of LinkedListDeque.
     *  Return null if LinkedListDeque is empty.
     *  Return the removed item if not empty. */
    @Override
    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        } else {
            ListNode removeItem = sentinel.prev;
            sentinel.prev.prev.next = sentinel;
            sentinel.prev = sentinel.prev.prev;
            size -= 1;
            return removeItem.item;
        }
    }

    /** Return the index-th item of LinkedListDeque iteratively.
     *  Return null if index < 0 or out of bound. */
    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            ListNode p = sentinel;
            int i = 0;
            while (i <= index) {
                i += 1;
                p = p.next;
            }
            return p.item;
        }
    }

    /** Return the index-th item of LinkedListDeque recursively,
     *  using the get method in ListNode class.
     *  Return null if index < 0 or out of bound. */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            ListNode p = sentinel.next;
            return p.get(index);
        }
    }

    /** Helper class of iterator. */
    private class LinkedListDequeIterator implements Iterator<T> {
        private ListNode p;
        LinkedListDequeIterator() {
            p = sentinel;
        }
        public boolean hasNext() {
            return p.next != sentinel;
        }

        public T next() {
            T returnItem = p.next.item;
            p = p.next;
            return  returnItem;
        }
    }

    public Iterator<T> iterator() {
        return new LinkedListDequeIterator();
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
