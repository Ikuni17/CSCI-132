package priorityqueuestandby;

/**
 *
 * @author Bradley White
 */
public class StandbyPassenger implements Comparable<StandbyPassenger> {

    // instance variables
    public String fName;
    public String lName;
    public int longevity;
    public String confirmNum;

    // constructor
    public StandbyPassenger(String inFirst, String inLast, int inLongevity, String inConfirm) {
        fName = inFirst;
        lName = inLast;
        longevity = inLongevity;
        confirmNum = inConfirm;
    }

    // returns first name
    public String getFirst() {
        return fName;
    }

    // returns last name
    public String getLast() {
        return lName;
    }

    // returns longevity
    public int getLongevity() {
        return longevity;
    }

    // returns confirmation number
    public String getConfirmNum() {
        return confirmNum;
    }

    public int compareTo(StandbyPassenger inPassenger) {
        if (this.longevity == inPassenger.longevity) {
            return 0;
        } else if (this.longevity > inPassenger.longevity) {
            return 1;
        } else {
            return -1;
        }
    }
}
