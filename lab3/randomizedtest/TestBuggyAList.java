package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThreeRemove() {
        AListNoResizing<Integer> l1 = new AListNoResizing<>();
        BuggyAList<Integer> l2 = new BuggyAList<>();
        l1.addLast(4);
        l2.addLast(4);
        l1.addLast(5);
        l2.addLast(5);
        l1.addLast(6);
        l2.addLast(6);

        assertEquals(l1.size(), l2.size());
        assertEquals(l1.removeLast(), l2.removeLast());
        assertEquals(l1.removeLast(), l2.removeLast());
        assertEquals(l1.removeLast(), l2.removeLast());
    }

    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> buggyL = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                buggyL.addLast(randVal);
                // System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(size, buggyL.size());
                // System.out.println("size: " + size);
            } else if (operationNumber == 2) {
                // getLast
                if (L.size() == 0) {
                    continue;
                }
                int last = L.getLast();
                assertEquals(last, (int) buggyL.getLast());
                // System.out.println("getLast: " + last);
            } else if (operationNumber == 3) {
                // removeLast
                if (L.size() == 0) {
                    continue;
                }
                int last = L.removeLast();
                assertEquals(last, (int) buggyL.removeLast());
                // System.out.println("removeLast: " + last);
            }
        }
    }
}
