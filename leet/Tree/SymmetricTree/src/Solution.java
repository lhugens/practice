import com.sun.source.tree.Tree;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isSymmetric(TreeNode root) {
        return root == null || isMirror(root.left, root.right);
    }

    private static boolean isMirror(TreeNode left, TreeNode right){
       if(left == null && right == null){
           return true;
       }
       if(left == null || right == null){
           return false;
       }

       return (left.val == right.val) && isMirror(left.left, right.right) && isMirror(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root;

        root = new TreeNode(1, new TreeNode(2, new TreeNode(3),
                new TreeNode(4)), new TreeNode(2, new TreeNode(4), new TreeNode(3)));

        System.out.println(isSymmetric(root) ? "Symmetric tree" : "Not symmetric tree");

        root = new TreeNode(1, new TreeNode(2, null,
                new TreeNode(3)), new TreeNode(2, null, new TreeNode(3)));

        System.out.println(isSymmetric(root) ? "Symmetric tree" : "Not symmetric tree");
    }
}
