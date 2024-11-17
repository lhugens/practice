import java.util.Stack;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(){}

        TreeNode(int val){
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static boolean isValidBST(TreeNode root){
        return isValidBST(root, null, null);
    }

    public static boolean isValidBST(TreeNode node, Integer min, Integer max){
        if(node == null){
            return true;
        }

        if((min != null && node.val <= min) || (max != null && node.val >= max)){
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

    public static void main(String[] args) {
        TreeNode root;

        root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(root) ? "Valid BST" : "Invalid BST");

        root = new TreeNode(5, new TreeNode(1), new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST(root) ? "Valid BST" : "Invalid BST");

        root = new TreeNode(2, new TreeNode(2), new TreeNode(2));
        System.out.println(isValidBST(root) ? "Valid BST" : "Invalid BST");
    }
}
