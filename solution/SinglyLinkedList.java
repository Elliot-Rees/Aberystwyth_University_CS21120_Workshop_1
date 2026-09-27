package solution;

import java.util.NoSuchElementException;

/**
 * @author Elliot Rees
 * @version 1.0
 */

public class SinglyLinkedList<E> implements List<E> {

    protected Node<E> head;
    protected Node<E> tail;
    protected int size;

    public SinglyLinkedList() { // Starts an empty list (no nodes, size 0)
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() { // List with no head node has nothing
        return head == null;
    }

    @Override
    public int getSize() { // Tracks size rather than counting nodes each call
        return size;
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.getElement();
    }

}
