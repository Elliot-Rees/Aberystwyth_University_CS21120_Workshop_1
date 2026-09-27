package interfaces;

import java.util.NoSuchElementException;

/**
 * A list interface.
 * @author Christine Zarges
 * @version 3.0, 30 September 2025
 */
public interface List<E> extends Iterable<E> {
    /**
     * Determines if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Determines the number of elements in the list
     *
     * @return the number of elements in the list
     */
    int getSize();

    /**
     * Get the element at the head of the list.
     *
     * @return the first element in the list
     * @throws NoSuchElementException if head is null
     */
    E getFirst() throws NoSuchElementException;

    /**
     * Get the element at the tail of the list.
     *
     * @return the last element in the list
     * @throws NoSuchElementException if tail is null
     */
    E getLast() throws NoSuchElementException;

    /**
     * Adds a new element to the front of the list.
     *
     * @param element the element to be added
     */
    void addFirst(E element);

    /**
     * Adds a new element to the back of the list.
     *
     * @param element the element to be added
     */
    void addLast(E element);

    /**
     * Removes the element at the front of the list.
     *
     * @return the element at the front of the list
     * @throws NoSuchElementException if list is empty
     */
    E removeFirst() throws NoSuchElementException;

    /**
     * Removes the element at the back of the list.
     *
     * @return the element at the back of the list
     * @throws NoSuchElementException if list is empty
     */
    E removeLast() throws NoSuchElementException;

    /**
     * Checks if the list contains a given element.
     * Equality is checked in terms of the values in the objects, not in terms of identical references.
     *
     * @param element the element to the searched for
     * @return true if the list contains the element, false otherwise
     */
    boolean contains(E element);

    /**
     * Reverse the order of the nodes in a singly linked list
     */
    void reverse();
}
