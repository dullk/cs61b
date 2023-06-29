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
}
