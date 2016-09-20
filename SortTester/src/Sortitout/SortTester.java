package sortitout;

import javax.swing.JOptionPane;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

// Method main in this class provides a template for testing sorting (and other) 
// algorithms for their running times. The computed running times are printed as a 
// a comma separated value text file that can be opened in a spreadsheet program
// in which one can automatically generate graphs
public class SortTester {
    
    public static void main(String args[]){
        
    int numberOfSizes  = Integer.parseInt(JOptionPane.showInputDialog
                         ("Enter the number of input sizes to be tested"));
    int startingSize  = Integer.parseInt(JOptionPane.showInputDialog
                         ("Enter the starting input size"));
    int sizeIncrement = Integer.parseInt(JOptionPane.showInputDialog
                         ("Enter the input size increment"));
    int runsPerSize   = Integer.parseInt(JOptionPane.showInputDialog
                         ("Enter the runs per list size"));
    int seed    = Integer.parseInt(JOptionPane.showInputDialog
                        ("Enter a random number generator seed")); 
    
    int listSize = (numberOfSizes * sizeIncrement);
    Integer [] randomList = new Integer [listSize];
    Random randomIntegerGenerator;
    long startTime, endTime;
    long [] timingsPerSizeQuicksort = new long [numberOfSizes];
    long [] timingsPerSizeSelectionSort = new long [numberOfSizes];

    try{
        // Open the file sortTestResults.csv in folder Files, which you
        // must create in in the top level of this project directory
        PrintWriter resultsFile = 
            new PrintWriter(new FileWriter("Files/sortTestResults.csv"));

        // initialize the timing results array for each sorting routine 
        // for each size to 0

        for (int size = 0; size < numberOfSizes; size++){
            timingsPerSizeQuicksort[size] = 0;
            timingsPerSizeSelectionSort[size] = 0;
        }

        // At each size, run each sorting routine runsPerSizeTime times
        randomIntegerGenerator = new Random(seed);
        for (int run=1; run <= runsPerSize; run++){
            // get a new seed from the random number generator to generate the
            // random lists for this run on this size of list
            seed = randomIntegerGenerator.nextInt();

            int currentListLength = sizeIncrement;
            int sizeNumber = 0;  
            
            // run each sorting routine on the same random array of each size 
            // for all sizes, starting with sizeIncrement and increasing by 
            // sizeIncrement on each pass through the loop
            while (currentListLength <= listSize){
               
                // create a randomly generated list of the current size                
                randomIntegerGenerator = new Random(seed);
                for (int i = 0; i < currentListLength; i++){
                    randomList[i] = randomIntegerGenerator.nextInt();
                }                
                // run quicksort on oon this random list, recording its time
                startTime = System.nanoTime();
                QuickSort.quickSort(randomList, 0, currentListLength-1);
                endTime = System.nanoTime();
                timingsPerSizeQuicksort[sizeNumber] = 
                    timingsPerSizeQuicksort[sizeNumber] + endTime - startTime;
                
                // check Quicksort for accuracy
//                System.out.println("Quicksort");
//                int i=0;    
//                while (i < currentListLength-1 && (randomList[i] <= randomList[i+1])){
//                    i++;
//                }
//                if (i == currentListLength-1){
//                    System.out.println("List was sorted properly");
//                }
//                else {
//                    System.out.println("List was not sorted properly: "
//                            + "List[" + (i) + "] = " + randomList[i]
//                            + " and List[" + (i+1) + "] = " + randomList[i+1] + ".");
//                }

                // create the same randomly generated list of the current size
                // by using the same seed as above.
                randomIntegerGenerator = new Random(seed);
                for (int k = 0; k < currentListLength; k++){
                    randomList[k] = randomIntegerGenerator.nextInt();
                }                
                // run SelectionSort on this same array, recording its time
                startTime = System.nanoTime();
                QuickInsertSort.quickSort(randomList, 0, currentListLength-1);
                endTime = System.nanoTime();
                timingsPerSizeSelectionSort[sizeNumber] = 
                    timingsPerSizeSelectionSort[sizeNumber] + endTime - startTime;
 
//                // Check Selection Sort for accuracy
//                System.out.println("Selection Sort");
//                i=0;    
//                while (i < currentListLength-1 && (randomList[i] <= randomList[i+1])){
//                    i++;
//                }
//                if (i == currentListLength-1){
//                    System.out.println("List was sorted properly");
//                }
//                else {
//                    System.out.println("List was not sorted properly: "
//                            + "List[" + (i) + "] = " + randomList[i]
//                            + " and List[" + (i+1) + "] = " + randomList[i+1] + ".");
//                }

                // increment the size number and the actual size of currentLength
                sizeNumber++;
                currentListLength = currentListLength + sizeIncrement;
            }

        }
        
        
        // The sums of the timings for each run per size for each sort for each
        // problem size are the respective timingsPerSize arrays, so average these
        // times and print them to the csv file, one line per sort, labeled with
        // the name of the sort type as the first element.
        resultsFile.print("Quicksort");
        for (int i = 0; i < numberOfSizes; i ++){
            resultsFile.print(", " + (float)timingsPerSizeQuicksort[i]/(float)runsPerSize/1000000.0);
        }
        resultsFile.println();
        
        resultsFile.print("QuickInsertSort");
        for (int i = 0; i < numberOfSizes; i ++){
            resultsFile.print(", " + (float)timingsPerSizeSelectionSort[i]/(float)runsPerSize/1000000.0);
        }
        resultsFile.println();
        resultsFile.close();
        }
        catch (IOException ex) {
            ex.printStackTrace(System.err);
            System.exit(1);
        }
    
    }
}