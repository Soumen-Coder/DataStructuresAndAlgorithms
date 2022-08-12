package LinkedList;

public class RemoveDuplicatesOfSortedLinkedListUsingIteration {
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

    public static ListNode deleteDuplicates(ListNode head){
        ListNode temp = head;
        if(head ==null || head.next==null)return head;
        while(temp.next!=null){
            if(temp.data == temp.next.data){
                temp.next = temp.next.next;
            }else{
                temp = temp.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertLast(1);
        ll.insertLast(1);
        ll.insertLast(2);
        ll.insertLast(2);
        ll.insertLast(5);
        ll.insertLast(5);
        ll.display(ll.head);
        ListNode result = deleteDuplicates(ll.head);
        ll.display(result);
    }
}
