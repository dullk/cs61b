package deque;

import org.junit.Test;
import static org.junit.Assert.*;

public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        for (int i = 0; i < 15; i += 1) {
            ad1.addFirst(i);
        }
        ad1.printDeque();
    }

    @Test
    public void addTest() {
        ArrayDeque<Integer> ad1 = new ArrayDeque<>();
        ad1.addFirst(0);
        ad1.addFirst(1);
        ad1.addLast(2);
        ad1.addLast(3);
        ad1.printDeque();

        ArrayDeque<Integer> ad2 = new ArrayDeque<>();
        ad2.addLast(0);
        ad2.addLast(1);
        ad2.addFirst(2);
        ad2.addFirst(3);
        ad2.printDeque();
    }
}
