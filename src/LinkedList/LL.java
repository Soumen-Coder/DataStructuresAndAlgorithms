package LinkedList;

public class LL {

    public Node head;
    public Node tail;
    public int size;

    public LL(){
        this.size=0;
    }

    public void insertFirst(int value){
        Node node = new Node(value);
        if(head!=null) {
            node.next = head; // because head was null initially so 4 -> NULL makes sense when it is the first to be inserted
        }
        head = node;

        if(tail == null){
            tail = head;
        }

        size+= 1;
    }

    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        if(tail!=null) {
            tail.next = node;
        }
        tail = node;
        size++;
    }

    public void insertAtAnyIndex(int value, int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size){
            insertLast(value);
            return;
        }
        Node temp = head;
        for (int i = 0; i < index-1; i++) {
             temp=temp.next;
        }
        Node node = new Node(value, temp.next);
        temp.next = node;
        size++;
    }

    public void insertRec(int val, int index){
         head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int index, Node node){
        if(index==0){
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }

    public void display(Node head){
        //Always use temp, because head is not supposed to move since it will change the data structure of linked list
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    /*public ListNode removeNthFromEnd(ListNode head, int n) {
        int size=0;
        if(head==null || head.next==null){
            return head;
        }

        ListNode temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }

        if(n==size){
            return head.next;
        }

        ListNode curr = head;
        for(int i=0; i< size-n; i++){
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return head;
    }*/

    public void find(int value){
        Node temp=head;
        while(temp!=null){
            if(temp.value == value){
                System.out.println("Node found");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Node not found");
    }

    public Node getNode(int index){
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp=temp.next;
        }
        return temp;
    }

    public int deleteLast(){
        if(size<=1){
            int value = deleteFirst();
            return value;
        }
        int value=tail.value;
        Node node = getNode(size-2);
        node.next = null;
        tail = node;
        size--;
        return value;
    }

    public int deleteFirst(){
        int value = head.value;
        head = head.next;
        if(head==null){
            tail=null;
        }
        size--;
        return value;
    }

    public int deleteAtAnyIndex(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size){
            return deleteLast();
        }
        Node prev = head;
        for (int i = 0; i < index-1; i++) {
            prev = prev.next;
        }
        int value = prev.next.value;
        prev.next = prev.next.next;
        size--;
        return value;
    }

    public Node reverseIterative(){
        Node prev = head;
        Node current = head.next;
        while(current!=null){
            Node next = current.next;
            current.next = prev;
            //moving ahead, update
            prev = current;
            current = next;
        }
        head.next = null;
        head = prev;
        return head;
    }

    public Node getHead(){
        return head;
    }

    public Node reverseRecursive(Node head){
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = reverseRecursive(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public static class Node{
        public int value;
        public Node next;

        Node(){

        }

        public Node(int value){
            this.value = value;
        }

        public Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }


}
