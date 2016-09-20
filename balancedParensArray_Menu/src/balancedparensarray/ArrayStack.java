package balancedparensarray;

/**
 *
 * @author Bradley White
 */
public class ArrayStack {

    private final int stackSize = 100;
    private char[] stackArray = new char[stackSize];
    private int top = 0;

    public void push(char inputChar) {
        stackArray[top] = inputChar;
        top++;
    }

    public char pop() {
        top--;
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public boolean isFull() {
        return (top == stackSize);
    }
}