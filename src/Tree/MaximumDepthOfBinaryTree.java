package Tree;

public class MaximumDepthOfBinaryTree {
    Node root;
    MaximumDepthOfBinaryTree(){
        this.root=null;
    }
    static class Node{
        int val;
        Node left;
        Node right;
        Node() {}
        Node(int val) { this.val = val; }
        Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        MaximumDepthOfBinaryTree tree = new MaximumDepthOfBinaryTree();
        tree.root= new Node(3);
        tree.root.left= new Node(9);
        tree.root.right= new Node(20);
        tree.root.right.left= new Node(15);
        tree.root.right.right= new Node(7);

        int maxDepth = tree.maxDepth(tree.root);
        System.out.println("Maximum Depth :- "+maxDepth);
    }

    public static int maxDepth(Node root){
        if(null==root) return 0;
        int leftSubtreeHeight = maxDepth(root.left);
        int rightSubtreeHeight = maxDepth(root.right);

        return 1+Math.max(leftSubtreeHeight, rightSubtreeHeight);
    }
}
