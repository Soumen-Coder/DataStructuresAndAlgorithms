package LinkedList;

public class ReverseNodesKGroupsConstantSpace {
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
        if (head == null || head.next == null || k == 1) {
            System.out.println("Head has become null or it's a single node left! Base condition hit");
            return head;
        }

        //FIND BEFORESTART, START AND END Nodes
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode end = head;
        ListNode beforeStart = dummy;
        int incTracker = 0;

        while (end != null) {
            incTracker++;
            if (incTracker % k == 0) {
                ListNode start = beforeStart.next;
                ListNode temp = end.next;
                //Reverse start and end
                reverseStartAndEnd(start, end);
                //Links after reversing
                beforeStart.next = end;
                start.next = temp;
                beforeStart=start;
                end=temp;

            } else {
                end = end.next;
            }
        }
        return dummy.next;
    }
}
