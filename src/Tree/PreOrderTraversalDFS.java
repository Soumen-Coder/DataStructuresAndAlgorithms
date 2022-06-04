package Tree;

public class PreOrderTraversalDFS {

    Node root;

    PreOrderTraversalDFS(){
        this.root = null;
    }

    public static void main(String[] args) {

        PreOrderTraversalDFS tree = new PreOrderTraversalDFS();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println(
                "Preorder traversal of binary tree is ");
        tree.printPreorder();

    }

    public static void preOrder(Node node) {

        if(node == null){
            return;
        }

        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    void printPreorder() {
        preOrder(root);
    }
}

class Node{
    int data;
    Node left;
    Node right;

    Node(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

