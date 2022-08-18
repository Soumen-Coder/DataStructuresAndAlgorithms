package LinkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class LRUCache<T> {
    private final int capacity;
    private int size;
    private final Map<Integer,Node> hashMap;
    private final DoublyLinkedList internalQueue;

    static BiConsumer<Integer,Node> biConsumer = (key, node) -> System.out.println("The key is :- "+key+" and the corresponding node is :-"+(node.key+","+node.data));

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        this.hashMap = new HashMap<>();
        this.internalQueue = new DoublyLinkedList();
    }

    static class Node<T>{
        int key;
        T data;
        Node prev;
        Node next;
        Node(final int key, final T data){
            this.key = key;
            this.data = data;
            this.prev=null;
            this.next=null;
        }

        @Override
        public String toString() {
            return " key = "+key+" and data = "+data;
        }
    }

    static class DoublyLinkedList{
        Node front;
        Node rear;
        DoublyLinkedList(){
            this.front=null;
            this.rear=null;
        }

        void moveNodeToFrontOfQueue(Node node){
            //If it is already in front, then return
            if(front==node){
                return;
            }
            //If the node is a rear node
            if(node==rear){
                rear=rear.prev;
                rear.next=null;
            }else{
                //If the node is anywhere in between
                node.prev.next=node.next;
                node.next.prev=node.prev;
            }
            //attaching the node to the front, also this will cover if front==rear, i.e, if there is only one node
            node.prev=null;
            node.next=front;
            front.prev=node;
            front=node;
        }

        int getRearKey(){
            return rear.key;
        }

        void removeNodeFromRearOfQueue(){
            //There are no nodes, then no removal, return
            if(front==null||rear==null){
                return;
            }
            //If there is only one node
            if(front==rear){
                front=rear=null;
            }else {
                rear = rear.prev; //This is to assign rear, don't only assign link by rear.prev.next=null
                rear.next = null;
            }
        }

        void addToFrontOfQueue(Node node){
            Node temp=front; //never modify the front, take a temp
            //If there are no nodes, make front and rear the node passed
            if(front==null||rear==null){
                front=rear=node;
            }
            //If node is already at front, why to disturb it
            if(front==node){
                return;
            }

            //attaching the node to the front of the list
            node.prev=null;
            node.next=temp;
            temp.prev=node;
            front=node;
        }

        public void printList(Node node)
        {
            Node last = null;
            System.out.println("Traversal in forward Direction");
            while (node != null) {
                System.out.print(node.data + "->");
                last = node;
                node = node.next;
            }
            System.out.println();
            System.out.println("Traversal in reverse direction");
            while (last != null) {
                System.out.print(last.data + "<-");
                last = last.prev;
            }
            System.out.println();
        }

    }

    public T get(final int key) {
        Node node = hashMap.get(key);
        if(node==null){
            return null;
        }
        internalQueue.moveNodeToFrontOfQueue(node);
        internalQueue.printList(internalQueue.front);
        System.out.println("Printing HashMap from within Get()");
        hashMap.forEach(biConsumer);
        return (T) node.data;
    }

    public void put(int key, int value) {
        Node node = hashMap.get(key);
        if(node!=null){
            node.data = value;
            internalQueue.moveNodeToFrontOfQueue(node);
            internalQueue.printList(internalQueue.front);
            return;
        }
        if(size==capacity){
            int rearKey = internalQueue.getRearKey();
            internalQueue.removeNodeFromRearOfQueue();
            internalQueue.printList(internalQueue.front);
            hashMap.remove(rearKey);
            size--; // Remove from the list, have to do size--, don't forget
        }
        Node newNode = new Node(key,value);
        internalQueue.addToFrontOfQueue(newNode);
        internalQueue.printList(internalQueue.front);
        hashMap.put(key, newNode);
        size++;//Adding an element to the queue, don't forget to do size++
        System.out.println("Printing HashMap from within Put()");
        hashMap.forEach(biConsumer);
        System.out.println("-------Put() Ends---------");
    }

    public static void main(String[] args) {
        System.out.println("LRU Cache created with capacity = 2");
        LRUCache<Integer> lRUCache = new LRUCache<>(2);
        System.out.println("Inserting 1,1 into Cache");
        lRUCache.put(1, 1); // cache is {1=1}
        System.out.println("Inserting 2,2 into Cache");
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println("Getting the value of Key=1 from Cache:- "+lRUCache.get(1));
        System.out.println();    // return 1
        System.out.println("Inserting 3,3 into Cache");
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println("Getting the value of Key=2 from Cache:- "+lRUCache.get(2));
        lRUCache.get(2);    // returns -1 (not found)
        System.out.println("Inserting 4,4 into Cache");
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println("Getting the value of Key=1 from Cache:- "+lRUCache.get(1));
        lRUCache.get(1);    // return -1 (not found)
        System.out.println("Getting the value of Key=3 from Cache:- "+lRUCache.get(3));
        lRUCache.get(3);    // return 3
        System.out.println("Getting the value of Key=4 from Cache:- "+lRUCache.get(4));
        lRUCache.get(4);    // return 4
    }
}
