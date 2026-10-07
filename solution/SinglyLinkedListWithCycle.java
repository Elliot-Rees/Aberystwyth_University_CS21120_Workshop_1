package solution;

import interfaces.ListWithCycle;

/**
 * Implementation of a Singly Linked list with cycle
 * @author Elliot Rees & Luca Taylor
 * @version 1.0
 */

public class SinglyLinkedListWithCycle<E> extends SinglyLinkedList<E> implements ListWithCycle<E> {


// Links the tail back to the head creating a loop
    @Override
    public void addCycle() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Cannot add a cycle to an empty list");
        }
        tail.setNext(head);
        tail = null;
    }

    @Override
    public void addCycle(int i, int j) throws IllegalArgumentException {
        // Validate indices: both must be within bounds
        if (i < 0 || j < 0 || i >= size || j >= size || j <= i) {
            throw new IllegalArgumentException("Invalid indices for cycle: i=" + i + ", j=" + j);
        }

        // Walk from head to find the node at position i
        Node<E> nodeI = head;
        for (int k = 0; k < i; k++) {
            nodeI = nodeI.getNext();
        }

        // Walk from head to find the node at position j
        Node<E> nodeJ = head;
        for (int k = 0; k < j; k++) {
            nodeJ = nodeJ.getNext();
        }
        nodeJ.setNext(nodeI);
        tail = null;
        size = j + 1;
    }

    @Override
    public boolean containsCycle() { // Floyd's cycle detection algorithm
        if (isEmpty()) {
            return false;
        }

        Node<E> slow = head;
        Node<E> fast = head;

        // Stop if "fast" runs off the end (No cycle)
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();          // one step
            fast = fast.getNext().getNext(); // two steps
            if (slow == fast) {
                // Pointers met so they must be a loop
                return true;
            }
        }
        return false;
    }
}