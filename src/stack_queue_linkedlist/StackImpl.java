package stack_queue_linkedlist;

import java.util.Arrays;

class Stack {
    private int[] stack;
    private int top;
    private int maxSize;

    public Stack(int size) {
        maxSize = size;
        stack = new int[size];
        top  = -1; // top이 비어있다.
    }

    public void push(int value) {
        stack[++top] = value;
    }

    public int pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            return -1;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return top+1;
    }


}

public class StackImpl {
    public static void main(String[] args) {
        Stack stack = new Stack(5); // 크기 5의 스택 생성

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Peek: " + stack.peek()); // 30
        System.out.println("Pop: " + stack.pop()); // 30
        System.out.println("Peek: " + stack.peek()); // 20

        System.out.println(stack.pop()); // 20
        System.out.println(stack.pop()); // 10
        System.out.println(stack.pop()); // -1 -> stack is empty
    }
}
