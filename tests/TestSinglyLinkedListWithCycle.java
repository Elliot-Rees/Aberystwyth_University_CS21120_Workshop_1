package tests;

import interfaces.ListWithCycle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import solution.SinglyLinkedListWithCycle;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Some tests to check the implementation of the singly linked list with cycle.
 * @author Christine Zarges
 * @version 3.0, 30 September 2025
 */
public class TestSinglyLinkedListWithCycle {
    private ListWithCycle<String> list;

    @BeforeEach
    public void setUp() {
        list = new SinglyLinkedListWithCycle<>();
    }

    @Test
    @DisplayName("1) addCycle (simple cycle, exception handling)")
    public void testAddCycleSimpleExceptionHandling() {
        // throw exception for empty list
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(),
                "Throw an IllegalArgumentException if list empty.");

        // list should not be modified, i.e., it's still empty and therefore does not contain a cycle
        assertFalse(list.containsCycle(), "List does not contain a cycle.");
        assertEquals(0, list.getSize(), "Size of list should be 0.");
        assertTrue(list.isEmpty(), "List is empty.");
    }

    @Test
    @DisplayName("2) addCycle (simple cycle)")
    public void testAddCycleSimple() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle();

        // iterate over list to check that order of elements is as expected
        Iterator<String> iterator = list.iterator();
        assertEquals("5", iterator.next(), "First element in list incorrect.");
        assertEquals("4", iterator.next(), "Second element in list incorrect.");
        assertEquals("3", iterator.next(), "Third element in list incorrect.");
        assertEquals("2", iterator.next(), "Fourth element in list incorrect.");
        assertEquals("1", iterator.next(), "Fifth element in list incorrect.");
        assertEquals("5", iterator.next(), "List is not cycling back to head.");

        // tail is null
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Tail should be null");
    }

    @Test
    @DisplayName("3) addCycle (complex cycle, exception handling)")
    public void testAddCycleComplexExceptionHandling() {
        // throw exception for empty list
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(2, 2),
                "Throw an IllegalArgumentException if list empty.");

        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // throw exception if i is out of range
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(-1, 2),
                "Throw an IllegalArgumentException if i < 0.");
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(5, 2),
                "Throw an IllegalArgumentException if i > size - 1.");

        // throw exception if j is out of range
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(2, -1),
                "Throw an IllegalArgumentException if j < 0.");
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(2, 5),
                "Throw an IllegalArgumentException if j > size - 1.");

        // throw exception if i is not before j
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(2, 2),
                "Throw an IllegalArgumentException if i == j.");
        assertThrows(IllegalArgumentException.class, () -> list.addCycle(3, 2),
                "Throw an IllegalArgumentException if i > j.");

        // list should not be modified, i.e., still contain the five elements in the original order
        assertFalse(list.containsCycle(), "List does not contain a cycle.");
        assertEquals(5, list.getSize(), "Size of list should be 5.");

        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("5", iterator.next(), "First element in list incorrect.");
        assertEquals("4", iterator.next(), "Second element in list incorrect.");
        assertEquals("3", iterator.next(), "Third element in list incorrect.");
        assertEquals("2", iterator.next(), "Fourth element in list incorrect.");
        assertEquals("1", iterator.next(), "Fifth element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @DisplayName("4) addCycle (complex cycle 1)")
    public void testAddCycleComplex1() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle(0, 4);

        // iterate over list to check that order of elements is as expected
        Iterator<String> iterator = list.iterator();
        assertEquals("5", iterator.next(), "First element in list incorrect.");
        assertEquals("4", iterator.next(), "Second element in list incorrect.");
        assertEquals("3", iterator.next(), "Third element in list incorrect.");
        assertEquals("2", iterator.next(), "Fourth element in list incorrect.");
        assertEquals("1", iterator.next(), "Fifth element in list incorrect.");
        assertEquals("5", iterator.next(), "List is not cycling back to head.");

        // tail is null
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Tail should be null");
    }

    @Test
    @DisplayName("5) addCycle (complex cycle 2)")
    public void testAddCycleComplex2() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle(2, 4);

        // iterate over list to check that order of elements is as expected
        Iterator<String> iterator = list.iterator();
        assertEquals("5", iterator.next(), "First element in list incorrect.");
        assertEquals("4", iterator.next(), "Second element in list incorrect.");
        assertEquals("3", iterator.next(), "Third element in list incorrect.");
        assertEquals("2", iterator.next(), "Fourth element in list incorrect.");
        assertEquals("1", iterator.next(), "Fifth element in list incorrect.");
        assertEquals("3", iterator.next(), "List is not cycling back correctly.");

        // tail is null
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Tail should be null");
    }

    @Test
    @DisplayName("6) addCycle (complex cycle 3)")
    public void testAddCycleComplex3() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle(1, 3);

        // iterate over list to check that order of elements is as expected
        Iterator<String> iterator = list.iterator();
        assertEquals("5", iterator.next(), "First element in list incorrect.");
        assertEquals("4", iterator.next(), "Second element in list incorrect.");
        assertEquals("3", iterator.next(), "Third element in list incorrect.");
        assertEquals("2", iterator.next(), "Fourth element in list incorrect.");
        assertEquals("4", iterator.next(), "List is not cycling back correctly.");

        // tail is null
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Tail should be null");
    }

    @Test
    @DisplayName("7) containsCycle (no cycle)")
    public void testContainsCycleNoCycle() {
        // test for empty list
        assertFalse(list.containsCycle(), "Empty list does not contain a cycle.");

        // add first element and check for cycle
        list.addFirst("1");
        assertFalse(list.containsCycle(), "List with one element does not contain a cycle.");

        // add second element and check for cycle
        list.addFirst("2");
        assertFalse(list.containsCycle(), "List with two elements does not contain a cycle.");

        // add third element and check for cycle
        list.addFirst("3");
        assertFalse(list.containsCycle(), "List with three elements does not contain a cycle.");

        // add two more elements and check for cycle
        list.addLast("4");
        list.addLast("5");
        assertFalse(list.containsCycle(), "List with five elements does not contain a cycle.");
    }

    @Test
    @DisplayName("8) containsCycle (simple cycle)")
    public void testContainsCycleSimpleCycle() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle();

        // check if cycle recognised
        assertTrue(list.containsCycle(), "List contains a cycle.");

        // check if size has been updated to account for potentially cut off elements
        assertEquals(5, list.getSize(), "Size of list should be 5.");
    }

    @Test
    @DisplayName("9) containsCycle (complex cycle 1)")
    public void testContainsCycleComplexCycle1() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle(0, 4);

        // check if cycle recognised
        assertTrue(list.containsCycle(), "List contains a cycle.");

        // check if size has been updated to account for potentially cut off elements
        assertEquals(5, list.getSize(), "Size of list should be 5.");
    }

    @Test
    @DisplayName("10) containsCycle (complex cycle 2)")
    public void testContainsCycleComplexCycle2() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle(2, 4);

        // check if cycle recognised
        assertTrue(list.containsCycle(), "List contains a cycle.");

        // check if size has been updated to account for potentially cut off elements
        assertEquals(5, list.getSize(), "Size of list should be 5.");
    }

    @Test
    @DisplayName("11) containsCycle (complex cycle 3)")
    public void testContainsCycleComplexCycle3() {
        // create list with five elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");
        list.addFirst("4");
        list.addFirst("5");

        // add cycle
        list.addCycle(1, 3);

        // check if cycle recognised
        assertTrue(list.containsCycle(), "List contains a cycle.");

        // check if size has been updated to account for potentially cut off elements
        assertEquals(4, list.getSize(), "Size of list should be 4.");
    }
}
