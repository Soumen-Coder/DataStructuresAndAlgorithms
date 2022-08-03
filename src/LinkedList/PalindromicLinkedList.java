package LinkedList;

public class PalindromicLinkedList {

    static class Node{
        public int data;
        public Node next;

        Node(){}

        public Node(int data){
            this.data = data;
            this.next=null;
        }
    }

    static class LinkedList{
        public Node head;
        public Node tail;
        public int size;

        LinkedList(){}
        LinkedList(Node head){
            this.head = null;
            this.tail=null;
            this.size=0;
        }

        public void insertNode(int data){
            Node node = new Node(data);
            if(this.head!=null){
                node.next = head;
            }
            this.head = node;
            this.size++;
        }
    }

    public static boolean palindromicList(Node head){
        //head == null -> no elements
        //head.next == null -> one element
        if(head==null || head.next==null){
            return true;
        }

        Node firstHead = head;

        //Find middle by hare turtle approach
        Node mid = getMidOfLinkedList(head); // First half ka end

        //Reverse the second LinkedList
        Node secondHead = reverseList(mid.next); // Second half ka start


        //Compare the values firstHead with secondHead and so on until second reaches null, if same return true else false
        while(secondHead!=null){
            if(firstHead.data != secondHead.data){
                return false;
            }
                firstHead = firstHead.next;
                secondHead = secondHead.next;
        }
        return true;
    }

    private static Node reverseList(Node head) {
        Node prev = head;
        Node curr = head.next;

        while(curr!=null){
            Node next = curr.next;
            curr.next = prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }

    //Tortoise jumps once and hare jumps twice hence hare.next and hare.next.next
    //Hare after jumping twice will tell hare that khai aa gayi hai so turtle stops at mid point
    private static Node getMidOfLinkedList(Node head) {
        Node hare = head;
        Node turtle = head;

        while(hare.next!=null && hare.next.next!=null){
            hare = hare.next.next; // hare jumping twice
            turtle = turtle.next; // turtle jumps once
        }
        return turtle;
    }

    public static void display(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertNode(1);
        ll.insertNode(2);
        ll.insertNode(2);
        ll.insertNode(1);
        ll.insertNode(5);

        display(ll.head);

        boolean result = palindromicList(ll.head);
        System.out.println(result);
    }

}
