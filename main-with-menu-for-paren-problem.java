package csci132fall2014balancedparenstack;

import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String args[]) {
        boolean done = false;
        String inputString;

        String[] choices = {"Enter String", "quit"};
        while (!done) {
            int choice = JOptionPane.showOptionDialog(
                    null,
                    "Click a choice",
                    "Stack Operations Menu",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    choices,
                    choices[0]);
            
            switch (choice){
                case 0:           
                    // Allow the user to enter an input string to be checked for
                    //balanced parentheses
                    inputString = JOptionPane.showInputDialog( "Enter a string");
                    processInputString(inputString);
                    break;

                case 1:
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
                 
    private static void processInputString(String inputString){        
        // Process inputString one character at a time from left to right
        // in this while loop to determine of the string contains balanced
        // parentheses or not (note that a string with no parentheses is
        // considered to be balanced).

        Stack charStack = new Stack();
        boolean doneWithString = false;
        int i = 0;

        while (!doneWithString) {
            // Get the next unprocessed character in the string using 
            // the Java String public method charaAt(i) that will return
            // the character at position i in the string.
            char nextChar = inputString.charAt(i);

            // If nextChar is a left paren, it must be pushed onto the 
            // stack, unless the stack is full, in which the program 
            // ends with an "unbalanced" message.
            // Note the use of apostrophes (' ') to surround a single 
            // character. If ")" were used, Java would treat this as a
            // string consisting of one character, whereas ')' is treated
            // by Java as a single primitive character.
            if (nextChar == '(') {
                if (charStack.isFull()) {
                    break; //break out of the loop
                } 
                else {
                    charStack.push(nextChar);
                }

                // If nextChar is a right paren, the stack must be popped
                // (i.e., a left paren is popped from the stack, unless
                // the stack is empty, in which case the loop is terminated).    
            } 
            else if (nextChar == ')') {
                if (charStack.isEmpty()){
                    break; // break out of the loop
                } 
                else {
                    charStack.pop();
                }
            }
            // No check is needed if the character is not a paren. It
            // is just ignored.

            i++;
            if (i == inputString.length()) {
                doneWithString = true;                       
            }
        } // End of the while loop that processes the input string

        // Determine why the stack was exited and thereby determine whether
        // variable inputString had balanced parens or not.
        if ((charStack.isEmpty()) && (doneWithString)) {
            JOptionPane.showMessageDialog(
                null,
                "The string is balanced!");
            } 
        else {
            JOptionPane.showMessageDialog(
                null,
                "The string is unbalanced!");
        }             
    }
} // end while
