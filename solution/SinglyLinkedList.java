package solution;

import interfaces.List;

import util.ForwardListIterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of a Singly Linked List
 * Keeps a head pointer (start of the list), a tail pointer (end of the
 * list, so addLast is O(1)), and a running size count.
 * @author Elliot Rees & Luca Taylor
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
    public E getFirst() throws  NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.getElement();
    }

    @Override
    public E getLast() throws NoSuchElementException {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.getElement();
    }

    @Override
    public void addFirst(E element) {
        // Wraps new element in a node then points it to the current head
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            // Special case: list is empty so the new node is both the head and tail
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        size ++;
    }

    @Override
    public void addLast(E element) {
        // Tail pointer is kept so finding where the list finishes is O(1)??
        Node<E> newNode = new Node<>(element);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size ++;
    }

    @Override
    public E removeFirst() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E element = head.getElement();
        // Move the head forward by one node, old head is discarded
        head = head.getNext();
        if (head == null) {
            // List is empty, tail must be cleared
            tail = null;
        }
        size --;
        return element;
    }

    @Override
    public E removeLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        E element = tail.getElement();
        if (head == tail) {
            // Only one node in the list removing it empties the list
            head = null;
            tail = null;
        } else {
            Node<E> current = head;
            while (current.getNext() != tail) {
                current = current.getNext();
            }
            // That node becomes the new tail must no longer point forward
            current.setNext(null);                                                                    
            tail = current;
        }
        size--;
        return element;
    }


    @Override
    public boolean contains(E element) {
        // Linear scan from head to tail compareing each element with equals();
        // Null check avoids a NullPointerException if either side is null
        Node<E> current = head;
        while (current != null) {
            E currentElement = current.getElement();
            if (currentElement == null ? element == null : currentElement.equals(element)) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public void reverse() {
        Node<E> previous = null;
        Node<E> current = head;
        tail = head; // Whatever was the head becomes the tail
        while (current != null) {
            Node<E> next = current.getNext();
            current.setNext(previous); // Flip pointer direction
            previous = current; // Step previous forward
            current = next; // Step current forward
        }
        head = previous; // After the loop previous is the old tail (New head)
    }

    @Override
    public Iterator<E> iterator() {
        return new ForwardListIterator<>(head);
    }

}
