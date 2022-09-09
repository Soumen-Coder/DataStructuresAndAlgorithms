package Tree;

public class LowestCommonAncestor {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.data = data;
            this.left = null;
            this.right= null;
        }
    }
    private TreeNode root;

    LowestCommonAncestor(){
        this.root=null;
    }

    public static void main(String[] args) {
        LowestCommonAncestor lca = new LowestCommonAncestor();
        lca.root = new TreeNode(1);
        lca.root.left = new TreeNode(2);
        lca.root.right = new TreeNode(3);
        lca.root.right.left = new TreeNode(4);
        lca.root.right.right = new TreeNode(5);
        lca.root.right.left.left = new TreeNode(8);
        lca.root.right.right.left = new TreeNode(6);
        lca.root.right.right.right = new TreeNode(7);

        TreeNode result = lowestCommonAncestor(lca.root, lca.root.right.right.right, lca.root.right.left.left);
        System.out.println(result.data);
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(null==root || root==p || root==q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(null==left){
            return right;
        }else
        if(null==right){
            return left;
        }else {
            return root;
        }
    }
}
