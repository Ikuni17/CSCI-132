/**
 *
 * @author Bradley White
 */
public class LinkedListQueue<E> {
    
    // creates an empty LinkedList
    private LinkedList<E> linkedQueue = new LinkedList<>();
    
    // new queue
    public LinkedListQueue(){}
    
    // returns the number of elements in the queue
    public int size(){
        return linkedQueue.size();
    }
    
    // tests whether the queue is empty
    public boolean isEmpty(){
        return linkedQueue.isEmpty();
    }
    
    // inserts an element at the end of the queue
    public void enqueue(E element){
        linkedQueue.addLast(element);
    }
    
    // returns the first element of the queue
    public E first(){
        return linkedQueue.first();
    }
    
    // returns and removes the first element of the queue
    public E dequeue(){
        return linkedQueue.removeFirst();
    }
}
