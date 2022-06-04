package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePostOrderUsing2stacks {
    NodeForPostOrder root;

    IterativePostOrderUsing2stacks(){
        this.root = null;
    }

    public static void main(String[] args) {
        IterativePostOrderUsing2stacks tree = new IterativePostOrderUsing2stacks();
        tree.root = new NodeForPostOrder(1);
        tree.root.left = new NodeForPostOrder(2);
        tree.root.right = new NodeForPostOrder(3);
        tree.root.left.left = new NodeForPostOrder(4);
        tree.root.left.right = new NodeForPostOrder(5);

        System.out.println(
                "\nPostorder traversal of binary tree is ");
        tree.printPostorder();
    }

    void printPostorder(){
        List<Integer> postOrderList = postOrder(root);
        System.out.println(postOrderList);
    }

    public static List<Integer> postOrder(NodeForPostOrder root) {
        Stack<NodeForPostOrder> stackOne = new Stack<>();
        Stack<NodeForPostOrder> stackTwo = new Stack<>();
        List<Integer> ansList = new ArrayList<>();

        if(root == null){
            return ansList;
        }

        stackOne.push(root);
        while(!stackOne.isEmpty()){
            root = stackOne.pop();
            stackTwo.push(root);
            if(root.left!=null)
                stackOne.push(root.left);
            if(root.right!=null)
                stackOne.push(root.right);
        }

        while(!stackTwo.isEmpty()){
            ansList.add(stackTwo.pop().data);
        }

        return ansList;
    }

}
