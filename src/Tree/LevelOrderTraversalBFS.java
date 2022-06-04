package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//TC= O(N) and SC=O(N), we don't take into account the answer list or the wrapList in SC
public class LevelOrderTraversalBFS {
    TreeNode root;

    LevelOrderTraversalBFS(){
        this.root=null;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        //checks if there is no node
        if(root == null){
            return wrapList;
        }

        //if there is node, add the root to the queue
        queue.offer(root); // to add to the queue

        //checks if the root have left and right subtree, if yes, takes them into consideration
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>();
            for (int i = 0; i < levelNum; i++) {
                if(queue.peek().left != null){  // node.left
                    queue.offer(queue.peek().left); //add the left node
                }
                if(queue.peek().right != null){   //node.right
                    queue.offer(queue.peek().right); // add the right node
                }

                subList.add(queue.poll().data); // adding the subLevel nodes, add and pop the head from queue
            }
            wrapList.add(subList); // append on the entire list<list<Integer>
        }
      return wrapList;
    }

    public static void main(String[] args) {
        LevelOrderTraversalBFS tree = new LevelOrderTraversalBFS();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        System.out.println(
                "\nLevelOrder traversal of binary tree using BFS is ");
        tree.printLevelOrderBFS();


    }

    void printLevelOrderBFS(){
        List<List<Integer>> result = levelOrder(root);
        System.out.println(result);
    }

}

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
