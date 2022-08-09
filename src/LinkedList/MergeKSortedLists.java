package LinkedList;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedList{
        ListNode head;
        int size;

        LinkedList(){
            this.head = null;
            this.size = 0;
        }

        public void insertFirst(int data){
            ListNode newNode = new ListNode(data);
            if (head != null) {
                newNode.next = head;
            }
            head = newNode;
            size++;
        }

        public void insertLast(int data){
            ListNode newNode = new ListNode(data);
            if(head == null){
                insertFirst(data);
            }else {
                ListNode temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = null;
            }
            size++;
        }

        public void display(ListNode head){
            ListNode temp = head;
            while(temp!=null){
                System.out.print(temp.data + " -> ");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        //If your ListNode class already implements Comparable you don't even need to define a new Comparator, as that order will be used by default.
        PriorityQueue<ListNode> pQueue = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.data));
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                pQueue.add(lists[i]);
            }
        }

        System.out.print("Data in PriorityQueue :- ");
        Iterator<ListNode> itr = pQueue.iterator();
        while(itr.hasNext()){
            System.out.print(itr.next().data+ "   ");
        }
        System.out.println();

        while(!pQueue.isEmpty()){
            ListNode temp = pQueue.poll();
            tail.next = temp;
            tail = temp;

            if(temp.next!=null){
                pQueue.add(temp.next);
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedList ll1 = new LinkedList();
        ll1.insertLast(1);
        ll1.insertLast(4);
        ll1.insertLast(5);
        ll1.display(ll1.head);

        LinkedList ll2 = new LinkedList();
        ll2.insertLast(1);
        ll2.insertLast(3);
        ll2.insertLast(4);
        ll2.display(ll2.head);

        LinkedList ll3 = new LinkedList();
        ll3.insertLast(2);
        ll3.insertLast(6);
        ll3.display(ll3.head);

        ListNode[] listNodes = new ListNode[]{ll1.head, ll2.head, ll3.head};

        ListNode resultNode = new MergeKSortedLists().mergeKLists(listNodes);

        new LinkedList().display(resultNode);

    }
}
