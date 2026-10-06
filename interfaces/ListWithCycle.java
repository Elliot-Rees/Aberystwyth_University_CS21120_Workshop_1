package interfaces;

/**
 * A list interface that allows cycles.
 * Extends the standard list interface but adds methods to add a cycle and detect a cycle.
 * @author Christine Zarges
 * @version 3.0, 30 September 2025
 */
public interface ListWithCycle<E> extends List<E>{
    /**
     * Adds a cycle to the list by linking the tail back to the start.
     * Tail should be null after the cycle has been added.
     *
     * @throws IllegalArgumentException if list is empty
     */
    void addCycle() throws IllegalArgumentException;

    /**
     * Adds a cycle to the list by linking the j-th node back to the i-th node.
     * head = 0, tail = size - 1
     * Updates size to the number of elements in the list.
     * Tail should be null after the cycle has been added.
     *
     * @param i the first node in the cycle
     * @param j the last node in the cycle which connects back to i
     * @throws IllegalArgumentException if list is empty or i or j have illegal values
     */
    void addCycle(int i, int j) throws IllegalArgumentException;

    /**
     * Checks if the list contains a cycle.
     *
     * @return true if the list contains a cycle, false otherwise
     */
    boolean containsCycle();
}
