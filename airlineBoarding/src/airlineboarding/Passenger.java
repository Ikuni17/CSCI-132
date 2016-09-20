package airlineboarding;

/**
 *
 * @author Bradley White
 */
public class Passenger implements Comparable<Passenger> {

    // instance variables
    public String lName;
    public int longevity, passengerClass;
    public String confirmNum;

    // constructor
    public Passenger(String inLast, int inPassengerClass, int inLongevity, String inConfirm) {
        lName = inLast;
        longevity = inLongevity;
        confirmNum = inConfirm;
        passengerClass = inPassengerClass;
    }

    // returns last name
    public String getLast() {
        return lName;
    }

    // returns the passenger's class
    public String getPassengerClass() {
        String className;
        if (this.passengerClass == 0) {
            className = "First Class Passenger";
        } else if (this.passengerClass == 1) {
            className = "Platinum Passenger";
        } else if (this.passengerClass == 2) {
            className = "Standard Passenger";
        } else {
            className = "Standby Passenger";
        }
        return className;
    }

    // returns longevity
    public int getLongevity() {
        return longevity;
    }

    // returns confirmation number
    public String getConfirmNum() {
        return confirmNum;
    }

    public int compareTo(Passenger inPassenger) {
        if (this.longevity == inPassenger.longevity) {
            return 0;
        } else if (this.longevity > inPassenger.longevity) {
            return 1;
        } else {
            return -1;
        }
    }
}
