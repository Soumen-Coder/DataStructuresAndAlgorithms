package Tree;

import java.util.*;

public class NodesAtDistanceK {
    private TreeNode root;
    NodesAtDistanceK(){
        this.root = null;
    }
    static Map<TreeNode, TreeNode> parentMap = new HashMap<>();

    public static void main(String[] args) {
        NodesAtDistanceK tree = new NodesAtDistanceK();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(5);
        tree.root.right = new TreeNode(1);
        tree.root.right.left = new TreeNode(0);
        tree.root.right.right = new TreeNode(8);
        tree.root.left.left = new TreeNode(6);
        tree.root.left.right = new TreeNode(2);
        tree.root.left.right.left = new TreeNode(7);
        tree.root.left.right.right = new TreeNode(4);

        List<Integer> answerList = distanceK(tree.root, tree.root.left, 2);
        System.out.println(answerList);
    }

    private static void mark_parent(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node.left!=null){
                parentMap.put(node.left, node);
                queue.offer(node.left);
            }
            if(node.right!=null){
                parentMap.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k){
        List<Integer> answerList = new ArrayList<>();
        if(null == root) return new ArrayList<>();
        mark_parent(root);
        Queue<TreeNode> queue = new LinkedList<>();
        int distance = 0;
        Map<TreeNode, Boolean> visitedMap = new HashMap<>();
        queue.offer(target);
        visitedMap.put(target,true);

        while(!queue.isEmpty()){
            int size = queue.size();
            if(distance == k) break;
            distance++;

            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(null!=node) {
                    if (null != node.left && null == visitedMap.get(node.left)) {
                        queue.offer(node.left);
                        visitedMap.put(node.left, true);
                    }
                    if (null != node.right && null == visitedMap.get(node.right)) {
                        queue.offer(node.right);
                        visitedMap.put(node.right, true);
                    }
                    if (null != parentMap.get(node) && null == visitedMap.get(parentMap.get(node))) {
                        queue.offer(parentMap.get(node));
                        visitedMap.put(parentMap.get(node), true);
                    }
                }
            }
        }

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            answerList.add(node.data);
        }
        return answerList;
    }
}
