package list;

public class DoublyLinkedList {
    private Node head;
    private int size;

    DoublyLinkedList() {
        head = null;
        size = 0;
    }

    private class Node {
        Node next;
        Node previous;
        int data;

        Node (int d) {
            data = d;
            next = null;
            previous = null;
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
            Node newNode = new Node(data);
            node.next = newNode;
            newNode.previous = node;
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
                currentNode.previous = null;
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
                currentNode.next.previous = lastNode;
                size--;
            }
        }
    }

    public int getSize() {
        return size;
    }
}
