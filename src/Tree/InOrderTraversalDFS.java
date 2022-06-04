package Tree;

public class InOrderTraversalDFS {
    NodeForInOrder root;

    InOrderTraversalDFS(){
        this.root = null;
    }

    public static void inOrder(NodeForInOrder node){

        if(node == null){
            return;
        }

        inOrder(node.left);

        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    public static void main(String[] args) {
        InOrderTraversalDFS tree = new InOrderTraversalDFS();
        tree.root = new NodeForInOrder(1);
        tree.root.left = new NodeForInOrder(2);
        tree.root.right = new NodeForInOrder(3);
        tree.root.left.left = new NodeForInOrder(4);
        tree.root.left.right = new NodeForInOrder(5);

        System.out.println(
                "\nInorder traversal of binary tree is ");
        tree.printInorder();

    }

    void printInorder(){
        inOrder(root);
    }
}

class NodeForInOrder{
    int data;
    NodeForInOrder left, right;

    NodeForInOrder(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
