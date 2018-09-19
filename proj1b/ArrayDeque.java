/** Deque: double-endede queue implemented using circular array*/
public class ArrayDeque<T> implements Deque<T> {
    private T[] items;
    private int size;
    private int head;
    private int tail;
    private static double minUsage = 0.25;

    public ArrayDeque() {
        items = (T []) new Object[8];
        size = 0;
        head = 0;
        tail = 0;
    }

    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        if (tail >= head) {
            System.arraycopy(items, head, a, 0, size);
        }
        else {
            int len = items.length;
            // e.g. len = 8, head = 4, offset = -4, there are 4, 5, 6, 7, four elements, # elements = -offset
            int offset = head - len;
            System.arraycopy(items, 0, a, 0, tail + 1);
            // e.g. len = 8, head = 4, offset = -4, there are 4, 5, 6, 7, four elements, # elements = -offset
            System.arraycopy(items, head, a, offset + capacity, -offset);
            head = offset + capacity;
        }
        items = a;
    }
    @Override
    public void addFirst(T item) {
        int len = items.length;
        if (size == len) {
            resize(2 * size);
        }
        if (!isEmpty()) {
            if (head == 0) {
                // -1 % 8 = -1, -1 + 8 = 7, avoid getting negative indices
                head = (head - 1) % len + len;
            }
            else {
                head = (head - 1) % len;
            }
        }
        items[head] = item;
        size += 1;
    }
    @Override
    public void addLast(T item) {
        int len = items.length;
        if (size == len) {
            resize(2 * size);
        }
        if (!isEmpty()) {
            tail = (tail + 1) % len;
        }
        items[tail] = item;
        size += 1;
    }
    @Override
    public boolean isEmpty() {
        return (size == 0);
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        int len = items.length;
        for (int i = head; i != tail; i = (i + 1) % len) {
            System.out.print(items[i] + " ");
        }
        System.out.print(items[tail]);
        System.out.println();
    }
    @Override
    public T removeFirst() {
        int len = items.length;
        T value = items[head];
        items[head] = null;
        head = (head + 1) % len;
        size -= 1;
        if (len >= 16 && (size / len) < 0.25) {
            resize(len / 2);
        }
        return value;
    }
    @Override
    public T removeLast() {
        int len = items.length;
        T value = items[tail];
        items[tail] = null;
        if (tail == 0) {
            // -1 % 8 = -1, -1 + 8 = 7, avoid getting negative indices
            tail = (tail - 1) % len + len;
        }
        else {
            tail = (tail - 1) % len;
        }
        size -= 1;
        if (len >= 16 && (size / len) < 0.25) {
            resize(len / 2);
        }
        return value;
    }
    @Override
    public T get(int index) {
        if(index >= size || index < 0) {
            System.out.print("Index out of range!");
            return null;
        }
        int len = items.length;
        return items[(head + index) %  len];
    }
    public int head() {
        return head;
    }
    public int tail() {
        return tail;
    }
}