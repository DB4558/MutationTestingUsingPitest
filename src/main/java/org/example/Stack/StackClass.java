package org.example.Stack;

public class StackClass {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public StackClass(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    // Method to push an element onto the stack
    public void push(int value) {
        if (top == maxSize - 1) {

            return;
        }
        stackArray[++top] = value;

    }

    // Method to pop an element from the stack
    public int pop() {
        if (top == -1) {

            return -1;
        }
        int poppedElement = stackArray[top--];

        return poppedElement;
    }

    // Method to peek the top element of the stack
    public int top() {
        if (top == -1) {

            return -1;
        }
        return stackArray[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }


}