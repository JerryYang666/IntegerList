package test;

import main.ArrayIntList;
import main.SortedIntList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedIntListTest {

    SortedIntList uniqueList = new SortedIntList(true);
    SortedIntList uniqueList2 = new SortedIntList(true,5);
    SortedIntList notUniqueList = new SortedIntList(false);
    SortedIntList notUniqueList2 = new SortedIntList(false,5);

    @BeforeEach
    void setUp() {
        uniqueList.add(4);
        uniqueList.add(2);
        uniqueList2.add(4);
        uniqueList2.add(2);
        notUniqueList.add(4);
        notUniqueList.add(2);
        notUniqueList2.add(4);
        notUniqueList2.add(2);
    }

    @Test
    void add() {
        uniqueList.add(1);
        uniqueList2.add(1);
        notUniqueList.add(1);
        notUniqueList2.add(1);
        uniqueList.add(2);
        uniqueList2.add(2);
        notUniqueList.add(2);
        notUniqueList2.add(2);
        assertEquals("S:[1, 2, 4]U",uniqueList.toString());
        assertEquals("S:[1, 2, 4]U",uniqueList2.toString());
        assertEquals("S:[1, 2, 2, 4]",notUniqueList.toString());
        assertEquals("S:[1, 2, 2, 4]",notUniqueList2.toString());
    }

    @Test
    void getUnique() {
        assertTrue(uniqueList.getUnique());
        assertTrue(uniqueList2.getUnique());
        assertFalse(notUniqueList.getUnique());
        assertFalse(notUniqueList2.getUnique());
    }

    @Test
    void setUnique() {
        notUniqueList.add(2);
        notUniqueList2.add(2);
        notUniqueList.setUnique(true);
        notUniqueList2.setUnique(true);
        assertEquals("S:[2, 4]U",notUniqueList.toString());
        assertEquals("S:[2, 4]U",notUniqueList2.toString());
    }

    @Test
    void max() {
        assertEquals(4,uniqueList.max());
    }

    @Test
    void min() {
        assertEquals(2,uniqueList.min());
    }

    @Test
    void testToString() {
        assertEquals("S:[2, 4]U",uniqueList.toString());
        assertEquals("S:[2, 4]U",uniqueList2.toString());
        assertEquals("S:[2, 4]",notUniqueList.toString());
        assertEquals("S:[2, 4]",notUniqueList2.toString());
    }

    @Test
    void indexOf() {
        assertEquals(0,uniqueList.indexOf(2));
        assertEquals(1,uniqueList.indexOf(4));
        assertEquals(-1,uniqueList.indexOf(1));
        assertEquals(-2,uniqueList.indexOf(3));
    }
}