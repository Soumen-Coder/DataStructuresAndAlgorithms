package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversalUsingSingleStack {
    private Node root;
    private final List<Integer> arrayList;
    private final Stack<Node> stack;

    PostOrderTraversalUsingSingleStack() {
        this.root = null;
        this.arrayList = new ArrayList<>();
        this.stack = new Stack<>();
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left=null;
            this.right=null;
        }
    }

    public List<Integer> preOrder(Node root){
        if(root==null)return new ArrayList<>();
        Node curr = root;
        Node temp;
        while(curr!=null || !stack.isEmpty()){
            if(curr!=null){ // go left,left,left and extreme left till its null
                stack.push(curr);
                curr = curr.left;
            }else{
                //go right
                temp = stack.peek().right;
                if(temp == null){ // right null ? go root and add to list
                    temp=stack.peek(); //peek
                    stack.pop(); //pop
                    arrayList.add(temp.data); //add

                    while(!stack.isEmpty() && temp==stack.peek().right){ // check if the node is again right
                        temp=stack.peek(); //peek
                        stack.pop();//pop
                        arrayList.add(temp.data);//add
                    }
                }else{
                    //assign curr, so that it again go left
                    curr = temp;
                }
            }
        }
        return arrayList;
    }

    public static void main(String[] args) {
       PostOrderTraversalUsingSingleStack tree = new PostOrderTraversalUsingSingleStack();
       tree.root = new Node(1);
       tree.root.left = null;
       tree.root.right = new Node(2);
       tree.root.right.left=new Node(3);

       List<Integer> result = tree.preOrder(tree.root);
        System.out.println(result);
    }
}
