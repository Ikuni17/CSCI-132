package airlineboarding;

import javax.swing.JOptionPane;

/**
 *
 * @author Bradley White
 */
public class Main {

    public static void main(String[] args) {
        // instance variables
        boolean done = false;
        AirlineBoarding airlineBoarding = new AirlineBoarding();
        String[] choices = {"Enqueue Passenger", "Dequeue Passenger", "Dequeue Standby Passenger", "Quit"};
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
                    int inputLongevity;
                    
                    String inputLast = JOptionPane.showInputDialog("Enter passenger last name");
                    int inputClass = Integer.parseInt(JOptionPane.showInputDialog("Enter passenger class. 0 for First Class, 1 for Platinum, 2 for Standard and 3 for Standby"));
                    
                    if (inputClass == 3) {
                        inputLongevity = Integer.parseInt(JOptionPane.showInputDialog("Enter passenger hire date in the form year, month, day. Example: 20140930"));
                    } else {
                        inputLongevity = 0;
                    }
                    
                    String inputConfirm = JOptionPane.showInputDialog("Enter your confirmation number");
                    Passenger tempPassenger = new Passenger(inputLast, inputClass, inputLongevity, inputConfirm);
                    airlineBoarding.enqueue(tempPassenger);
                    break;

                case 1:
                    if (airlineBoarding.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The queue is empty, no passengers!");
                        break;
                    } else {
                        Passenger nextPassenger = airlineBoarding.dequeue();
                        JOptionPane.showMessageDialog(null,
                                "Now serving: " + nextPassenger.getLast() + ", " + nextPassenger.getPassengerClass() + ", Confirmation #" + nextPassenger.getConfirmNum() + ".");
                        break;
                    }

                case 2:
                    if (airlineBoarding.priorityIsEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The queue is empty, no passengers!");
                        break;
                    } else {
                        Passenger nextPassenger = airlineBoarding.dequeueStandBy();
                        JOptionPane.showMessageDialog(null,
                                "Now serving: " + nextPassenger.getLast() + ", " + nextPassenger.getPassengerClass() + ", Confirmation #"  + nextPassenger.getConfirmNum() + ", Hire Date: " + nextPassenger.getLongevity() + ".");
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
