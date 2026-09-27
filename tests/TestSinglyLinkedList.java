package tests;

import org.junit.jupiter.api.Timeout;
import util.ForwardListIterator;
import interfaces.List;
import solution.SinglyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Some tests to check the implementation of the singly linked list.
 * @author Christine Zarges
 * @version 3.0, 30 September 2025
 */
public class TestSinglyLinkedList {
    private List<String> list;

    @BeforeEach
    public void setUp() {
        list = new SinglyLinkedList<>();
    }

    @Test
    @DisplayName("1) iterator")
    public void testIterator() {
        // test if iterator has been initialised correctly
        assertInstanceOf(ForwardListIterator.class, list.iterator(), "Method iterator() must return ForwardListIterator object.");
        assertFalse(list.iterator().hasNext(), "Iterator on empty list must return false for hasNext() method.");
    }

    @Test
    @DisplayName("2) empty list (properties)")
    public void testEmptyListProperties() {
        // test if empty list has size 0
        assertEquals(0, list.getSize(), "Size of empty list must be 0.");

        // test if isEmpty method works correctly on an empty list
        assertTrue(list.isEmpty(), "Method isEmpty() must return true for an empty list.");
    }

    @Test
    @DisplayName("3) get (empty list).")
    public void testGetEmptyList() {
        // throw an exception if trying to access an element from an empty list
        assertThrows(NoSuchElementException.class, () -> list.getFirst(),
                "Throw an NoSuchElementException if user tries to retrieve the first element from an empty list.");
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Throw an NoSuchElementException if user tries to retrieve the last element from an empty list.");
    }

    @Test
    @DisplayName("4) add (head, single element)")
    public void testAddHeadSingleElement() {
        // add one element
        list.addFirst("1");

        // getFirst method
        assertEquals("1", list.getFirst(), "Head must reference inserted element.");
        assertEquals("1", list.getFirst(), "GetFirst has modified list.");

        // getLast method
        assertEquals("1", list.getLast(),    "Tail must reference inserted element.");
        assertEquals("1", list.getLast(),    "GetTail has modified list.");

        // properties
        assertEquals(1, list.getSize(), "Size of list must be 1.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 1.");

        // iterator
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("1", iterator.next(), "Iterator must return inserted element.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @DisplayName("5) add (head, two elements)")
    public void testAddHeadTwoElements () {
        // add two elements
        list.addFirst("1");
        list.addFirst("2");

        // get methods
        assertEquals("2", list.getFirst(), "First element in list incorrect.");
        assertEquals("1", list.getLast(), "Last element in list incorrect.");

        // properties
        assertEquals(2, list.getSize(), "Size of list must be 2.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 2.");

        // iterator
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("2", iterator.next(), "First element in list incorrect.");
        assertEquals("1", iterator.next(), "Second element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @DisplayName("6) add (head, three elements)")
    public void testAddHeadThreeElements () {
        // add three elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");

        // get methods
        assertEquals("3", list.getFirst(), "First element in list incorrect.");
        assertEquals("1", list.getLast(), "Last element in list incorrect.");

        // properties
        assertEquals(3, list.getSize(), "Size of list must be 3.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 3.");

        // iterator
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("3", iterator.next(), "First element in list incorrect.");
        assertEquals("2", iterator.next(), "Second element in list incorrect.");
        assertEquals("1", iterator.next(), "Third element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    @DisplayName("7) size (efficiency)")
    public void testSizeEfficiency() {
        // repeatedly add elements and calculate size
        for (int i = 0; i < 100000; i++) {
            list.addFirst(Integer.toString(i));
            assertEquals(i+1, list.getSize(), "Size of list must be ."+(i+1)+".");
        }
    }

    @Test
    @DisplayName("8) add (tail, single element)")
    public void testAddTailSingleElement() {
        // add one element
        list.addLast("1");

        // get methods
        assertEquals("1", list.getFirst(), "Head must reference inserted element.");
        assertEquals("1", list.getLast(),    "Tail must reference inserted element.");

        // properties
        assertEquals(1, list.getSize(), "Size of list must be 1.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 1.");

        // iterator
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("1", iterator.next(), "Iterator must return inserted element.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @DisplayName("9) add (tail, two elements)")
    public void testAddTailTwoElements () {
        // add two elements
        list.addLast("1");
        list.addLast("2");

        // get methods
        assertEquals("1", list.getFirst(), "First element in list incorrect.");
        assertEquals("2", list.getLast(), "Last element in list incorrect.");

        // properties
        assertEquals(2, list.getSize(), "Size of list must be 2.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 2.");

        // iterator
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("1", iterator.next(), "First element in list incorrect.");
        assertEquals("2", iterator.next(), "Second element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @DisplayName("10) add (tail, three elements)")
    public void testAddTailThreeElements () {
        // add three elements
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        // get methods
        assertEquals("1", list.getFirst(), "First element in list incorrect.");
        assertEquals("3", list.getLast(), "Last element in list incorrect.");

        // properties
        assertEquals(3, list.getSize(), "Size of list must be 3.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 3.");

        // iterator
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("1", iterator.next(), "First element in list incorrect.");
        assertEquals("2", iterator.next(), "Second element in list incorrect.");
        assertEquals("3", iterator.next(), "Third element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");
    }

    @Test
    @DisplayName("11) remove (empty list)")
    public void testEmptyListRemove() {
        // throw an exception if trying to remove an element from an empty list
        assertThrows(NoSuchElementException.class, () -> list.removeFirst(),
                "Throw an NoSuchElementException if user tries to remove the first element from an empty list.");
        assertThrows(NoSuchElementException.class, () -> list.removeLast(),
                "Throw an NoSuchElementException if user tries to remove the last element from an empty list.");
    }

    @Test
    @DisplayName("12) remove (head)")
    public void testRemoveHead () {
        // create list with three elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");

        // remove first element from front
        assertEquals("3", list.removeFirst(), "First element in list incorrect.");

        // properties
        assertEquals(2, list.getSize(), "Size of list must be 2.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 2.");

        // iterator over remaining list
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("2", iterator.next(), "First element in list incorrect.");
        assertEquals("1", iterator.next(), "Second element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");

        // remove remaining elements from front
        assertEquals("2", list.removeFirst(), "Second element in list incorrect.");
        assertEquals("1", list.removeFirst(), "Third element in list incorrect.");

        // check that list is now empty
        assertEquals(0, list.getSize(), "Size of list must be 0.");
        assertTrue(list.isEmpty(), "Method isEmpty() must return true for an empty list.");

        // throw exception on now empty list
        assertThrows(NoSuchElementException.class, () -> list.removeFirst(),
                "Throw an NoSuchElementException if user tries to remove an element from an empty list.");
    }

    @Test
    @DisplayName("13) remove (tail)")
    public void testRemoveTail() {
        // create list with three elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");

        // remove first element from back
        assertEquals("1", list.removeLast(), "Third element in list incorrect.");

        // properties
        assertEquals(2, list.getSize(), "Size of list must be 2.");
        assertFalse(list.isEmpty(), "Method isEmpty() must return false for a list of size 2.");

        // iterator over remaining list
        Iterator<String> iterator = list.iterator();
        assertTrue(iterator.hasNext(), "Iterator must return true for hasNext() method.");
        assertEquals("3", iterator.next(), "First element in list incorrect.");
        assertEquals("2", iterator.next(), "Second element in list incorrect.");
        assertFalse(iterator.hasNext(), "Iterator must return false for hasNext() method.");

        // remove remaining elements from back
        assertEquals("2", list.removeLast(), "Second element in list incorrect.");
        assertEquals("3", list.removeLast(), "First element in list incorrect.");

        // check that list is now empty
        assertEquals(0, list.getSize(), "Size of list must be 0.");
        assertTrue(list.isEmpty(), "Method isEmpty() must return true for an empty list.");

        // throw exception on now empty list
        assertThrows(NoSuchElementException.class, () -> list.removeLast(),
                "Throw an NoSuchElementException if user tries to remove an element from an empty list.");
    }

    @Test
    @DisplayName("14) contains (simple strings)")
    public void testContains1() {
        // test on empty list
        assertFalse(list.contains("1"), "Empty list does not contain any elements.");

        // create list with 3 elements
        list.addFirst("1");
        list.addFirst("2");
        list.addFirst("3");

        // check for all three elements
        assertTrue(list.contains("1"), "List does not contain element 1.");
        assertTrue(list.contains("2"), "List does not contain element 2.");
        assertTrue(list.contains("3"), "List does not contain element 3.");

        // check element that does not exist
        assertFalse(list.contains("4"), "List contains additional element.");
    }

    @Test
    @DisplayName("15) contains (more complex strings)")
    public void testContains2() {
        // forcing the creation of two identical strings with different addresses
        String elementInList = new String("CS21120");
        String elementNotInList = new String("CS21120");

        // add element to list
        list.addFirst(elementInList);

        // check if equals check is performed correctly (instead of ==)
        assertTrue(list.contains(elementInList), "List does not contain added element.");
        assertTrue(list.contains(elementNotInList), "List does not seem to properly compare objects. Have you used equals instead of ==?");
    }


    @Test
    @DisplayName("16) reverse")
    public void testReverse() {
        Iterator<String> iterator = list.iterator();

        // test on empty list - should not do anything
        list.reverse();
        assertFalse(iterator.hasNext(), "Iterator on empty list must return false for hasNext() method.");

        // head and tail
        assertThrows(NoSuchElementException.class, () -> list.getFirst(),
                "Throw an NoSuchElementException if user tries to retrieve the first element from an empty list.");
        assertThrows(NoSuchElementException.class, () -> list.getLast(),
                "Throw an NoSuchElementException if user tries to retrieve the last element from an empty list.");

        // create list with three elements
        list.addLast("1");
        list.addLast("2");
        list.addLast("3");

        // head and tail
        assertEquals("1", list.getFirst(), "First element in list incorrect.");
        assertEquals("3", list.getLast(), "Last element in list incorrect.");

        // Check initial order: 1 -> 2 -> 3
        iterator = list.iterator();
        assertEquals("1", iterator.next(), "First element in original list incorrect.");
        assertEquals("2", iterator.next(), "Second element in original list incorrect.");
        assertEquals("3", iterator.next(), "Third element in original list incorrect.");

        list.reverse();

        // head and tail
        assertEquals("3", list.getFirst(), "First element in list incorrect.");
        assertEquals("1", list.getLast(), "Last element in list incorrect.");

        // Checked reverse order: 3 -> 2 -> 1
        iterator = list.iterator();
        assertEquals("3", iterator.next(), "First element in reversed list incorrect.");
        assertEquals("2", iterator.next(), "Second element in reversed list incorrect.");
        assertEquals("1", iterator.next(), "Third element in reversed list incorrect.");
    }

}
