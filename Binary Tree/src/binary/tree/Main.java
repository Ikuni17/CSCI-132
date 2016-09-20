package binary.tree;

import javax.swing.JOptionPane;
import java.util.Random;

/**
 *
 * @author Bradley White
 */
public class Main {

    public static void main(String[] args) {

        int listSize = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of integers to be randomly generated"));
        Integer searchFor = Integer.parseInt(JOptionPane.showInputDialog("Enter an integer to search the tree for"));

        // array to hold the random integers used to build the tree
        Integer[] randomList = new Integer[listSize];

        // seed the random generator
        Random randomIntegerGenerator = new Random(517);

        // populates the array with pseudo random Integers
        for (int i = 0; i < randomList.length; i++) {
            randomList[i] = randomIntegerGenerator.nextInt();
        }

        // creates a new empty tree
        BinarySearchTree BST = new BinarySearchTree();

        // populates the tree with the random integers
        for (Integer randomList1 : randomList) {
            BST.insert(randomList1);
        }

        // searches for the specific integer and outputs the result
        if (BST.search(searchFor) == true) {
            JOptionPane.showMessageDialog(
                    null,
                    "Integer found!");
        } else {
            JOptionPane.showMessageDialog(null,
                    "Integer not found.");
        }
        
        // call traversal methods and outputs the results to a text file
        BST.printRandomList(randomList);
        BST.inOrder();
        BST.preOrder();
        BST.postOrder();
        BST.resultsFile.close();
    }
}
