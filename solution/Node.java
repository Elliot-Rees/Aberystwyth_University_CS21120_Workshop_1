package solution;

/**
 * Each node holds one piece of data (element)
 * and a reference to the next node in the chain.
 * The last node's next is always null.
 *
 * @author Elliot Rees & Luca Taylor
 * @version 1.0
 */
public class Node<E> {

    private final E element; // Data Stored
    private Node<E> next; // Reference to next node

    public Node(E element) { // Creates a new node (Has no link yet)
        this.element = element;
        this.next = null;
    }

    public E getElement() {
        return element;
    }

   /* public void setElement(E element) { Code not used in final solution but is apart of worksheet setup.
        this.element = element;
    }
*/
    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }
}