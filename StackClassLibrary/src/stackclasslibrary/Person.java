package stackclasslibrary;
/**
 *
 * @author Bradley White
 */

public class Person {
    
    // instance variables
    public String fName;
    public String lName;
    public int position;
    
    // constructor
    public Person(String inFirst, String inLast, int inPos){
        fName = inFirst;
        lName = inLast;
        position = inPos;
    }
    
    // returns first name
    public String getFirst(){
        return fName;
    }
    
    // returns last name
    public String getLast(){
        return lName;
    }
    
    // returns position in queue
    public int getPosition(){
        return position;
    }
}