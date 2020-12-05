package binarytree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    public Node root;

    public void createTree() {
        System.out.println("*********Create Binary tree***********");
        System.out.println("Add positive values if no child add -1. To stop adding values insert -2");

        Queue<Node> queue = new LinkedList<>();

        System.out.println("Add root element");
        int val = readValue();
        if (val != -1) {
            root = new Node(val);
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.println("Add left child for " + currentNode.value);
            int value = readValue();
            if (value == -2) return;
            if (value != -1) {
                Node leftChild = new Node(value);
                currentNode.leftChild = leftChild;
                queue.add(leftChild);
            }
            System.out.println("Add right child " + currentNode.value);
            value = readValue();
            if (value == -2) return;
            if (value != -1) {
                Node rightChild = new Node(value);
                currentNode.rightChild = rightChild;
                queue.add(rightChild);
            }
        }

    }

    private int readValue() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            System.out.println("Error reading");
        }
        return -1;
    }

    //****************TRAVERSAL******************************
    public void preOrderTraversal() {
        System.out.println("**************Preorder recursive");
        preOrder(root);
        System.out.println("\n*****************************");
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    public void inOrderTraversal() {
        System.out.println("**************Inorder recursive");
        inOrder(root);
        System.out.println("\n*****************************");
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.print(node.value + " ");
            inOrder(node.rightChild);
        }
    }

    public void postOrderTraversal() {
        System.out.println("**************Postorder recursive");
        postOrder(root);
        System.out.println("\n*****************************");
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.print(node.value + " ");
        }
    }

    public void preOrderIterative() {
        System.out.println("**********Preorder iterative");
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                System.out.print(currentNode.value + " ");
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            } else {
                currentNode = stack.pop().rightChild;
            }
        }
        System.out.println("\n*****************************");
    }

    public void inOrderIterative() {
        System.out.println("**********Inorder iterative");
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.leftChild;
            } else {
                currentNode = stack.pop();
                System.out.print(currentNode.value + " ");
                currentNode = currentNode.rightChild;
            }
        }
        System.out.println("\n*****************************");
    }

    public void postOrderIterative()
    {
        System.out.println("**********Postorder iterative");
        // Create two stacks
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();

        if (root == null)
            return;

        // push root to first stack
        s1.push(root);

        // Run while first stack is not empty
        while (!s1.isEmpty()) {
            // Pop an item from s1 and push it to s2
            Node temp = s1.pop();
            s2.push(temp);

            // Push left and right children of
            // removed item to s1
            if (temp.leftChild != null)
                s1.push(temp.leftChild);
            if (temp.rightChild != null)
                s1.push(temp.rightChild);
        }

        // Print all elements of second stack
        while (!s2.isEmpty()) {
            Node temp = s2.pop();
            System.out.print(temp.value + " ");
        }
        System.out.println("\n*****************************");
    }

    public void levelOrderTraversal() {
        System.out.println("**********Levelorder traversal");
        Queue<Node> queue = new LinkedList<>();
        System.out.print(root.value + " ");
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode.leftChild != null) {
                System.out.print(currentNode.leftChild.value + " ");
                queue.add(currentNode.leftChild);
            }
            if (currentNode.rightChild != null) {
                System.out.print(currentNode.rightChild.value + " ");
                queue.add(currentNode.rightChild);
            }
        }
        System.out.println("\n*****************************");
    }
    // ***********END OF TRAVERSAL**********************

    //************ count nodes**********************

    public int numberOfNodes() {
        return count(root);
    }

    private int count(Node node) {
        int x = 0,y = 0;
        if (node != null) {
            x = count(node.leftChild);
            y = count(node.rightChild);
            return x + y + 1;
        }
        return 0;
    }

    //***************************************************
}
