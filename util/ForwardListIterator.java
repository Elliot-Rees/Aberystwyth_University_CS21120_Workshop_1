package util;

import solution.Node;

import java.util.Iterator;

import java.util.NoSuchElementException;

/**
 * An iterator that traverses a singly linked list from the head to the tail.
 * @author Christine Zarges
 * @version 2.0, 25 September 2023
 */
public class ForwardListIterator<E> implements Iterator<E> {
    /**
     * The current element.
     */
    Node<E> current;

    /**
     * Constructor creating a new list iterator.
     * @param head the head of the list
     */
    public ForwardListIterator(Node<E> head) {
        current = head;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        return (current != null);
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public E next() {
        if ( current == null )
            throw new NoSuchElementException();
        E value = current.getElement();
        current = current.getNext();
        return value;
    }
}
