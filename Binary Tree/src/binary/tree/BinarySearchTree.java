package binary.tree;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bradley White
 */
public class BinarySearchTree {

// nested Node class
    protected static class Node {

        private final Integer keyValue;
        private Node left, right;

        public Node(Integer key) {
            keyValue = key;
            left = null;
            right = null;
        }
    }

// BinarySearchTree instance variables
    protected Node root = null;
    PrintWriter resultsFile;

// constructor
    public BinarySearchTree() {
        try {
            this.resultsFile = new PrintWriter(new FileWriter("Files/BST.txt"));
        } catch (IOException ex) {
            Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

// recursive insertion
    public void insert(Integer key) {
        root = insert(root, key);
    }

// recur down and insert the Integer into the proper position within the tree. Returns the new node pointer.
    private Node insert(Node newNode, Integer key) {
        if (newNode == null) {
            newNode = new Node(key);
        } else {
            if (key <= newNode.keyValue) {
                newNode.left = insert(newNode.left, key);
            } else {
                newNode.right = insert(newNode.right, key);
            }
        }
        return (newNode);
    }

// return true if found the integer is found in the tree   
    public boolean search(Integer key) {
        return (search(root, key));
    }

// recur down and search for the given integer
    private boolean search(Node node, Integer key) {
        if (node == null) {
            return (false);
        }
        if (Objects.equals(key, node.keyValue)) {
            return (true);
        } else if (key < node.keyValue) {
            return (search(node.left, key));
        } else {
            return (search(node.right, key));
        }
    }

// traverses the tree in order and prints the nodes in the order visited to a file 
    public void inOrder() {
        resultsFile.print("In Order");
        inOrder(root);
        resultsFile.println();
    }

// recursively traverse the tree in order    
    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.left);
            resultsFile.print(", " + node.keyValue);
            inOrder(node.right);
        }
    }

// traverses the tree in pre-order and prints the nodes in the order visited to a file   
    public void preOrder() {
        resultsFile.print("Pre-Order");
        preOrder(root);
        resultsFile.println();
    }

// recursively traverse the tree in pre-order    
    private void preOrder(Node node) {
        if (node != null) {
            resultsFile.print(", " + node.keyValue);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

// traverses the tree in post-order and prints the nodes in the order visited to a file    
    public void postOrder() {
        resultsFile.print("Post-Order");
        postOrder(root);
        resultsFile.println();
    }

// recursively travers the tree in post-order    
    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            resultsFile.print(", " + node.keyValue);
        }
    }

// prints the list of integers used to build the tree     
    public void printRandomList(Integer[] list) {
        resultsFile.print("Integers");
        for (Integer list1 : list) {
            resultsFile.print(", " + list1);
        }
        resultsFile.println();
    }
}
