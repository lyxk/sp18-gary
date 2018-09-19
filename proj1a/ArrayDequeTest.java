/** Performs some basic array tests. */
public class ArrayDequeTest {

    /* Utility method for printing out empty checks. */
    public static boolean checkEmpty(boolean expected, boolean actual) {
        if (expected != actual) {
            System.out.println("isEmpty() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out empty checks. */
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }

    /* Utility method for printing out head index. */
    public static boolean checkHead(int expected, int actual) {
        if(expected != actual) {
            System.out.println("head() returned " + expected + ", but expected: " + actual);
            return false;
        }
        return true;
    }

    /* Utility method for printing out tail index. */
    public static boolean checkTail(int expected, int actual) {
        if(expected != actual) {
            System.out.println("tail() returned " + expected + ", but expected: " + actual);
            return false;
        }
        return true;
    }

    /* Prints a nice message based on whether a test passed.
     * The \n means newline. */
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }

    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> arrd1 = new ArrayDeque<String>();

        boolean passed = checkEmpty(true, arrd1.isEmpty());

        arrd1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, arrd1.size()) && passed;
        passed = checkEmpty(false, arrd1.isEmpty()) && passed;

        arrd1.addLast("middle");
        passed = checkSize(2, arrd1.size()) && passed;

        arrd1.addLast("back");
        passed = checkSize(3, arrd1.size()) && passed;

        System.out.println("Printing out deque: ");
        arrd1.printDeque();

        printTestStatus(passed);
    }

    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> arrd1 = new ArrayDeque<Integer>();
        // should be empty
        boolean passed = checkEmpty(true, arrd1.isEmpty());

        arrd1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, arrd1.isEmpty()) && passed;

        arrd1.removeFirst();
        // should be empty
        passed = checkEmpty(true, arrd1.isEmpty()) && passed;

        printTestStatus(passed);
    }

    public static void headTailTest() {

        System.out.println("Running index test.");

        ArrayDeque<Integer> arrd1 = new ArrayDeque<>();

        boolean passed = checkHead(arrd1.head(), 0) && checkTail(arrd1.tail(), 0);

        arrd1.addLast(1);
        // tail should still be 0;
        passed = passed && checkTail(arrd1.tail(), 0) && checkHead(arrd1.head(), 0);

        arrd1.addLast(18);
        // tail should be 1 now, head should still be 0
        passed = passed && checkTail(arrd1.tail(), 1) && checkHead(arrd1.head(), 0);

        arrd1.addFirst(79);
        // tail should still be 1, head should loop back to 7
        passed = passed && checkTail(arrd1.tail(), 1) && checkHead(arrd1.head(), 7);

        arrd1.addFirst(83);
        // tail should still be 1, head should be 6
        passed = passed && checkTail(arrd1.tail(), 1) && checkHead(arrd1.head(), 6);

        arrd1.removeFirst();
        arrd1.removeFirst();
        // tail should still be 1, head should be back to 0
        passed = passed && checkTail(arrd1.tail(), 1) && checkHead(arrd1.head(), 0);

        printTestStatus(passed);
    }

    public static void resizeTest() {

        System.out.println("Running resizing test.");

        ArrayDeque<Integer> arrd1 = new ArrayDeque<>();

        boolean passed = true;

        for (int i = 0; i < 4; i++) {
            arrd1.addLast(i);
        }
        for (int i = 4; i < 8; i++) {
            arrd1.addFirst(i);
        }

        arrd1.addLast(53);
        arrd1.addFirst(64);

        passed = passed && checkHead(arrd1.head(), 11) && checkTail(arrd1.tail(), 4);

        printTestStatus(passed);
    }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        headTailTest();
        resizeTest();
    }
}