package LinkedList;

// GeeksForGeeks
// Given a singly linked list and a number k, write a function to find the (n/k)-th element,
// where n is the number of elements in the list.
// We need to consider ceil value in case of decimals.

public class NByKthNodeFromStart {

    static class Node{
        int value;
        Node next;

        public Node() {
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    static class LinkedList{
        Node head;
        int size;

        public LinkedList() {
        }

        public LinkedList(Node head) {
            this.head = head;
        }

        public void insertFirst(int value){
            Node newNode = new Node(value);
            if(head!=null){
                newNode.next = head;
            }
            head = newNode;
            size++;
        }

        public void insertLast(int value){
            Node newNode = new Node(value);
            if(head==null){
                insertFirst(value);
            }else {
                Node temp = head;
                while (temp.next != null) {
                    temp = temp.next;
                }
                temp.next = newNode;
                newNode.next = null;
            }
            size++;
        }

        public void display(){
            Node temp = head;
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
        ll.insertLast(6);
        ll.insertLast(7);
        ll.insertLast(8);
        ll.insertLast(9);
        ll.display();
        int resultNode = nByKthNode(ll.head, 5);
        System.out.println(resultNode);
    }

    public static int nByKthNode(Node head, int k){
        if(k<=0){
            return 0;
        }
        if(head == null){
            return 0;
        }

         Node hare=head;
         Node tortoise=null;
         int i=0;
         while(hare!=null){ //hare.next and hare.next.next results in NPE
             if(i%k==0){
                 if(tortoise==null) {
                     tortoise = head;
                 }else {
                     tortoise = tortoise.next;
                 }
             }
             hare=hare.next;
             i++;
         }
         return tortoise.value;
    }
}
