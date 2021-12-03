import java.util.Stack;



    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {
        long pre = Long.MIN_VALUE;

        public boolean isValidBST(TreeNode root) {

            if (root == null) return true;

            boolean left = isValidBST(root.left);
            if (root.val <= pre) return false;
            pre = root.val;
            boolean right = isValidBST(root.right);
            return left && right;


/*
            Stack<TreeNode> stack = new Stack<>();

            double temp = -Double.MAX_VALUE;

            if (root == null) return true;

            while (!stack.isEmpty() || root != null) {
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
                root = stack.pop();
                if (root.val <= temp){
                    return false;
                }
                temp = root.val;
                root = root.right;
            }
            return true;

 */

        }
    }
