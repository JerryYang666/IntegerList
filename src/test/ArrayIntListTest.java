package test;

import main.ArrayIntList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntListTest{

    ArrayIntList testList = new ArrayIntList();
    ArrayIntList testList2 = new ArrayIntList(5);

    @BeforeEach
    void setUp() {
        testList.add(2);
        testList2.add(2);
        testList.add(4);
        testList2.add(4);
    }

    @org.junit.jupiter.api.Test
    void add() {
        assertEquals("[2, 4]",testList.toString());
        assertEquals("[2, 4]",testList2.toString());
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        testList.add(1,3);
        testList2.add(1,3);
        assertEquals("[2, 3, 4]",testList.toString());
        assertEquals("[2, 3, 4]",testList2.toString());
    }

    @org.junit.jupiter.api.Test
    void get() {
        assertEquals(4,testList.get(1));
        assertEquals(4,testList2.get(1));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        testList.add(1,3);
        testList2.add(1,3);
        assertEquals(1,testList.indexOf(3));
        assertEquals(1,testList2.indexOf(3));
    }

    @org.junit.jupiter.api.Test
    void remove() {
        testList.add(1,3);
        testList2.add(1,3);
        testList.remove(1);
        testList2.remove(1);
        assertEquals("[2, 4]",testList.toString());
        assertEquals("[2, 4]",testList2.toString());
    }

    @org.junit.jupiter.api.Test
    void size() {
        assertEquals(2,testList.size());
        assertEquals(2,testList2.size());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("[2, 4]",testList.toString());
        assertEquals("[2, 4]",testList2.toString());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        testList.clear();
        testList2.clear();
        assertEquals("[]",testList.toString());
        assertEquals("[]",testList2.toString());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        assertTrue(testList.contains(2));
        assertTrue(testList2.contains(4));
        assertFalse(testList.contains(3));
        assertFalse(testList2.contains(3));
    }

    @org.junit.jupiter.api.Test
    void ensureCapacity() {
        testList2.ensureCapacity(8);
        assertEquals(8,testList2.getArray().length);
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertFalse(testList.isEmpty());
        assertFalse(testList2.isEmpty());
    }
}