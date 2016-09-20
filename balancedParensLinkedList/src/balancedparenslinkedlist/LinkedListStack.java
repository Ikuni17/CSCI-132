package balancedparenslinkedlist;

/**
 *
 * @author Brad
 */
public class LinkedListStack {

    Node head;

    public LinkedListStack() {
        head = null;
    }

    public void push(char newdata) {
        Node newNode = new Node(newdata);
        if (head == null) {
            head = newNode;
            return;
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public boolean isEmpty() {
        return (head == null);
    }

}
