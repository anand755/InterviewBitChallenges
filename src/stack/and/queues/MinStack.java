package stack.and.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();

    Stack<Integer> minStack = new Stack<>();


    public static void main(String[] args) {

    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || (x <= stack.peek())) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            int num = stack.pop();
            if (num == minStack.peek()) {
                minStack.pop();
            }
        }
    }

    public int top() {
        if (!stack.isEmpty())
            return stack.peek();
        else
            return -1;
    }

    public int getMin() {
        if (!minStack.isEmpty()) {
            return minStack.peek();
        } else {
            return -1;
        }
    }

}
