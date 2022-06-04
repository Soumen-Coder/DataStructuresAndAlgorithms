package LinkedList;

import java.io.IOException;

public class RemoveNthAndDelete {

    /* Link list node */
    static class Node {
        public int data;
        public Node next;

        public Node(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class LinkedList {
        public Node head;

        public LinkedList() {
            this.head = null;
        }

        public void insertNode(int nodeData) {
            Node node = new Node(nodeData);

            if (this.head != null) {
                node.next = head;
            }
            this.head = node;
        }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        int size=0;
        if(head==null || head.next==null){
            return null;
        }

        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }

        if(n==size){
            return head.next;
        }

        Node curr = head;
        for(int i=0; i<size-n-1; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }

    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("END");
    }

    public static void main(String[] args) throws IOException {
        LinkedList llist = new LinkedList();

        llist.insertNode(1);
        llist.insertNode(2);
        llist.insertNode(3);
        llist.insertNode(4);
        llist.insertNode(5);

        System.out.println("Given linked list:");

        System.out.println();
        System.out.println("Reversed Linked list:");

        System.out.println();
        System.out.println("remove Nth Node from end of a Linked list:");
        Node llist2 = removeNthFromEnd(llist.head, 2);
        display(llist2);

    }
}
