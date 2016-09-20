/**
 *
 * @author Bradley White
 */
public class PriorityQueue<E extends Comparable<E>> {

    // nested Node class
    private static class Node<E> {

        private E element;
        private Node<E> next;
        private Node<E> previous;

        public Node(E inElement, Node<E> inPrevious, Node<E> inNext) {
            element = inElement;
            previous = inPrevious;
            next = inNext;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getPrevious() {
            return previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrevious(Node<E> inPrevious) {
            previous = inPrevious;
        }

        public void setNext(Node<E> inNext) {
            next = inNext;
        }
    }

    // instance variables
    public Node<E> head = null;
    public Node<E> tail = null;
    private int size = 0;

    // new queue
    public PriorityQueue() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
    }

    // methods
    // returns the number of elements in the queue
    public int size() {
        return size;
    }

    // tests whether the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // inserts an element into the specific place based on a key
    public void enqueue(E inNode) {
        Node<E> currentNode;
        currentNode = head.next;

        while ((currentNode != tail) && (currentNode.getElement().compareTo(inNode) <= 0)) {
            currentNode = currentNode.next;
        }

        insert(inNode, currentNode.previous, currentNode);
    }

    // returns the first element of the queue
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getNext().getElement();
    }

    // returns and removes the first element of the queue
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        return remove(head.getNext());
    }

    // inserts an element between the specified nodes
    private void insert(E inElement, Node<E> previous, Node<E> next) {
        Node<E> newNode = new Node<>(inElement, previous, next);
        previous.setNext(newNode);
        next.setPrevious(newNode);
        size++;
    }

    // removes the given node from the list and returns its element
    private E remove(Node<E> inNode) {
        Node<E> previous = inNode.getPrevious();
        Node<E> next = inNode.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
        size--;
        return inNode.getElement();
    }
}
