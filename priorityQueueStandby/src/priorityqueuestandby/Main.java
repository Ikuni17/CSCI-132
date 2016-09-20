package priorityqueuestandby;

import javax.swing.JOptionPane;

/**
 *
 * @author Bradley White
 */
public class Main {

    public static void main(String[] args) {
        // instance variables
        boolean done = false;
        PriorityQueue<StandbyPassenger> priorityQueue = new PriorityQueue();
        String[] choices = {"Enqueue Passenger", "Dequeue Passenger", "Check First", "Quit"};
        while (!done) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Click a choice",
                    "Standby Passenger Queue",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]);

            switch (choice) {
                case 0:
                        String inputFirst = JOptionPane.showInputDialog("Enter passenger first name");
                        String inputLast = JOptionPane.showInputDialog("Enter passenger last name");
                        int inputLongevity = Integer.parseInt(JOptionPane.showInputDialog("Enter passenger hire date in the form year, month, day. Example: 20140930"));
                        String inputConfirm = JOptionPane.showInputDialog("Enter your confirmation number");
                        StandbyPassenger tempPassenger = new StandbyPassenger(inputFirst, inputLast, inputLongevity, inputConfirm);
                        priorityQueue.enqueue(tempPassenger);
                        break;

                case 1:
                    if (priorityQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The queue is empty, nobody to serve!");
                        break;
                    } else {
                        StandbyPassenger nextPassenger = priorityQueue.dequeue();
                        JOptionPane.showMessageDialog(null,
                                "Now serving: " + nextPassenger.getFirst() + " " + nextPassenger.getLast() + ", Confirmation #"  + nextPassenger.getConfirmNum() + ", Hire Date: " + nextPassenger.getLongevity() + ".");
                        break;
                    }

                case 2:
                    if (priorityQueue.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The queue is empty, nobody in first!");
                        break;
                    } else {
                        StandbyPassenger nextPassenger = priorityQueue.first();
                        JOptionPane.showMessageDialog(
                                null,
                                "First Passenger is: " + nextPassenger.getFirst() + " " + nextPassenger.getLast() + ", Confirmation #"  + nextPassenger.getConfirmNum() + ", Hire Date: " + nextPassenger.getLongevity() + ".");
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