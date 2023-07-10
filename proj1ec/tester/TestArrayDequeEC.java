package tester;

import static org.junit.Assert.*;
import org.junit.Test;
import student.StudentArrayDeque;
import edu.princeton.cs.introcs.StdRandom;

public class TestArrayDequeEC {
    @Test
    public void studentArrayDequeTest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> ads1 = new ArrayDequeSolution<>();
        StringBuilder errorMessage = new StringBuilder();

        for (int i = 0; i < 5000; i += 1) {
            int randomInt = StdRandom.uniform(0, 4);

            if (randomInt == 0) {
                sad1.addLast(i);
                ads1.addLast(i);
                errorMessage.append("addLast(").append(i).append(")\n");
            } else if (randomInt == 1) {
                sad1.addFirst(i);
                ads1.addFirst(i);
                errorMessage.append("addFirst(").append(i).append(")\n");
            } else if (randomInt == 2) {
                if (sad1.isEmpty() || ads1.isEmpty()) {
                    continue;
                }
                errorMessage.append("removeFirst()\n");
                assertEquals(errorMessage.toString(), ads1.removeFirst(), sad1.removeFirst());
            } else if (randomInt == 3) {
                if (sad1.isEmpty() || ads1.isEmpty()) {
                    continue;
                }
                errorMessage.append("removeLast()\n");
                assertEquals(errorMessage.toString(), ads1.removeLast(), sad1.removeLast());
                }
        }
    }
}
