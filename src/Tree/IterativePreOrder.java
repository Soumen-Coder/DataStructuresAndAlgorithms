package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreOrder {

    IterativeNode root;

    IterativePreOrder(){
        this.root = null;
    }

    public static void main(String[] args) {
        IterativePreOrder tree = new IterativePreOrder();
        tree.root = new IterativeNode(1);
        tree.root.left = new IterativeNode(2);
        tree.root.right = new IterativeNode(3);
        tree.root.left.left = new IterativeNode(4);
        tree.root.left.right = new IterativeNode(5);

        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.printPreOrder();
    }

    public static List<Integer> preOrder(IterativeNode root){
        List<Integer> ansList = new ArrayList<>();
        Stack<IterativeNode> stack = new Stack<>();
        if(root == null){
            return new ArrayList<>();
        }
        stack.push(root);

        while(!stack.isEmpty()){
            root = stack.pop();
            ansList.add(root.data);

            if(root.right!= null){
                stack.push(root.right);
            }
            if(root.left!= null){
                stack.push(root.left);
            }
        }
        return ansList;
    }

    void printPreOrder(){
       List<Integer> result = preOrder(root);
        System.out.println(result);
    }
}

class IterativeNode{
    int data;
    IterativeNode left, right;

    IterativeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
