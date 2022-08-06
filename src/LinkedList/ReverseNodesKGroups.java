package LinkedList;

public class ReverseNodesKGroups {
    static class ListNode{
        int value;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }
    }

    static class LinkedList{
        ListNode head;
        int size;

        public LinkedList() {
        }

        public LinkedList(ListNode head) {
            this.head = head;
        }

        public void insertFirst(int value){
            ListNode newNode = new ListNode(value);
            if(head!=null){
                newNode.next = head;
            }
            head = newNode;
            size++;
        }

        public void insertLast(int value){
            ListNode newNode = new ListNode(value);
            if(head==null){
                insertFirst(value);
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

        public void display(){
            ListNode temp = head;
            while(temp!=null){
                System.out.print(temp.value + " -> ");
                temp = temp.next;
            }
            System.out.print("END");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(3);
        ll.insertLast(4);
        ll.insertLast(5);
        ll.display();
        ll.head = reverseKGroup(ll.head, 2);
        ll.display();
    }
    public static void reverseStartAndEnd(ListNode start, ListNode end){
        ListNode prev = null, curr = start, next = start.next;
        while(prev!=end){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next!=null){
                next = next.next;
            }
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        //BASE CONDITION
        if(head==null||head.next==null||k==1){
            System.out.println("Head has become null or it's a single node left! Base condition hit");
            return head;
        }

        //FIND START AND END AND RETURN THE HEAD
        //THIS PART OF OPERATION HAPPENS INSIDE RECURSION TO GET K GROUPS INSIDE RECURSION PART OF THE LIST
        ListNode start = head;
        ListNode end = head;
        int increment = k-1;
        while(--increment>=0){
            end = end.next;
            if(end==null){
                return head;
            }
        }
        System.out.println("Start till now :- " +start.value+ " End till now :- "+end.value);

        //RECURSION from next node after your job of finding start and end nodes
        System.out.println("Calling recursion with parameters :- reverseKGroup(" +end.next.value+","+ k+")");
        ListNode newHead = reverseKGroup(end.next, k);
        System.out.println("New Head receive after recursion call :- "+newHead.value);

        System.out.println("Reversing "+start.value+" and "+ end.value);
        //REVERSE your part of k group
        reverseStartAndEnd(start, end);

        //AFTER you reversed, end becomes the head and start becomes the end, Link it to RECURSION'S head
        System.out.println("Setting "+start.value+".next = "+newHead.value);
        start.next = newHead;
        System.out.println("Returning head :- "+end.value);
        return end;
    }
}
