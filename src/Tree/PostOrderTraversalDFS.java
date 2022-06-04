package Tree;

public class PostOrderTraversalDFS {

    NodeForPostOrder root;

    PostOrderTraversalDFS(){
        this.root = null;
    }

    public static void main(String[] args) {
        PostOrderTraversalDFS tree = new PostOrderTraversalDFS();
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
        postOrder(root);
    }

    public static void postOrder(NodeForPostOrder node) {
        if(node == null){
            return;
        }

        postOrder(node.left);

        postOrder(node.right);

        System.out.print(node.data + " ");
    }
}

class NodeForPostOrder{
    int data;
    NodeForPostOrder left, right;

    NodeForPostOrder(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
