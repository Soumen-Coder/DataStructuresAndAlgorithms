package LinkedList;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LL linkedList = new LL();
        linkedList.insertFirst(3);
        linkedList.insertFirst(4);
        linkedList.insertFirst(9);
        linkedList.insertFirst(17);
        linkedList.insertLast(35);
        linkedList.insertAtAnyIndex(40, 3);

        linkedList.display(linkedList.head);
        /*int valueDeletedFromFirst = linkedList.deleteFirst();
        System.out.println(valueDeletedFromFirst);
        linkedList.display();
        int valueDeletedFromLast = linkedList.deleteLast();
        System.out.println(valueDeletedFromLast);
        linkedList.display();
        int valueDeletedAtAnyIndex= linkedList.deleteAtAnyIndex(3);
        System.out.println(valueDeletedAtAnyIndex);
        linkedList.display();
        linkedList.find(4);

        linkedList.insertRec(88, 2);*/
        //linkedList.reverseIterative();
        //linkedList.display();
        LL.Node newHead = linkedList.reverseRecursive(linkedList.head);
        linkedList.display(newHead);

        //linkedList.printSinglyLinkedList(linkedList.head, "->");

    }


}
