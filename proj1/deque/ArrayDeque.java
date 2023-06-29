package deque;

public class ArrayDeque<T> {
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

//    /** Create a ArrayDeque with one item. */
//    public ArrayDeque(ItemType item) {
//        size = 1;
//        items = (ItemType[]) new Object[8];
//        items[0] = item;
//        nextFirst = items.length - 1;
//        nextLast = size;
//    }

    /** Resize the length of items[] to the target capacity, starting from 0, which means
     *  nextFirst changes to (items.length - 1). */
    public void resize(int capacity) {
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
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextFirst] = item;
        nextFirst = (nextFirst - 1 + items.length) % items.length;
        size += 1;
    }

    /** Add item to the end of the LinkedListDeque. */
    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % items.length;
        size += 1;
    }

    /** Return true if LinkedListDeque is empty, else return false. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Return true if items[] is full. */
    private boolean isFull() {
        return (size == items.length);
    }

    /** Return true if size / items.length < 25%. */
    private boolean isNotProportional() {
        return (items.length >= 16 && (float) size / (float) items.length < 0.25);
    }

    /** Return the size of LinkedListDeque. */
    public int size() {
        return size;
    }

    /** Remove the first item of LinkedListDeque.
     *  Return null if LinkedListDeque is empty.
     *  Return the removed item if not empty. */
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

    /** Remove the last item of LinkedListDeque.
     *  Return null if LinkedListDeque is empty.
     *  Return the removed item if not empty. */
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

    /** Return the index-th item of LinkedListDeque iteratively.
     *  Return null if index < 0 or out of bound. */
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            int indexArray = (nextFirst + 1 + index) % items.length;
            return items[indexArray];
        }
    }

    /** Print all items of LinkedListDeque, divided by blank space. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
