package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//All the tree traversals in one
public class PreOrderInOrderPostOrderMorris {
    Node root;
    private final Stack<Pair> stack;
    private final List<Integer> preOrder;
    private final List<Integer> inOrder;
    private final List<Integer> postOrder;


    PreOrderInOrderPostOrderMorris(){
        this.root = null;
        this.stack = new Stack<>();
        this.preOrder = new ArrayList<>();
        this.inOrder = new ArrayList<>();
        this.postOrder = new ArrayList<>();
    }

    //Pair contains a node and a number
    static class Pair{
        Node node;
        int num; // used for inserting the node to the required list, just a tracker
        Pair(){
            this.node = null;
            this.num=0;
        }
        Pair(Node node, int num){
            this.node = node;
            this.num=num;
        }
    }

    static class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public void treeTraversals(Node root){
        if(null==root)return;

        //push the pair in the stack
        stack.push(new Pair(root, 1));

        while(!stack.isEmpty()){
            //pop the pair
            Pair pair = stack.pop();

            //check whether the number in the pair is 1 or not
            if(pair.num==1){
                //add the node's value to the preOrder list
                preOrder.add(pair.node.value);
                //increase the num of the pair by 1
                pair.num++;
                //override the previous sum by pushing the updated pair to the stack
                stack.push(pair);
                if(null!=pair.node.left) stack.push(new Pair(pair.node.left, 1)); //if the pair has a left node, then push a new pair with num 1 to the stack
            }else if(pair.num==2){
                //add the node's value to the InOrder list
                inOrder.add(pair.node.value);
                //increase the num of the pair by 1
                pair.num++;
                //override the previous sum by pushing the updated pair to the stack
                stack.push(pair);
                if(null!=pair.node.right) stack.push(new Pair(pair.node.right, 1)); //if the pair has a right node, then push a new pair with num 1 to the stack
            }else{
                //add the node's value to the postOrder list
                postOrder.add(pair.node.value);
            }
        }
    }

    public void display(){
        System.out.println("The PreOrder traversal :- ");
        System.out.println(preOrder);
        System.out.println();
        System.out.println("The InOrder traversal :- ");
        System.out.println(inOrder);
        System.out.println();
        System.out.println("The PostOrder traversal :- ");
        System.out.println(postOrder);
    }

    public static void main(String[] args) {
        PreOrderInOrderPostOrderMorris tree = new PreOrderInOrderPostOrderMorris();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.treeTraversals(tree.root);
        tree.display();
    }
}
