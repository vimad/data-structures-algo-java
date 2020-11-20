package list;

public class ListTest {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(2);
        list.insert(5);
        list.insert(1);
        list.insert(4);
        list.insert(6);
        list.insert(8);

        list.printList();
        list.delete(4);
        list.printList();
        System.out.println(list.getSize());
        list.reverse();
        list.printList();
        list.reverseRecursive();
        list.printList();
    }
}
