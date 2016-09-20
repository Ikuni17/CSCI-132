package waitingroomarray;

/**
 *
 * @author Bradley White
 */
public class ArrayQueue<E> {

    // instance variables
    private E[] arrayQueue;
    private int front = 0;
    private int size = 0;

    // constructors
    public ArrayQueue(int capacity) {
        arrayQueue = (E[]) new Object[capacity];
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
    
    // tests whether the queue is full
    public boolean isFull(){
        return size == arrayQueue.length;
    }

    // inserts an element at the end of the queue
    public void enqueue(E item) throws IllegalStateException {
        if (size == arrayQueue.length) {
            throw new IllegalStateException("Queue is full");
        }
        int available = (front + size) % arrayQueue.length;
        arrayQueue[available] = item;
        size++;
    }
    
    // returns the first element of the queue, null if empty
    public E first(){
        if (isEmpty()) return null;
        return arrayQueue[front];
    }
    
    // returns and removes the first element of the queue, null if empty
    public E dequeue(){
        if (isEmpty()) return null;
        E answer = arrayQueue[front];
        arrayQueue[front] = null;
        front = (front +1) % arrayQueue.length;
        size--;
        return answer;
    }
}