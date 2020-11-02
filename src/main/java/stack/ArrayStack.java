package stack;

import java.util.EmptyStackException;

public class ArrayStack {

    private int[] stack;
    int top;

    ArrayStack(int capacity) {
        stack = new int[capacity];
        top = 0;
    }

    public void push(int data) {
        if (top == stack.length) {
            int[] newArray = new int[2 * stack.length];
            System.arraycopy(stack, 0, newArray, 0, stack.length);
            stack = newArray;
        }
        stack[top++] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int data = stack[--top];
        stack[top] = 0;
        return data;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack[top - 1];
    }

    public boolean isEmpty() {
        return top == 0;
    }

    public void printStack() {
        System.out.println("************************");
        for (int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("\n************************");
    }

}
