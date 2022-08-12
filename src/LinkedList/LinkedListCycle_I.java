package LinkedList;

public class LinkedListCycle_I {
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
            if(head!=null){
                newNode.next = head;
            }
            head = newNode;
            size++;
        }

        public void insertLast(int data){
            ListNode newNode = new ListNode(data);
            ListNode temp = head;
            if(head==null){
                insertFirst(data);
            }else{
                while(temp.next!=null){
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next=null;
            }
            size++;
        }

        public void display(ListNode head){
            ListNode temp = head;
            while(temp!=null){
                System.out.print(temp.data+"->");
                temp = temp.next;
            }
            System.out.println("END");
        }
    }

    public static boolean hasCycle(ListNode head){
        if(head == null || head.next==null){
            return false;
        }

        ListNode hare = head;
        ListNode turtle = head;

        while(hare.next!=null && turtle!=null){
            hare = hare.next.next;
            turtle = turtle.next;

            if(hare==null || hare.next==null) {
                return false;
            }
            if(hare==turtle){
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertLast(3);
        ll.insertLast(2);
        ll.insertLast(0);
        ll.insertLast(-4);
        ll.display(ll.head);
        ListNode temp = ll.head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = ll.head.next;
        boolean result = hasCycle(ll.head);
        System.out.println("Has Cycle ? "+result);
    }
}
