import com.sun.source.tree.Tree;

import java.util.Stack;

public class Main {
    static class TreeNodeDepth {
        TreeNode node;
        int depth;
        TreeNodeDepth(TreeNode node, int depth){
            this.node = node;
            this.depth = depth;
        }
    }
    public class Solution {
        public static int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }

            Stack<TreeNodeDepth> stack = new Stack<>();
            stack.push(new TreeNodeDepth(root, 1));
            int maxDepth = 0;

            while(!stack.isEmpty()){
                TreeNodeDepth current = stack.pop();
                TreeNode node = current.node;
                int depth = current.depth;

                maxDepth = Math.max(maxDepth, depth);

                if(node.left != null){
                    stack.push(new TreeNodeDepth(node.left, depth + 1));
                }
                if(node.right != null){
                    stack.push(new TreeNodeDepth(node.right, depth + 1));
                }
            }
            return maxDepth;
        }
    }

    public static void main(String[] args) {
        TreeNode root;
        root = new TreeNode(3, new TreeNode(9, null, null), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        root = new TreeNode(1, new TreeNode(2), null);
        int depth = Solution.maxDepth(root);
        System.out.println("Depth: " + depth);
    }
}
