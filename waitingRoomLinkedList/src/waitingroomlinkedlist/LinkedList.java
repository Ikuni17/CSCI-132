package waitingroomlinkedlist;

/**
 *
 * @author Bradley White
 */
public class LinkedList<E> {

    // nested Node class
    private static class Node<E> {

        private E element;
        private Node<E> next;

        public Node(E newElement, Node<E> newLink) {
            element = newElement;
            next = newLink;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> newLink) {
            next = newLink;
        }
    }

    // instance variables
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // constructor for empty list
    public LinkedList() {
    }

    // methods
    // returns size of the list
    public int size() {
        return size;
    }

    // tests whether the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // returns the first element in the list
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    // returns the last element in the list
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    // adds an element to the front of the list
    public void addFirst(E newElement) {
        head = new Node<>(newElement, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    // adds an element to the end of the list
    public void addLast(E newElement) {
        Node<E> tempNode = new Node<>(newElement, null);
        if (isEmpty()) {
            head = tempNode;
        } else {
            tail.setNext(tempNode);
        }
        tail = tempNode;
        size++;
    }

    // removes and returns the first element
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        E firstNode = head.getElement();
        head = head.getNext();
        size--;
        if (size == 0) {
            tail = null;
        }
        return firstNode;
    }
}