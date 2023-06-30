package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    /* Check if addFirst method works well. */
    public void addFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        for (int i = 0; i < 1000; i += 1) {
            ad1.addFirst(i);
            lld1.addFirst(i);
        }

        for (int i = 0; i < 1000; i += 1) {
            assertEquals(lld1.get(i), ad1.get(i));
        }
    }

    @Test
    /* Check if addFirst and addLast methods work well. */
    public void addTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                ad1.addFirst(i);
                lld1.addFirst(i);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                ad1.addLast(i);
                lld1.addLast(i);
            }
        }

        for (int i = 0; i < N; i += 1) {
            assertEquals(lld1.get(i), ad1.get(i));
        }
    }

    @Test
    /* Check if removeFirst and removeLast methods work well. */
    public void removeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                ad1.addFirst(i);
                lld1.addFirst(i);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                ad1.addLast(i);
                lld1.addLast(i);
            }
        }

        for (int i = 0; i < N + 100; i += 1) {
            int operationNumber = StdRandom.uniform(0, 2);
            if (operationNumber == 0) {
                // removeFirst
                assertEquals(lld1.removeFirst(), ad1.removeFirst());
            } else if (operationNumber == 1) {
                // removeLast
                assertEquals(lld1.removeLast(), ad1.removeLast());
            }
        }

    }

    @Test
    public void randomizedTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        int N = 10000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 1000);
                ad1.addFirst(randVal);
                lld1.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 1000);
                ad1.addLast(randVal);
                lld1.addLast(randVal);
            } else if (operationNumber == 2) {
                // removeFirst
                assertEquals(lld1.removeFirst(), ad1.removeFirst());
            } else if (operationNumber == 3) {
                // removeLast
                assertEquals(lld1.removeLast(), ad1.removeLast());
            } else if (operationNumber == 4) {
                // get
                if (ad1.size() == 0) {continue;}
                int randVal = StdRandom.uniform(0, ad1.size());
                assertEquals(lld1.get(randVal), ad1.get(randVal));
            }
        }
    }

    @Test
    public void printTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        int N = 600;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 1000);
                ad1.addFirst(randVal);
                lld1.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 1000);
                ad1.addLast(randVal);
                lld1.addLast(randVal);
            } else if (operationNumber == 2) {
                // removeFirst
                assertEquals(lld1.removeFirst(), ad1.removeFirst());
            } else if (operationNumber == 3) {
                // removeLast
                assertEquals(lld1.removeLast(), ad1.removeLast());
            } else if (operationNumber == 4) {
                // get
                if (ad1.size() == 0) {continue;}
                int randVal = StdRandom.uniform(0, ad1.size());
                assertEquals(lld1.get(randVal), ad1.get(randVal));
            }
        }

        System.out.println("*************ArrayDeque*************");
        ad1.printDeque();
        System.out.println("*************LinkedListDeque*************");
        lld1.printDeque();
    }

    @Test
    public void sizeTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();

        int N = 10000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 5);
            if (operationNumber == 0) {
                // addFirst
                int randVal = StdRandom.uniform(0, 1000);
                ad1.addFirst(randVal);
                lld1.addFirst(randVal);
            } else if (operationNumber == 1) {
                // addLast
                int randVal = StdRandom.uniform(0, 1000);
                ad1.addLast(randVal);
                lld1.addLast(randVal);
            } else if (operationNumber == 2) {
                // removeFirst
                assertEquals(lld1.removeFirst(), ad1.removeFirst());
            } else if (operationNumber == 3) {
                // removeLast
                assertEquals(lld1.removeLast(), ad1.removeLast());
            } else if (operationNumber == 4) {
                // size
                assertEquals(lld1.size(), ad1.size());
            }
        }
    }
}
