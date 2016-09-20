package insertionsortexperiments;

/**
 *
 * @author Bradley White
 */

import java.util.Random;
import javax.swing.JOptionPane;

public class Main {
    
    public static void main(String args[]){

        int listSize = Integer.parseInt(JOptionPane.showInputDialog("Enter the size of list to be sorted: "));
        
        Random randomInteger     = new Random();
        Integer[] randomList     = new Integer[listSize];
        
        for (int j = 0; j < listSize; j++){
            randomList[j] = randomInteger.nextInt();
        }
            
        long startTime = System.currentTimeMillis();
        InsertionSort.insertionSort(randomList);
        long endTime = System.currentTimeMillis();

        JOptionPane.showMessageDialog(
                                null,
                                "The time taken to sort this random array of " + listSize + " elements was " 
                                + (((float)(endTime - startTime))/1000.0) + " seconds.");
        
        int i = 0;
        while (i < listSize-1 && (randomList[i] <= randomList[i+1])){
            i++;
        }
        if (i == listSize-1){
            JOptionPane.showMessageDialog(
                                null, "List was sorted properly");
        }
        else {
            JOptionPane.showMessageDialog(
                                null, "List was not sorted properly: "
                    + "List[" + (i) + "] = " + randomList[i]
                    + " and List[" + (i+1) + "] = " + randomList[i+1] + ".");
        }
    }
}

