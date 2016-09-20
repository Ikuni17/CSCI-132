package balancedparenslinkedlist;

import java.util.Scanner;

/**
 *
 * @author Bradley White
 */
public class Main {

    public static void main(String[] args) {
        String inputCheck;
        LinkedListStack charStack = new LinkedListStack();
        Scanner keyboard = new Scanner(System.in);
        boolean flag = false;

        System.out.print("Enter a string to check for balanced parentheses: ");
        inputCheck = keyboard.nextLine();
        System.out.println();

        for (int i = 0; i < inputCheck.length(); i++) {
            char checkParen = inputCheck.charAt(i);
            if (checkParen == '(') {
                charStack.push(checkParen);
            } else if (checkParen == ')') {
                if (charStack.isEmpty()) {
                    System.out.println("Can't pop, stack is empty.");
                    flag = true;
                } else {
                    charStack.pop();
                }

            }

        }

        if (charStack.isEmpty()
                && flag == false) {
            System.out.println("Parentheses are balanced");
        } else {
            System.out.println("Parentheses are unbalanced.");
        }
    }

}
