package com.example.iterable;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagTest {
    private Bag<String> bag;

    @BeforeEach
    public void setUp() {
        bag = new Bag<>();
    }

    // Tests for isEmpty() and size()
    @Test
    public void testNewBagIsEmpty() {
        assertTrue(bag.isEmpty());
        assertEquals(0, bag.size());
    }

    @Test
    public void testBagNotEmptyAfterAdd() {
        bag.add("item");
        assertFalse(bag.isEmpty());
        assertEquals(1, bag.size());
    }

    // Tests for add()
    @Test
    public void testAddSingleItem() {
        bag.add("apple");
        assertEquals(1, bag.size());
        assertTrue(bag.contains("apple"));
    }

    @Test
    public void testAddMultipleItems() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");
        assertEquals(3, bag.size());
    }

    @Test
    public void testAddDuplicateItems() {
        bag.add("apple");
        bag.add("apple");
        bag.add("apple");
        assertEquals(3, bag.size());
    }

    @Test
    public void testAddNullItem() {
        bag.add(null);
        assertEquals(1, bag.size());
        assertTrue(bag.contains(null));
    }

    // Tests for contains()
    @Test
    public void testContainsExistingItem() {
        bag.add("apple");
        assertTrue(bag.contains("apple"));
    }

    @Test
    public void testContainsNonExistingItem() {
        bag.add("apple");
        assertFalse(bag.contains("banana"));
    }

    @Test
    public void testContainsInEmptyBag() {
        assertFalse(bag.contains("apple"));
    }

    @Test
    public void testContainsNull() {
        assertFalse(bag.contains(null));
        bag.add(null);
        assertTrue(bag.contains(null));
    }

    // Tests for remove()
    @Test
    public void testRemoveExistingItem() {
        bag.add("apple");
        assertTrue(bag.remove("apple"));
        assertEquals(0, bag.size());
        assertFalse(bag.contains("apple"));
    }

    @Test
    public void testRemoveNonExistingItem() {
        bag.add("apple");
        assertFalse(bag.remove("banana"));
        assertEquals(1, bag.size());
    }

    @Test
    public void testRemoveFromEmptyBag() {
        assertFalse(bag.remove("apple"));
    }

    @Test
    public void testRemoveDuplicateItem() {
        bag.add("apple");
        bag.add("apple");
        bag.add("apple");
        assertTrue(bag.remove("apple"));
        assertEquals(2, bag.size());
        assertTrue(bag.contains("apple"));
    }

    @Test
    public void testRemoveNull() {
        bag.add(null);
        bag.add("apple");
        assertTrue(bag.remove(null));
        assertEquals(1, bag.size());
        assertFalse(bag.contains(null));
    }

    @Test
    public void testRemoveUntilEmpty() {
        bag.add("apple");
        bag.add("banana");
        bag.remove("apple");
        bag.remove("banana");
        assertTrue(bag.isEmpty());
    }

    // Tests for iterator()
    @Test
    public void testIteratorOnEmptyBag() {
        Iterator<String> iter = bag.iterator();
        assertNotNull(iter);
        assertFalse(iter.hasNext());
    }

    @Test
    public void testIteratorTraversal() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");

        Iterator<String> iter = bag.iterator();
        int count = 0;
        while (iter.hasNext()) {
            String item = iter.next();
            assertNotNull(item);
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    public void testIteratorWithForEach() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");

        int count = 0;
        for (String item : bag) {
            assertNotNull(item);
            count++;
        }
        assertEquals(3, count);
    }

    @Test
    public void testIteratorNextThrowsException() {
        Iterator<String> iter = bag.iterator();
        assertThrows(NoSuchElementException.class, () -> {
            iter.next();
        });
    }

    @Test
    public void testIteratorRemove() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");

        Iterator<String> iter = bag.iterator();
        iter.next();
        iter.remove();
        assertEquals(2, bag.size());
    }

    // Tests with different types
    @Test
    public void testIntegerBag() {
        Bag<Integer> intBag = new Bag<>();
        intBag.add(1);
        intBag.add(2);
        intBag.add(3);

        assertEquals(3, intBag.size());
        assertTrue(intBag.contains(2));
        assertTrue(intBag.remove(2));
        assertFalse(intBag.contains(2));
    }

    // Integration tests
    @Test
    public void testComplexOperationSequence() {
        bag.add("apple");
        bag.add("banana");
        bag.add("cherry");
        bag.add("apple");

        assertEquals(4, bag.size());
        assertTrue(bag.remove("apple"));
        assertEquals(3, bag.size());
        assertTrue(bag.contains("apple"));

        bag.add("date");
        assertEquals(4, bag.size());

        int count = 0;
        for (String item : bag) {
            count++;
        }
        assertEquals(4, count);
    }

    @Test
    public void testLargeNumberOfItems() {
        for (int i = 0; i < 1000; i++) {
            bag.add("item" + i);
        }
        assertEquals(1000, bag.size());
        assertTrue(bag.contains("item500"));
        assertTrue(bag.remove("item500"));
        assertEquals(999, bag.size());
    }
}