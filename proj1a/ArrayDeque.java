/** Deque: double-endede queue implemented using circular array*/
public class ArrayDeque<T> {
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

    private int head() {
        return head;
    }
    private int tail() {
        return tail;
    }
    private int mod(int a, int b) {
        // Only consider cases when b >= 0
        int result = a % b;
        if (result < 0) {
            // -1 % 8 = -1, -1 + 8 = 7, avoid getting negative indices
            result += b;
        }
        return result;
    }
    private boolean afterRemovalEmpty() {
        return (size == 1);
    }
    private float usage(){
        return (float) size / items.length;
    }
    private void resize(int capacity) {
        T[] a = (T []) new Object[capacity];
        if (tail >= head) {
            System.arraycopy(items, head, a, 0, size);
            head = 0;
            tail = size - 1;
        }
        else {
            /*// e.g. len = 8, head = 4, offset = -4, there are 4, 5, 6, 7, four elements, # elements = -offset
            int offset = head - items.length;
            System.arraycopy(items, 0, a, 0, tail + 1);
            // e.g. len = 8, head = 4, offset = -4, there are 4, 5, 6, 7, four elements, # elements = -offset
            System.arraycopy(items, head, a, offset + capacity, -offset);
            head = offset + capacity;*/
            int num_upper = items.length - head;
            int num_lower = tail + 1;
            System.arraycopy(items, head, a, 0, num_upper);
            System.arraycopy(items, 0, a, num_upper, num_lower);
            head = 0;
            tail = size - 1;
        }
        items = a;
    }
    public void addFirst(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        if (!isEmpty()) {
            head = mod(head - 1, items.length);
        }
        items[head] = item;
        size += 1;
    }
    public void addLast(T item) {
        if (size == items.length) {
            resize(2 * size);
        }
        if (!isEmpty()) {
            tail = mod(tail + 1, items.length);
        }
        items[tail] = item;
        size += 1;
    }
    public boolean isEmpty() {
        return (size == 0);
    }
    public int size() {
        return size;
    }
    public void printDeque() {
        for (int i = head; i != tail; i = mod(i + 1, items.length)) {
            System.out.print(items[i] + " ");
        }
        System.out.print(items[tail]);
        System.out.println();
    }
    public T removeFirst() {
        T value = items[head];
        items[head] = null;
        if (!isEmpty()) {
            if (!afterRemovalEmpty()) {
                head = mod(head + 1, items.length);
            }
            size -= 1;
        }
        if (items.length >= 16 && usage() < 0.25) {
            resize(items.length / 2);
        }
        return value;
    }
    public T removeLast() {
        T value = items[tail];
        items[tail] = null;
        if (!isEmpty()) {
            if (!afterRemovalEmpty()) {
                tail = mod(tail - 1, items.length);
            }
            size -= 1;
        }
        if (items.length >= 16 && usage() < 0.25) {
            resize(items.length / 2);
        }
        return value;
    }
    public T get(int index) {
        if(index >= size || index < 0) {
            System.out.print("Index out of range!");
            return null;
        }
        return items[mod(head + index, items.length)];
    }
}