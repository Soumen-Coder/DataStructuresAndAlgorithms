package LinkedList;

//Given the head of a singly linked list, return the middle node of the linked list.
//If there are two middle nodes, return the second middle node.
//You can solve it using the hare and turtle approach, but am solving the brute force way
public class MiddleOfLinkedList {
    static class Node{
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }

    static class LinkedList{
        Node head;
        int size;

        public LinkedList() {
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
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(1);
        ll.insertLast(9);
        ll.insertLast(21);
        ll.display();
        Node resultNode = middleNode(ll.head);
        System.out.println(resultNode.value);
    }

    public static Node middleNode(Node head) {
        int size=0;
        if(head==null){
            return null;
        }
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        int middle = size/2;

        temp = head;
        while(--middle>=0){
            temp = temp.next;
        }
        return temp;
    }
}
