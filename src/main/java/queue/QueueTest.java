package queue;

public class QueueTest {

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(2);
        arrayQueue.inset(3);
        arrayQueue.inset(4);
        arrayQueue.remove();
        arrayQueue.inset(7);
        arrayQueue.remove();
        arrayQueue.inset(1);
        arrayQueue.remove();
        arrayQueue.inset(8);

        arrayQueue.printQueue();
    }
}
