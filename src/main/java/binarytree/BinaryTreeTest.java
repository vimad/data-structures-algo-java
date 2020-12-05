package binarytree;


public class BinaryTreeTest {

    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
//        binaryTree.createTree();

        /* Example Tree
              1
            2   3
           4 5 6 7
         */
        binaryTree.root = new Node(1);
        binaryTree.root.leftChild = new Node(2);
        binaryTree.root.rightChild = new Node(3);
        binaryTree.root.leftChild.leftChild = new Node(4);
        binaryTree.root.leftChild.rightChild = new Node(5);
        binaryTree.root.rightChild.leftChild = new Node(6);
        binaryTree.root.rightChild.rightChild = new Node(7);

        binaryTree.preOrderTraversal();
        binaryTree.preOrderIterative();
        binaryTree.inOrderTraversal();
        binaryTree.inOrderIterative();
        binaryTree.postOrderTraversal();
        binaryTree.postOrderIterative();
        binaryTree.levelOrderTraversal();
        System.out.println("Number of nodes = " + binaryTree.numberOfNodes());
    }
}
