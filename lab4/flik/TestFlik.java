package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestFlik {
    @Test
    public void testFlik() {
        assertTrue(Flik.isSameNumber(1, 1));
        assertTrue(Flik.isSameNumber(500, 500));
        assertTrue(Flik.isSameNumber(23523, 23523));
        assertTrue(Flik.isSameNumber(23, 23));
        assertTrue(Flik.isSameNumber(1745363, 1745363));
        assertFalse(Flik.isSameNumber(346, 436745));
        assertFalse(Flik.isSameNumber(23534634, 35));
        assertFalse(Flik.isSameNumber(500, 436745));
        assertFalse(Flik.isSameNumber(985056, 500));

    }
}
