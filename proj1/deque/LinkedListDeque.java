package deque;

import java.util.Iterator;

public class LinkedListDeque<ItemType> {

    private int size;
    private final ListNode sentinel;

    public class ListNode {
        public ListNode prev;
        public ItemType item;
        public ListNode next;
        public ListNode() {
            prev = null;
            item = null;
            next = null;
        }
        private ListNode(ItemType item) {
            prev = null;
            this.item = item;
            next = null;
        }
        private ItemType get(int index) {
            if (index == 0) {
                return item;
            } else {
                return this.next.get(index - 1);
            }
        }
    }

    public LinkedListDeque() {
        size = 0;
        sentinel = new ListNode();
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
    }

    public void addFirst(ItemType item) {
        ListNode newItem = new ListNode(item);
        newItem.prev = sentinel;
        newItem.next = sentinel.next;
        sentinel.next.prev = newItem;
        sentinel.next = newItem;
        size += 1;
    }

    public void addLast(ItemType item) {
        ListNode newItem = new ListNode(item);
        newItem.prev = sentinel.prev;
        newItem.next = sentinel;
        sentinel.prev.next = newItem;
        sentinel.prev = newItem;
        size += 1;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for(int i = 0; i < size; i++){
            System.out.print(get(i) + " ");
        }
        System.out.print("\n");
    }

    public ItemType removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        } else {
            ListNode removeItem = sentinel.next;
            sentinel.next.next.prev = sentinel;
            sentinel.next = sentinel.next.next;
            size -= 1;
            return removeItem.item;
        }
    }

    public ItemType removeLast() {
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

    public ItemType get(int index) {
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

    public ItemType getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        } else {
            ListNode p = sentinel.next;
            return p.get(index);
        }
    }
}
