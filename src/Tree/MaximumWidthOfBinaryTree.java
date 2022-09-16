package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    private TreeNode root;
    MaximumWidthOfBinaryTree(){
        this.root = null;
    }
    static class Pair{
        TreeNode node;
        int index;

        Pair(TreeNode node, int index){
            this.node = node;
            this.index=index;
        }
    }
    public static void main(String[] args) {
       MaximumWidthOfBinaryTree tree = new MaximumWidthOfBinaryTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(5);
        tree.root.left.right = new TreeNode(3);
        tree.root.right.right = new TreeNode(9);

        int maxWidth = maxWidth(tree.root);
        System.out.println(maxWidth);
    }

    public static int maxWidth(TreeNode root){
        if(null==root){
            return 0;
        }

        Queue<Pair> queue = new LinkedList<>();
        int width = 1;
        queue.offer(new Pair(root, 0));

        while(!queue.isEmpty()){
            int first = 0, last = 0;
            int minIndex = queue.peek().index;

            for (int i = 0; i < queue.size(); i++) {
                Pair pair = queue.poll();
                TreeNode node = pair.node;
                int index = pair.index;
                index = index - minIndex;

                if(i==0) first = index;
                if(i==queue.size()-1) last = index;

                if(null!=node.left) {
                    queue.add(new Pair(node.left, 2 * index + 1));
                }
                if(null!=node.right) {
                    queue.add(new Pair(node.right, 2 * index + 2));
                }
            }
            width = Math.max(width, last-first+1);
        }
        return width;
    }
}
