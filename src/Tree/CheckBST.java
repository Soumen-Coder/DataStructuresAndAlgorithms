package Tree;

public class CheckBST {
    static BSTNode root;
    static int MIN = Integer.MIN_VALUE;
    static int MAX = Integer.MAX_VALUE;

    CheckBST(){
        this.root = null;
    }

    public static boolean check(BSTNode node, int minimum, int maximum){
        if(node == null){
            return true;
        }

        if(node.data < minimum && node.data > maximum){
            return false;
        }

        return check(node.left, MIN, Math.min(MAX, node.data))
                && check(node.right, Math.max(MIN, node.data), MAX);
    }

    public static boolean isBST(){
         return check(root, MIN, MAX);
    }

    public static void main(String[] args) {
        CheckBST tree = new CheckBST();
        tree.root = new BSTNode(4);
        tree.root.left = new BSTNode(2);
        tree.root.right = new BSTNode(5);
        tree.root.left.left = new BSTNode(1);
        tree.root.left.right = new BSTNode(7);
        tree.root.right.right = new BSTNode(6);

        System.out.println(
                "\nIs it a binary search tree ?      ");
        System.out.println(tree.isBST());
    }

}

class BSTNode{
    int data;
    BSTNode left;
    BSTNode right;

    BSTNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
