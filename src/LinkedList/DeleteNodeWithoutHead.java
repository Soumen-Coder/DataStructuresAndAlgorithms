package LinkedList;

//Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.
//It is guaranteed that the node to be deleted is not a tail node in the list.
public class DeleteNodeWithoutHead {
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

        public Node getNode(int value) {
            Node temp = head;
            while(temp.value!=value){
                temp = temp.next;
            }
            return temp;
        }
    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insertLast(4);
        ll.insertLast(5);
        ll.insertLast(1);
        ll.insertLast(9);
        ll.display();
        Node node = ll.getNode(5);
        System.out.println("You have to delete node :- "+node.value);
        deleteNode(node, ll);
    }

    // You don't have to even swap the nodes, just set the next data as the node's data and point it to the next.next's node
    public static void deleteNode(Node node, LinkedList ll) {
        if(node == null){
            return;
        }else{
            if(node.next == null){
                return;
            }
        }
        node.value = node.next.value;
        ll.display();
        node.next = node.next.next;
        ll.display();
    }

}
