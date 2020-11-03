package queue;

import java.util.NoSuchElementException;

public class ArrayQueue {
    int[] queue;
    int front;
    int back;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
    }

    public void inset(int d) {
        if (size() == queue.length - 1) {
            int numItems = size();
            int[] newQueue = new int[2 * queue.length];
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);
            queue = newQueue;

            front = 0;
            back = numItems;
        }
        queue[back] = d;
        if (back < queue.length - 1) {
            back++;
        } else {
            back = 0;
        }

    }

    public int remove() {
        if(size() == 0) {
            throw new NoSuchElementException();
        }

        int removeItem = queue[front];
        queue[front] = 0;
        front++;
        if (size() == 0) {
            front = 0;
            back = 0;
        } else if (front == queue.length) {
            front = 0;
        }
        return removeItem;
    }

    public int peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        if (front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
    }

    public void printQueue() {
        System.out.println("*****************************");
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for (int i = front; i < queue.length; i++) {
                System.out.print(queue[i] + " ");
            }
            for (int i = 0; i < back; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println("\n*****************************");
    }


}
