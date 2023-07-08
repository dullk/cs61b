package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class MaxArrayDequeTest {

    public class Cat implements Comparable<Cat> {
        public String name;
        public int length;
        public int age;
        public Cat(String name, int length, int age) {
            this.name = name;
            this.length = length;
            this.age = age;
        }
        /** Natural order is length. */
        public int compareTo(Cat other) {
            return this.length - other.length;
        }
    }

    private static class LengthComparator implements Comparator<Cat> {
        public int compare(Cat a, Cat b) {
            return a.length - b.length;
        }
    }
    public static Comparator<Cat> getLengthComparator() {
        return new LengthComparator();
    }
    private static class NameComparator implements Comparator<Cat> {
        public int compare(Cat a, Cat b) {
            return a.name.compareTo(b.name);
        }
    }
    public static Comparator<Cat> getNameComparator() {
        return new NameComparator();
    }

    private static class AgeComparator implements Comparator<Cat> {
        public int compare(Cat a, Cat b) {
            return a.age - b.age;
        }
    }
    public static Comparator<Cat> getAgeComparator() {
        return new AgeComparator();
    }
    @Test
    public void nameComparatorTest() {
        MaxArrayDeque<Cat> cd = new MaxArrayDeque<>(getNameComparator());
        Cat c1 = new Cat("Black", 12, 3);
        Cat c2 = new Cat("White", 9, 1);
        Cat c3 = new Cat("Orange", 14, 4);
        Cat c4 = new Cat("Blue", 15, 6);
        cd.addFirst(c1);
        cd.addFirst(c2);
        cd.addFirst(c3);
        cd.addFirst(c4);
        assertEquals(c2, cd.max());
    }

    @Test
    public void lengthComparatorTest() {
        MaxArrayDeque<Cat> cd = new MaxArrayDeque<>(getNameComparator());
        Cat c1 = new Cat("Black", 12, 3);
        Cat c2 = new Cat("White", 9, 1);
        Cat c3 = new Cat("Orange", 14, 4);
        Cat c4 = new Cat("Blue", 15, 6);
        cd.addFirst(c1);
        cd.addFirst(c2);
        cd.addFirst(c3);
        cd.addFirst(c4);
        assertEquals(c4, cd.max(getLengthComparator()));
    }

    @Test
    public void ageComparatorTest() {
        MaxArrayDeque<Cat> cd = new MaxArrayDeque<>(getAgeComparator());
        Cat c1 = new Cat("Black", 12, 3);
        Cat c2 = new Cat("White", 9, 1);
        Cat c3 = new Cat("Orange", 14, 4);
        Cat c4 = new Cat("Blue", 15, 6);
        cd.addFirst(c1);
        cd.addFirst(c2);
        cd.addFirst(c3);
        cd.addFirst(c4);
        assertTrue(c4.compareTo(c1) > 0);
        assertTrue(c4.compareTo(c2) > 0);
        assertTrue(c4.compareTo(c3) > 0);
        assertEquals(c4, cd.max(getAgeComparator()));
    }
}
