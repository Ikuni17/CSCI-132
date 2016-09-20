/**
 *
 * @author Bradley White
 */
public class DoubleLinkedList<E> {
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
        
        public Node<E> getPrevious(){
            return previous;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setPrevious(Node<E> inPrevious){
            previous = inPrevious;
        }
        public void setNext(Node<E> inNext) {
            next = inNext;
        }
    }

    // instance variables
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // constructor for empty list
    public DoubleLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(null, head, null);
        head.setNext(tail);
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
        return head.getNext().getElement();
    }

    // returns the last element in the list
    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getPrevious().getElement();
    }

    // adds an element to the front of the list
    public void addFirst(E inElement) {
        insert(inElement, head, head.getNext());
    }

    // adds an element to the end of the list
    public void addLast(E inElement) {
        insert(inElement, tail.getPrevious(), tail);
    }

    // removes and returns the first element
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }
        return remove(head.getNext());
    }
    
    // removes and returns the last element
    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        return remove(tail.getPrevious());
    }
    
    // inserts an element between the specified nodes
    private void insert(E inElement, Node<E> previous, Node<E> next){
        Node<E> newNode = new Node<>(inElement, previous, next);
        previous.setNext(newNode);
        next.setPrevious(newNode);
        size++;
    }
    
    // removes the given node from the list and returns its element
    private E remove(Node<E> inNode){
        Node<E> previous = inNode.getPrevious();
        Node<E> next = inNode.getNext();
        previous.setNext(next);
        next.setPrevious(previous);
        size--;
        return inNode.getElement();
    }    
}