package solution;

import interfaces.ListWithCycle;

public class SinglyLinkedListWithCycle <E> extends SinglyLinkedList<E> implements ListWithCycle<E> {

    // Links tail back to the head creating one loop
    @Override
    public void addCycle() {
        if(isEmpty()) {
            throw new IllegalArgumentException("List is Empty");
        }
        tail.setNext(head);
        tail = null;
    }

    @Override
    public void addCycle(int i, int j) throws IllegalArgumentException {
        if (i < 0 || j < 0 || i >= size || j >= size || j < i) {
            throw new IllegalArgumentException("Invalid indices for cycle: i=" + i + ", j=" +j);
        }
        // Walk from head to find the node at position i
        Node<E> nodeI = head;
        for (int k = 0; k < i; k++){
            nodeI = nodeI.getNext();
        }
        // Walk from head to find the node at position j
        Node<E> nodeJ = head;
        for (int k = 0; k < j; k++) {
            nodeJ = nodeJ.getNext();
        }

        nodeJ.setNext(nodeI);

        tail = null;
    }

    @Override
    public boolean containsCycle() {
        if (isEmpty()) {
            return false;
        }
        Node<E> slow = head;
        Node<E> fast = head;
        // Stop if "fast" runs off the end (means there's no cycle)
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();          // One step
            fast = fast.getNext().getNext(); // Two steps
            if (slow == fast) {
                // Pointers met,  must be going around a loop
                return true;
            }
        }
        return false;
    }
}
