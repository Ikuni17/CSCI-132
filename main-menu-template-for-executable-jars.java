package StackLinkedGeneric;

import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

public class Main{
    public static void main(String args[])
    {
       String dogBreed; 
       String dogName; 
       Dog dogReference;
       boolean done = false;
       
       Stack<Dog> dogStack = new Stack();
       
       String[] choices = {"push", "pop", "full?", "empty?", "quit"};
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
            try{
                switch (choice){
                case 0:
                        if (dogStack.isFull()){
                            JOptionPane.showMessageDialog(
                                null,
                                "Cannot push; stack is full!");
                        }
                        else {
                            dogName = JOptionPane.showInputDialog(
                                    "Enter the dog's name");
                            dogBreed = JOptionPane.showInputDialog(
                                    "Enter the dog's breed");
                            dogReference = new Dog(dogName, dogBreed);
                            dogStack.push(dogReference);
                        }
                        break;                   
                case 1:
                        if (dogStack.isEmpty()){
                            JOptionPane.showMessageDialog(
                                null,
                                "Cannot pop; stack is empty!");
                        }
                        else{
                            dogReference = dogStack.pop();
                            JOptionPane.showMessageDialog(
                                null,
                                "The top dog on the stack was "
                                    + dogReference.getName() 
                                    + " of breed "
                                    + dogReference.getBreed() + ".");
                        }
                        break;
                case 2: 
                        if (dogStack.isFull()){
                            JOptionPane.showMessageDialog(
                                null,
                                "The stack is full!");
                        }
                        else {
                            JOptionPane.showMessageDialog(
                                null,
                                "The stack is not full!");
                        }
                        break;
                case 3:
                        if (dogStack.isEmpty()){
                            JOptionPane.showMessageDialog(
                                null,
                                "The stack is empty!");
                        }
                        else {
                            JOptionPane.showMessageDialog(
                                null,
                                "The stack is not empty!");
                        }
                        break;
                    
                case 4: 
                        done = true;
                        break;
                default: 
                        JOptionPane.showMessageDialog(
                                null,
                                "Invalid selection; try again!");
                } //end switch
            } // end try
            catch (NoSuchElementException e){
                JOptionPane.showMessageDialog(
                        null,
                        "The Stack is Empty",
                        "",
                        JOptionPane.ERROR_MESSAGE);
                
            } // end catch
            
       } // end while
    }
}  