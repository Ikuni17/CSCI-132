package airlineboarding;

/**
 *
 * @author Bradley White
 */
public class AirlineBoarding {

    // instance variables
    private LinkedListQueue[] arrayQueue = new LinkedListQueue[3];
    LinkedListQueue<Passenger> firstQueue = new LinkedListQueue();
    LinkedListQueue<Passenger> platinumQueue = new LinkedListQueue();
    LinkedListQueue<Passenger> standardQueue = new LinkedListQueue();
    PriorityQueue<Passenger> priorityQueue = new PriorityQueue();

    // constructor
    public AirlineBoarding() {
        arrayQueue[0] = firstQueue;
        arrayQueue[1] = platinumQueue;
        arrayQueue[2] = standardQueue;
    }

    // methods
    public void enqueue(Passenger inPassenger) {
        if (inPassenger.passengerClass == 0) {
            arrayQueue[0].enqueue(inPassenger);
        } else if (inPassenger.passengerClass == 1) {
            arrayQueue[1].enqueue(inPassenger);
        } else if (inPassenger.passengerClass == 2) {
            arrayQueue[2].enqueue(inPassenger);
        } else if (inPassenger.passengerClass == 3){
            priorityQueue.enqueue(inPassenger);
        }
    }

    public Passenger dequeue() {
        Passenger answer;
        if (arrayQueue[0].isEmpty() == false) {
            answer = (Passenger) arrayQueue[0].dequeue();
        } else if (arrayQueue[1].isEmpty() == false) {
            answer = (Passenger) arrayQueue[1].dequeue();
        } else if (arrayQueue[2].isEmpty() == false) {
            answer = (Passenger) arrayQueue[2].dequeue();
        } else {
            answer = null;
        }
        return answer;
    }

    public Passenger dequeueStandBy() {
        return priorityQueue.dequeue();
    }

    public boolean isEmpty() {
        boolean check = true;
        if (arrayQueue[0].isEmpty() == false) {
            check = false;
        } else if (arrayQueue[1].isEmpty() == false) {
            check = false;
        } else if (arrayQueue[2].isEmpty() == false) {
            check = false;
        } 
        return check;
    }
    
    public boolean priorityIsEmpty(){
        return priorityQueue.isEmpty();
    }

}
