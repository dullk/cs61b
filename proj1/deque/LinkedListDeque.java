package deque;

public class LinkedListDeque<T> {

    private int size;
    private final ListNode sentinel;

    /** Helper class of LinkedListDeque. */
    public class ListNode {
        public ListNode prev;
        public T item;
        public ListNode next;
        public ListNode() {
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

    /** Create a LinkedListDeque with a ListNode item. */
    public LinkedListDeque(T item) {
        size = 1;
        sentinel = new ListNode();
        ListNode p = new ListNode(item);
        sentinel.prev = p;
        sentinel.next = p;
        p.prev = sentinel;
        p.next = sentinel;
    }

    /** Add item to the first of the LinkedListDeque. */
    public void addFirst(T item) {
        ListNode newItem = new ListNode(item);
        newItem.prev = sentinel;
        newItem.next = sentinel.next;
        sentinel.next.prev = newItem;
        sentinel.next = newItem;
        size += 1;
    }

    /** Add item to the end of the LinkedListDeque. */
    public void addLast(T item) {
        ListNode newItem = new ListNode(item);
        newItem.prev = sentinel.prev;
        newItem.next = sentinel;
        sentinel.prev.next = newItem;
        sentinel.prev = newItem;
        size += 1;
    }

    /** Return true if LinkedListDeque is empty, else return false. */
    public boolean isEmpty() {
        return (size == 0);
    }

    /** Return the size of LinkedListDeque. */
    public int size() {
        return size;
    }

    /** Print all items of LinkedListDeque, divided by blank space. */
    public void printDeque() {
        for (int i = 0; i < size; i++) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }

    /** Remove the first item of LinkedListDeque.
     *  Return null if LinkedListDeque is empty.
     *  Return the removed item if not empty. */
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

    /** Return the index-th item of LinkedListDeque recursively, using the get method in ListNode class.
     *  Return null if index < 0 or out of bound. */
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            ListNode p = sentinel.next;
            return p.get(index);
        }
    }
}
