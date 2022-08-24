package Tree;

//Use the max Height concept for calculating the Balanced Binary Tree
//Remember that it is asking for balanced binary tree
public class CheckForBalancedBinaryTree {
    Node root;
    CheckForBalancedBinaryTree(){
        this.root = null;
    }
    static class Node{
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
       CheckForBalancedBinaryTree tree = new CheckForBalancedBinaryTree();
        tree.root= new Node(3);
        tree.root.left= new Node(9);
        tree.root.right= new Node(20);
        tree.root.right.left= new Node(15);
        tree.root.right.right= new Node(7);

        boolean result = isBalanced(tree.root);
        System.out.println("Is the tree balanced ? "+result);
    }

    public static boolean isBalanced(Node root){
        if(findHeight(root)!=-1)return true;
        else return false;
    }

    public static int findHeight(Node root){
        if(null == root) return 0;

        int leftSubtree = findHeight(root.left);
        if(leftSubtree==-1) return -1;

        int rightSubtree = findHeight(root.right);
        if(rightSubtree==-1) return -1;

        if(Math.abs(leftSubtree - rightSubtree)>1) return -1;

        return 1+Math.max(leftSubtree, rightSubtree);
    }
}
