package Tree;

public class SearchInBST {
    TreeNode root;
    SearchInBST(){
        this.root=null;
    }
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
        }
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if(null==root)return null;
        return search(root,val);
    }

    public TreeNode search(TreeNode root, int val){
        if(null==root)return null;
        if(root.val==val)return root;
        else {
            if(val<root.val){
                return search(root.left, val);
            }
            return search(root.right, val);
        }
    }

    public static void main(String[] args) {
        SearchInBST tree = new SearchInBST();
        tree.root= new TreeNode(4);
        tree.root.left= new TreeNode(2);
        tree.root.left.left= new TreeNode(1);
        tree.root.left.right= new TreeNode(3);
        tree.root.right= new TreeNode(7);

        TreeNode node = tree.searchBST(tree.root, 2);
        System.out.println(node.val);

    }
}
