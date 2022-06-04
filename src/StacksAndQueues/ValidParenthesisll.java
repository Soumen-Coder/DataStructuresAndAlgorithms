package StacksAndQueues;

import java.util.Stack;

public class ValidParenthesisll {
    public static boolean checkValidString(String s) {
        Stack<Integer> stackParenthesis = new Stack<>();
        Stack<Integer> stackStars = new Stack<>();

        //traversing string and finishing with closing barckets
        for(int i=0; i< s.length(); ++i){
            if(s.charAt(i)=='('){
                stackParenthesis.push(i);
            }
            else if(s.charAt(i)=='*'){
                stackStars.push(i);
            }
            else {
                if(!stackParenthesis.isEmpty()) {
                    stackParenthesis.pop();
                }
                else if(!stackStars.isEmpty()){
                    stackStars.pop();
                    }
                else
                    return false;
                }
        }

        // Left over opening brackets balancing with *
        while(!stackParenthesis.isEmpty()){
            if(stackStars.isEmpty())
                return false;
            //This is possible because the * and ( indices are arranged in ascending order
            else if(stackParenthesis.peek() < stackStars.peek()){ // (*   0<1
                stackParenthesis.pop();
                stackStars.pop();
            }
            else                               // *( where position of * is 0 and position of ( is 1 , and 0<1
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean result = checkValidString("()"); //True
        boolean result1 = checkValidString("(*)"); //True
        boolean result2 = checkValidString("(*))"); //True
        boolean result3 = checkValidString("((*)"); //True
        boolean result4 = checkValidString(")*()"); //False
        boolean result5 = checkValidString("*())"); //True
        boolean result6 = checkValidString("**())"); //True
        boolean result7 = checkValidString("*(()*))"); //True
        boolean result8 = checkValidString("(*(**)"); //True
        boolean result9 = checkValidString("***(()"); //False
        System.out.println(result);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(result5);
        System.out.println(result6);
        System.out.println(result7);
        System.out.println(result8);
        System.out.println(result9);
    }
}
