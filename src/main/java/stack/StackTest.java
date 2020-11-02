package stack;

public class StackTest {

    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(10);
        arrayStack.push(3);
        arrayStack.push(7);
        arrayStack.push(5);
        arrayStack.push(1);
        arrayStack.printStack();
    }
}
