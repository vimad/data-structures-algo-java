package list;

public class LinkedList {

    private Node head;
    private int size;

    LinkedList() {
        head = null;
        size = 0;
    }

    private class Node {
        Node next;
        int data;

        Node (int d) {
            data = d;
            next = null;
        }

    }

    public void printList() {
        System.out.println("********************");
        Node node = head;
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println("\n********************");
    }

    public void insert(int data) {
        if (this.head == null) {
            this.head = new Node(data);
        } else {
            Node node = head;
            while (node.next != null) {
                node = node.next;
            }
            node.next = new Node(data);
        }
        size++;
    }

    public void delete(int d) {
        if (head != null) {
            Node currentNode = head;
            Node lastNode = null;
            while (currentNode.next != null && currentNode.data != d) {
                lastNode = currentNode;
                currentNode = currentNode.next;
            }

            if (currentNode == head && currentNode.data == d) {
                head = currentNode.next;
                size--;
                return;
            }

            if (currentNode.next == null && currentNode.data == d) {
                lastNode.next = null;
                size--;
                return;
            }

            if (currentNode.next != null) {
                lastNode.next = currentNode.next;
                size--;
            }
        }
    }

    public int getSize() {
        return size;
    }
}
