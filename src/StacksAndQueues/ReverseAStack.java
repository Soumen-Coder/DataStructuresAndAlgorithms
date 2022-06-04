package StacksAndQueues;

import java.util.Stack;

public class ReverseAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        //stack is now [1, 2, 3]
        /*printStack(stack);
        System.out.println();
        System.out.println("After Reversing");
        System.out.println();*/
        reverse(stack);
        printStack(stack);

        //output should be : [3, 2, 1]
    }

    private static void printStack(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
    }

    private static void reverse(Stack<Integer> stack) {
        if(stack.isEmpty()){
            return;
        }

        int element = stack.pop();
        reverse(stack);
        pushAtBottom(element, stack);
    }

    private static void pushAtBottom(int data, Stack<Integer> stack) {
        if(stack.isEmpty()){
            stack.push(data);
            return;
        }
        int element = stack.pop();
        pushAtBottom(data, stack);
        stack.push(element);
    }
}
