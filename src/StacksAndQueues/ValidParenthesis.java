package StacksAndQueues;

import java.util.Stack;

public class ValidParenthesis {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<s.length(); i++)
        {

            if(s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{')
                stack.push(s.charAt(i));
            else
            if(stack.isEmpty())
                return false;

               else
                   if((s.charAt(i) == ')' && stack.peek() =='(') ||
                    (s.charAt(i) == ']' && stack.peek() =='[') ||
                    (s.charAt(i) == '}' && stack.peek() =='{'))
                stack.pop();
            else
                return false;
        }
        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        boolean result = isValid("()");
        System.out.println(result);
    }
}