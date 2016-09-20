package waitingroomarray;

import javax.swing.JOptionPane;

/**
 *
 * @author Bradley White
 */
public class Main {

    public static void main(String[] args) {

        // instance variables
        boolean done = false;
        ArrayQueue<Person> arrayQueue = new ArrayQueue(10);
        int counter = 1;

        String[] choices = {"Enter Client", "Serve Next Client", "Quit"};
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
                    if (arrayQueue.isFull()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The queue is full, come back later!");
                        break;
                    } else {
                        String inputFirst = JOptionPane.showInputDialog("Enter your first name");
                        String inputLast = JOptionPane.showInputDialog("Enter your last name");
                        Person tempPerson = new Person(inputFirst, inputLast, counter);
                        arrayQueue.enqueue(tempPerson);
                        JOptionPane.showMessageDialog(
                                null,
                                "Your number is " + counter + ".");
                        counter++;
                        break;
                    }

                case 1:
                    if (arrayQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The queue is empty, nobody to serve!");
                        break;
                    } else {
                        Person nextPerson = arrayQueue.dequeue();
                        JOptionPane.showMessageDialog(
                                null,
                                "Now serving: " + nextPerson.getPosition() + ". " + nextPerson.getFirst() + " " + nextPerson.getLast() + ".");
                        break;
                    }

                case 2:
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
