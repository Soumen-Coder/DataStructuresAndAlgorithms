package LinkedList;

import java.util.Stack;

public class PalindromicLinkedListWithStack {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode node = head;
            boolean palin=false;
            Stack<Integer> stack = new Stack<>();

            //inserting into stack
            while(node!=null){
                stack.push(node.val);
                node = node.next;
            }

            //popping from stack
            while(head!=null){
                int i = stack.pop();
                if(head.val == i){
                    palin = true;
                }else{
                    palin = false;
                    break;
                }
                head = head.next;
            }
            return palin;
        }
    }
}
