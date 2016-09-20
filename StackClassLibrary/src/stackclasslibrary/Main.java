package stackclasslibrary;

import java.util.Stack;
import javax.swing.JOptionPane;

/**
 *
 * @author Bradley White
 */

public class Main {

    public static void main(String[] args) {
        // instance variables
        boolean done = false;
        int counter = 1;
        Stack<Person> personStack = new Stack();

        String[] choices = {"Enter Client", "Serve Next Client", "Peek", "Quit"};
        while (!done) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Click a choice",
                    "Waiting Room Simulation",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]);

            switch (choice) {
                case 0:
                    String inputFirst = JOptionPane.showInputDialog("Enter your first name");
                    String inputLast = JOptionPane.showInputDialog("Enter your last name");
                    Person tempPerson = new Person(inputFirst, inputLast, counter);
                    personStack.push(tempPerson);
                    JOptionPane.showMessageDialog(
                            null,
                            "Your number is " + counter + ".");
                    counter++;
                    break;

                case 1:
                    if (personStack.empty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The stack is empty, nobody to serve!");
                        break;
                    } else {
                        Person nextPerson = personStack.pop();
                        JOptionPane.showMessageDialog(
                                null,
                                "Now serving: " + nextPerson.getPosition() + ". " + nextPerson.getFirst() + " " + nextPerson.getLast() + ".");
                        break;
                    }

                case 2:
                    if (personStack.empty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The stack is empty, nobody to peek!");
                        break;
                    } else {
                        Person nextPerson = personStack.peek();
                        JOptionPane.showMessageDialog(
                                null,
                                "Peeking at next: " + nextPerson.getPosition() + ". " + nextPerson.getFirst() + " " + nextPerson.getLast() + ".");
                        break;
                    }

                case 3:
                    done = true;
                    JOptionPane.showMessageDialog(
                            null,
                            "...quitting!",
                            "",
                            JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }
}