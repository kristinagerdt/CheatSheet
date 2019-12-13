package examples;

import java.util.Arrays;

public class MyStack {
    private int[] stack;
    private int index;
    private int size;

    public MyStack(int size) {
        this.size = size;
        this.index = 0;
        this.stack = new int[size];
    }

    public int getSize() {
        return size;
    }

    public void push(int num) {
        if (index <= size - 1) {
            stack[index] = num;
            index++;
        } else {
            System.out.println("Stack is full!");
        }
    }

    public int pop() {
        int num = 0;
        if (index != 0) {
            num = stack[index - 1];
            stack[index - 1] = 0;
            index--;
        } else {
            System.out.println("Stack is empty");
        }
        return num;
    }

    @Override
    public String toString() {
        return "stack=" + Arrays.toString(stack) +
                ", index=" + index +
                ", size=" + size;
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack(6);

        for (int i = 0, j = 2; i < myStack.getSize(); i++, j++) {
            myStack.push(j);
            System.out.println(myStack.toString());
        }

        System.out.println();

        for (int i = 0; i < myStack.getSize(); i++) {
            int lastNum = myStack.pop();
            System.out.println(myStack.toString() + " last number = " + lastNum);
        }
    }
}
