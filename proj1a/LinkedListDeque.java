/** Deque: double-endede queue implemented using linked list*/
public class LinkedListDeque<T> {
    private class ItemNode {
        public T item;
        public ItemNode prev;
        public ItemNode next;

        private ItemNode(T x, ItemNode p, ItemNode n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    private ItemNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new ItemNode(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        ItemNode newnode = new ItemNode(item, sentinel, sentinel.next);
        sentinel.next.prev = newnode;
        sentinel.next = newnode;
        size += 1;
    }
    public void addLast(T item) {
        ItemNode newnode = new ItemNode(item, sentinel.prev, sentinel);
        sentinel.prev.next = newnode;
        sentinel.prev = newnode;
        size += 1;
    }
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }
    public void printDeque() {
        if (isEmpty()) {
            System.out.println();
            return;
        }
        for(ItemNode p = sentinel.next; p != sentinel; p = p.next) {
            System.out.print(p.item + " ");
        }
        System.out.println();
    }
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        ItemNode first = sentinel.next;
        T value = first.item;
        first.prev.next = first.next;
        first.next.prev = first.prev;
        size -= 1;
        return value;
    }
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        ItemNode last = sentinel.prev;
        T value = last.item;
        last.prev.next = last.next;
        last.next.prev = last.prev;
        size -= 1;
        return value;
    }
    public T get(int index) {
        if (isEmpty()) {
            return null;
        }
        ItemNode p = sentinel.next;
        int i = 0;
        while(i < index) {
            p = p.next;
            i += 1;
        }
        return p.item;
    }
    private T getRecursiveHelper(ItemNode current, int index) {
        if (index == 0) {
            return current.item;
        }
        return getRecursiveHelper(current.next, index - 1);
    }
    public T getRecursive(int index) {
        ItemNode start = sentinel.next;
        return getRecursiveHelper(start, index);

    }
    public int size() {
        return size;
    }
}