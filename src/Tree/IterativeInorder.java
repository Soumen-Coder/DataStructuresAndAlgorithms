package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeInorder {
    InorderNode root;

    IterativeInorder(){
        this.root = null;
    }

    public static void main(String[] args) {
        IterativeInorder tree = new IterativeInorder();
        tree.root = new InorderNode(1);
        tree.root.left = new InorderNode(2);
        tree.root.right = new InorderNode(3);
        tree.root.left.left = new InorderNode(4);
        tree.root.left.right = new InorderNode(5);

        System.out.println(
                "\nInorder traversal of binary tree is ");
        tree.printInOrder();
    }

    public static List<Integer> inOrder(InorderNode root) {
        List<Integer> ansList = new ArrayList<>();
        Stack<InorderNode> stack = new Stack<>();

        InorderNode node = root;

        while(true){
            if(node != null){
                //push and left
                stack.push(node);
                node = node.left;
            }else {
                if (stack.isEmpty()) {
                    break;
                }
                //pop and right
                node = stack.pop();
                ansList.add(node.data);
                node = node.right;
            }
        }
        return ansList;
    }

    void printInOrder(){
        List<Integer> result = inOrder(root);
        System.out.println(result);
    }
}

class InorderNode{
    int data;
    InorderNode left, right;

    InorderNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}